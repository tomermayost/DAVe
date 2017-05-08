package com.deutscheboerse.risk.dave.persistence;

import com.deutscheboerse.risk.dave.healthcheck.HealthCheck;
import com.deutscheboerse.risk.dave.model.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

public class EchoPersistenceService implements PersistenceService {

    private final HealthCheck healthCheck;

    @Inject
    public EchoPersistenceService(Vertx vertx) {
        this.healthCheck = new HealthCheck(vertx);
    }

    @Override
    public void initialize(Handler<AsyncResult<Void>> resultHandler) {
        healthCheck.setComponentReady(HealthCheck.Component.PERSISTENCE_SERVICE);
        resultHandler.handle(Future.succeededFuture());
    }

    @Override
    public void queryAccountMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(AccountMarginModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void queryLiquiGroupMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(LiquiGroupMarginModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void queryLiquiGroupSplitMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(LiquiGroupSplitMarginModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void queryPoolMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(PoolMarginModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void queryPositionReport(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(PositionReportModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void queryRiskLimitUtilization(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(Future.succeededFuture(echoResponse(RiskLimitUtilizationModel.class.getSimpleName(), type.name(), query)));
    }

    @Override
    public void close() {

    }

    private String echoResponse(String model, String requestType, JsonObject query) {
        return Json.encodePrettily(new JsonArray().add(
                new JsonObject()
                        .put("model", model)
                        .put("requestType", requestType)
                        .mergeIn(query)));
    }
}