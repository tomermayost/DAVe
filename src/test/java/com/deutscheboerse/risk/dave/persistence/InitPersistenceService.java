package com.deutscheboerse.risk.dave.persistence;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceException;

public class InitPersistenceService implements PersistenceService {
    private final boolean succeeds;
    private boolean initialized = false;

    public InitPersistenceService(boolean succeeds) {
        this.succeeds = succeeds;
    }

    @Override
    public void initialize(Handler<AsyncResult<Void>> resultHandler) {
        if (this.succeeds) {
            this.initialized = true;
            resultHandler.handle(Future.succeededFuture());
        } else {
            this.initialized = false;
            resultHandler.handle(ServiceException.fail(INIT_ERROR, "Init failed"));
        }
    }

    @Override
    public void queryAccountMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void queryLiquiGroupMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void queryLiquiGroupSplitMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void queryPoolMargin(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void queryPositionReport(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void queryRiskLimitUtilization(RequestType type, JsonObject query, Handler<AsyncResult<String>> resultHandler) {
        resultHandler.handle(ServiceException.fail(QUERY_ERROR, "Find is not implemented"));
    }

    @Override
    public void close() {
    }

    public boolean isInitialized() {
        return this.initialized;
    }
}