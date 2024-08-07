package com.treescrub.spedran;

import com.treescrub.spedran.data.Resource;
import com.treescrub.spedran.requests.InvalidBuilderStateException;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * A request to modify a resource on SRC.
 *
 * @param <T> a class that represents a resource that will be retrieved from the API
 */
public abstract class ModifyResourceRequest<T extends Resource> extends SingleResourceRequest<T> {
    @SuppressWarnings("unused")
    protected ModifyResourceRequest(HttpMethod method, String url) {
        super(method, url);
    }

    @SuppressWarnings("unused")
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
