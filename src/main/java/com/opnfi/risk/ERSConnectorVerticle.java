package com.opnfi.risk;

import com.opnfi.risk.common.OpnFiConfig;
import com.opnfi.risk.model.procesor.MarginComponentProcesor;
import com.opnfi.risk.model.procesor.MarginShortfallSurplusProcesor;
import com.opnfi.risk.model.procesor.TotalMarginRequirementProcessor;
import com.opnfi.risk.model.procesor.TradingSessionStatusProcesor;
import io.vertx.camel.CamelBridge;
import io.vertx.camel.CamelBridgeOptions;
import io.vertx.camel.InboundMapping;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.util.UUID;
import org.aeonbits.owner.ConfigCache;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.qpid.client.AMQConnectionFactory;
import org.apache.qpid.url.URLSyntaxException;


/**
 * Created by schojak on 17.8.16.
 */
public class ERSConnectorVerticle extends AbstractVerticle {
    final static private Logger LOG = LoggerFactory.getLogger(ERSConnectorVerticle.class);
    final OpnFiConfig config = ConfigCache.getOrCreate(OpnFiConfig.class);

    private CamelContext camelCtx;
    private CamelBridge camelBridge;

    @Override
    public void start(Future<Void> fut) {
        startCamel(
                (nothing) -> startCamelBridge(fut),
                fut
        );
    }

    public void startCamel(Handler<AsyncResult<Void>> next, Future<Void> fut)
    {
        camelCtx = new DefaultCamelContext();

        try {
            String connectionAddress = String.format("amqp://:@MyCamelApp/?brokerlist='%s:%d?tcp_nodelay='true'&ssl='true'&ssl_cert_alias='%s'&sasl_mechs='EXTERNAL'&trust_store='%s'&trust_store_password='%s'&key_store='%s'&key_store_password='%s'&ssl_verify_hostname='false''&sync_publish='all'",
                    config.ersBrokerHost(), config.ersBrokerPort(), config.sslCertAlias(),
                    config.truststore(), config.truststorePassword(),
                    config.keystore(), config.keystorePassword());
            AMQConnectionFactory amqpFact = new AMQConnectionFactory(connectionAddress);
            camelCtx.addComponent("amqp", new AMQPComponent(amqpFact));
        } catch (URLSyntaxException e) {
            LOG.error("Failed to create AMQP Connection Factory", e);
            fut.fail(e);
        }

        try {
            camelCtx.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    final JaxbDataFormat ersDataModel = new JaxbDataFormat(true);
                    final UUID addressSuffix = UUID.randomUUID();
                    ersDataModel.setContextPath("com.opnfi.risk.model.jaxb");

                    String tssBroadcastAddress = getBroadcastAddress("eurex.tmp.CBKFR.opnfi_tss_" + addressSuffix,
                            "public.MessageType.TradingSessionStatus.#");
                    String mcBroadcastAddress = getBroadcastAddress("eurex.tmp.CBKFR.opnfi_mc_" + addressSuffix,
                            "CBKFR.MessageType.MarginComponents.#");
                    String tmrBroadcastAddress = getBroadcastAddress("eurex.tmp.CBKFR.opnfi_tmr_" + addressSuffix,
                            "CBKFR.MessageType.TotalMarginRequirement.#");
                    String mssBroadcastAddress = getBroadcastAddress("eurex.tmp.CBKFR.opnfi_mss_" + addressSuffix,
                            "CBKFR.MessageType.MarginShortfallSurplus.#");

                    from("amqp:" + tssBroadcastAddress).unmarshal(ersDataModel).process(new TradingSessionStatusProcesor()).to("direct:tss");
                    from("amqp:" + mcBroadcastAddress).unmarshal(ersDataModel).process(new MarginComponentProcesor()).to("direct:mc");
                    from("amqp:" + tmrBroadcastAddress).unmarshal(ersDataModel).process(new TotalMarginRequirementProcessor()).to("direct:tmr");
                    from("amqp:" + mssBroadcastAddress).unmarshal(ersDataModel).process(new MarginShortfallSurplusProcesor()).to("direct:mss");
                }
            });
        }
        catch (Exception e)
        {
            LOG.error("Failed to add Camel routes", e);
            fut.fail(e);
        }

        try {
            camelCtx.start();
            next.handle(null);
        }
        catch (Exception e)
        {
            LOG.error("Failed to start Camel", e);
            fut.fail(e);
        }
    }

    private String getBroadcastAddress(String name, String routingKey) {
        return String.format("%s; {create: receiver, assert: never, node: "
                + "{ type: queue, x-declare: { auto-delete: true, exclusive: false, arguments: "
                + "{ 'qpid.policy_type': ring, 'qpid.max_count': 1000, 'qpid.max_size': 1000000, "
                + "'qpid.auto_delete_timeout': 60 } }, x-bindings: [ { exchange: 'eurex.broadcast',"
                + "queue: '%s', key: '%s' } ] } }", name, name, routingKey);
    }

    public void startCamelBridge(Future<Void> fut)
    {
        camelBridge = CamelBridge.create(vertx,
                new CamelBridgeOptions(camelCtx)
                        .addInboundMapping(InboundMapping.fromCamel("direct:tss").toVertx("ers.TradingSessionStatus").usePublish())
                        .addInboundMapping(InboundMapping.fromCamel("direct:mc").toVertx("ers.MarginComponent").usePublish())
                        .addInboundMapping(InboundMapping.fromCamel("direct:tmr").toVertx("ers.TotalMarginRequirement").usePublish())
                        .addInboundMapping(InboundMapping.fromCamel("direct:mss").toVertx("ers.MarginShortfallSurplus").usePublish())
        );

        camelBridge.start();
        fut.complete();
    }

    @Override
    public void stop() throws Exception {
        camelBridge.stop();
        camelCtx.stop();
    }
}
