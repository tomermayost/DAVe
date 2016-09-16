package com.deutscheboerse.risk.dave.model.processor;

import java.util.Collections;

import com.deutscheboerse.risk.dave.model.jaxb.AbstractMessageT;
import com.deutscheboerse.risk.dave.model.jaxb.FIXML;
import com.deutscheboerse.risk.dave.model.jaxb.MarginAmountBlockT;
import com.deutscheboerse.risk.dave.model.jaxb.MarginRequirementReportMessageT;
import com.deutscheboerse.risk.dave.model.jaxb.PartiesBlockT;
import io.vertx.core.json.JsonObject;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class TotalMarginRequirementProcessor extends AbstractProcessor implements Processor {

    private JsonObject parseFromFIXML(FIXML fixml) {
        JAXBElement<? extends AbstractMessageT> msg = fixml.getMessage();
        MarginRequirementReportMessageT tmrMessage = (MarginRequirementReportMessageT) msg.getValue();

        JsonObject tmr = new JsonObject();
        tmr.put("received", new JsonObject().put("$date", timestampFormatter.format(new Date())));
        tmr.put("reqId", tmrMessage.getID());
        tmr.put("sesId", tmrMessage.getSetSesID().toString());
        tmr.put("rptId", tmrMessage.getRptID());
        tmr.put("txnTm", new JsonObject().put("$date", timestampFormatter.format(tmrMessage.getTxnTm().toGregorianCalendar().getTime())));
        tmr.put("bizDt", new JsonObject().put("$date", timestampFormatter.format(tmrMessage.getBizDt().toGregorianCalendar().getTime())));

        List<PartiesBlockT> parties = tmrMessage.getPty();

        parties.stream().forEach(party -> {
            if (party.getR().intValue() == 4) {
                tmr.put("clearer", party.getID());
                party.getSub().stream()
                        .filter(pool -> "4000".equals(pool.getTyp()))
                        .findFirst()
                        .ifPresent(pool -> tmr.put("pool", pool.getID()));
            } else if (party.getR().intValue() == 1) {
                tmr.put("member", party.getID());
                party.getSub().stream()
                        .filter(account -> "26".equals(account.getTyp()))
                        .findFirst()
                        .ifPresent(account -> tmr.put("account", account.getID()));
            }
        });

        List<MarginAmountBlockT> margins = tmrMessage.getMgnAmt();
        Set<String> typs = new HashSet<>();
        typs.add("2");
        typs.add("3");
        processMarginBlocks(margins, Collections.unmodifiableSet(typs), tmr);

        return tmr;
    }

   @Override
   public void process(Exchange exchange) {
        Message in = exchange.getIn();
        in.setBody(this.parseFromFIXML((FIXML)in.getBody()));
    }
}