package com.treescrub.spedran;

import com.treescrub.spedran.data.Resource;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * A request to get a collection of resources from the SRC API.
 * <br>
 * Limited to 10,000 items.
 *
 * @param <T> a class that represents resources that will be retrieved from the API and compiled into a list
 */
public abstract class ResourceCollectionRequest<T extends Resource> extends ResourceRequest<List<T>> {
    private static final int MAX_ITEMS = 200;
    private static final int MAX_COLLECTION_SIZE = 10000;
    private final List<JsonNode> responseBodies = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(ResourceCollectionRequest.class);

    @SuppressWarnings("unused")
    protected ResourceCollectionRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
        setParameter("max", MAX_ITEMS);
    }

    @SuppressWarnings("unused")
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
    void finishRequest(Object body) {
        JsonNode jsonBody = ((JsonNode) body);
        responseBodies.add(jsonBody);
        String nextLink = extractPaginationLink(jsonBody.getObject());

        if(nextLink == null) {
            markCompleted();
            return;
        }

        // If we are at the size limit, mark as completed
        if(responseBodies.size() * MAX_ITEMS >= MAX_COLLECTION_SIZE) {
            logger.debug("Hit size limit");
            markCompleted();
            return;
        }

        request = Requests.request(request.getHttpMethod(), nextLink);
    }

    @Override
    HttpResponse<?> executeBlocking() {
        return request.asJson();
    }

    private void markCompleted() {
        completed = true;
        // Complete async so that we aren't on the same thread as the RequestQueue
        result.completeAsync(this::collectResources, Requests.forkJoinPool);
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
