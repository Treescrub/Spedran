package com.github.treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.RequestQueue;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class SingleResourceRequest<T> extends ResourceRequest<T> {
    protected SingleResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
    }

    protected SingleResourceRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    @Override
    public CompletableFuture<T> complete() {
        applyQueryParameters();
        RequestQueue.queueRequest(this);

        return result;
    }

    @Override
    public HttpResponse<JsonNode> executeBlocking() {
        return request.asJson();
    }

    @Override
    public void finishRequest(Object body) {
        completed = true;
        // Complete async so that we aren't on the same thread as the RequestQueue
        result.completeAsync(() -> parse(((JsonNode) body).getObject().getJSONObject("data")));
    }

    protected abstract T parse(JSONObject data);
}
