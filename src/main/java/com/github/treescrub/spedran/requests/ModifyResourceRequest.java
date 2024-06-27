package com.github.treescrub.spedran.requests;

import com.github.treescrub.spedran.data.Resource;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ModifyResourceRequest<T extends Resource> extends SingleResourceRequest<T> {
    protected ModifyResourceRequest(HttpMethod method, String url) {
        super(method, url);
    }

    protected ModifyResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
    }

    protected abstract JSONElement buildBody() throws InvalidBuilderStateException;

    @Override
    public CompletableFuture<T> complete() {
        try {
            JSONElement body = buildBody();

            if(body != null) {
                request.body(body);
            }

            return super.complete();
        } catch (InvalidBuilderStateException e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
