package treescrub.spedran.requests;

import kong.unirest.*;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Resource;
import treescrub.spedran.data.run.Run;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Requests {
    private static final String BASE_URL = "https://www.speedrun.com/api/v1";
    private static final int MAX_ITEMS = 200;

    public static void setup() {
        Unirest.config().defaultBaseUrl(BASE_URL);
    }

    private static CompletableFuture<HttpResponse<JsonNode>> getSingleSimpleObject(String resourceName, String id) {
        return Unirest.get("/{resource}/{id}")
                .routeParam("resource", resourceName)
                .routeParam("id", id)
                .asJsonAsync();
    }

    private static GetRequest getCollectionRequest(String resourceName, Map<String, Object> parameters) {
        return Unirest.get("/{resource}")
                .routeParam("resource", resourceName)
                .queryString(parameters)
                .queryString("max", MAX_ITEMS);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getGame(String id) {
        return getSingleSimpleObject("games", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getLevel(String id) {
        return getSingleSimpleObject("levels", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getCategory(String id) {
        return getSingleSimpleObject("categories", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getPlatform(String id) {
        return getSingleSimpleObject("platforms", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getGenre(String id) {
        return getSingleSimpleObject("genres", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getEngine(String id) {
        return getSingleSimpleObject("engines", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getGametype(String id) {
        return getSingleSimpleObject("gametypes", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getDeveloper(String id) {
        return getSingleSimpleObject("developers", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getRegion(String id) {
        return getSingleSimpleObject("regions", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getRun(String id) {
        return getSingleSimpleObject("runs", id);
    }

    private static <T extends Resource> List<T> collectResources(PagedList<JsonNode> pagedList, Function<JSONObject, T> constructor) {
        List<T> runs = new ArrayList<>();

        for(JsonNode body : pagedList.getBodies()) {
            JSONArray data = body.getObject().getJSONArray("data");
            for(int i = 0; i < data.length(); i++) {
                runs.add(constructor.apply(data.getJSONObject(i)));
            }
        }

        return runs;
    }

    private static Function<HttpResponse<JsonNode>, String> getLinkExtractor() {
        return response -> {
            JSONObject body = response.getBody().getObject();

            if (!body.has("pagination"))
                return null;

            JSONArray links = body.getJSONObject("pagination").getJSONArray("links");
            for (int i = 0; i < links.length(); i++) {
                JSONObject link = links.getJSONObject(i);

                if (link.getString("rel").equals("next")) {
                    return link.getString("uri");
                }
            }

            return null;
        };
    }

    public static CompletableFuture<List<Run>> getRuns(Map<String, Object> parameters) {
        PagedList<JsonNode> runs = getCollectionRequest("runs", parameters)
                .asPaged(HttpRequest::asJson, getLinkExtractor());

        runs.ifFailure(response -> {

        });

        return CompletableFuture.completedFuture(collectResources(runs, Run::new));
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getSeries(String id) {
        return getSingleSimpleObject("series", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getUser(String id) {
        return getSingleSimpleObject("users", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getGuest(String id) {
        return getSingleSimpleObject("guests", id);
    }

    public static CompletableFuture<HttpResponse<JsonNode>> getVariable(String id) {
        return getSingleSimpleObject("variables", id);
    }
}
