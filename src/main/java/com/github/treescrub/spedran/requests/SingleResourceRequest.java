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

/**
 * A request to get a single resource from the SRC API.
 *
 * @param <T> a class that represents a resource that will be retrieved from the API
 */
public abstract class SingleResourceRequest<T extends Resource> extends ResourceRequest<T> {
    @SuppressWarnings("unused")
    protected SingleResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
    }

    @SuppressWarnings("unused")
    protected SingleResourceRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    /**
     * Starts executing the request and returns a {@link CompletableFuture} that will complete with the resulting resource object.
     *
     * @return a {@code CompletableFuture} with the resource
     */
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
        Constructor<T> constructor = dataClass.getDeclaredConstructor(JSONObject.class);
        constructor.setAccessible(true);

        return constructor.newInstance(data);
    }

    protected abstract Class<T> getDataClass();
}
