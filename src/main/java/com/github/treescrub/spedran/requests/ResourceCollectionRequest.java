package com.github.treescrub.spedran.requests;

import com.github.treescrub.spedran.data.Resource;
import kong.unirest.HttpMethod;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ResourceCollectionRequest<T extends Resource> extends ResourceRequest<List<T>> {
    private static final int MAX_ITEMS = 200;
    private List<JsonNode> responseBodies = new ArrayList<>();

    protected ResourceCollectionRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
        setParameter("max", MAX_ITEMS);
    }

    protected ResourceCollectionRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    protected static String extractPaginationLink(JSONObject body) {
        if (!body.has("pagination"))
            return null;

        JSONArray links = body.getJSONObject("pagination").getJSONArray("links");
        for(Object element : links) {
            JSONObject link = (JSONObject) element;

            if (link.getString("rel").equals("next")) {
                return link.getString("uri");
            }
        }

        return null;
    }

    private static <T extends Resource> List<T> removeDuplicates(List<T> resources) {
        return new ArrayList<>(new LinkedHashSet<>(resources));
    }

    private List<T> collectResources() {
        List<T> resources = new ArrayList<>();

        for(JsonNode body : responseBodies) {
            JSONArray data = body.getObject().getJSONArray("data");

            for(Object element : data) {
                try {
                    resources.add(parse((JSONObject) element));
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // The API sometimes returns duplicate resources in a collection
        return removeDuplicates(resources);
    }

    @Override
    protected void applyQueryParameters() {
        super.applyQueryParameters();
    }

    @Override
    void finishRequest(Object body) {
        JsonNode jsonBody = ((JsonNode) body);
        responseBodies.add(jsonBody);
        String nextLink = extractPaginationLink(jsonBody.getObject());

        if(nextLink == null) {
            completed = true;
            // Complete async so that we aren't on the same thread as the RequestQueue
            result.completeAsync(this::collectResources);
            return;
        }

        request = Requests.request(request.getHttpMethod(), nextLink);
    }

    @Override
    HttpResponse<?> executeBlocking() {
        return request.asJson();
    }

    /**
     * Starts executing the request and returns a {@link CompletableFuture} that will complete with the resulting list of resource objects.
     *
     * @return a {@code CompletableFuture} with a list of resources
     */
    @Override
    public CompletableFuture<List<T>> complete() {
        applyQueryParameters();
        Requests.sendRequest(this);

        return result;
    }

    protected void setSortParameter(String sortParameter) {
        setParameter("orderby", sortParameter);
    }

    protected void setSortDirection(SortDirection direction) {
        setParameter("direction", direction.toParameter());
    }

    private T parse(JSONObject data) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<T> dataClass = getDataClass();
        Constructor<T> constructor = dataClass.getDeclaredConstructor(JSONObject.class);
        constructor.setAccessible(true);

        return constructor.newInstance(data);
    }

    protected abstract Class<T> getDataClass();
}
