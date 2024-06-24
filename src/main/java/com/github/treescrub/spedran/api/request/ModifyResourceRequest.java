package com.github.treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;

import java.util.concurrent.CompletableFuture;

public abstract class ModifyResourceRequest<T> extends SingleResourceRequest<T> {
    protected ModifyResourceRequest(HttpMethod method, String url) {
        super(method, url);
    }

    protected abstract JSONElement buildBody();

    @Override
    public CompletableFuture<T> complete() {
        request.body(buildBody());

        return super.complete();
    }
}
