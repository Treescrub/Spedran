package treescrub.spedran.api.request;

import kong.unirest.*;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Resource;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public abstract class ResourceCollectionRequest<T extends Resource> extends ResourceRequest<List<T>> {
    private static final int MAX_ITEMS = 200;

    protected ResourceCollectionRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
        setParameter("max", MAX_ITEMS);
    }

    protected ResourceCollectionRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    protected static String extractPaginationLink(HttpResponse<JsonNode> response) {
        JSONObject body = response.getBody().getObject();

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

    private static <T extends Resource> List<T> collectResources(PagedList<JsonNode> pagedList, Function<JSONObject, T> constructor) {
        List<T> resources = new ArrayList<>();

        for(JsonNode body : pagedList.getBodies()) {
            JSONArray data = body.getObject().getJSONArray("data");

            for(Object element : data) {
                resources.add(constructor.apply((JSONObject) element));
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
    public CompletableFuture<List<T>> complete() {
        applyQueryParameters();
        return CompletableFuture.supplyAsync(() -> {
            PagedList<JsonNode> resources = request.asPaged(HttpRequest::asJson, ResourceCollectionRequest::extractPaginationLink);

            return collectResources(resources, getConstructor());
        });
    }

    protected void setSortParameter(String sortParameter) {
        setParameter("orderby", sortParameter);
    }

    protected void setSortDirection(SortDirection direction) {
        setParameter("direction", direction.toParameter());
    }

    protected abstract Function<JSONObject, T> getConstructor();
}
