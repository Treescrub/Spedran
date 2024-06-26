package com.github.treescrub.spedran.requests;

import com.github.treescrub.spedran.data.Resource;
import kong.unirest.HttpMethod;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class SingleResourceRequest<T extends Resource> extends ResourceRequest<T> {
    protected SingleResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
    }

    protected SingleResourceRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    @Override
    public CompletableFuture<T> complete() {
        applyQueryParameters();
        Requests.sendRequest(this);

        return result;
    }

    @Override
    HttpResponse<JsonNode> executeBlocking() {
        return request.asJson();
    }

    @Override
    void finishRequest(Object body) {
        completed = true;
        // Complete async so that we aren't on the same thread as the RequestQueue
        result.completeAsync(() -> {
            try {
                return parse(((JsonNode) body).getObject().getJSONObject("data"));
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private T parse(JSONObject data) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<T> dataClass = getDataClass();
        Constructor<T> constructor = dataClass.getConstructor(JSONObject.class);

        return constructor.newInstance(data);
    }

    protected abstract Class<T> getDataClass();
}