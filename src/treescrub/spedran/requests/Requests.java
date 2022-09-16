package treescrub.spedran.requests;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.concurrent.CompletableFuture;

public class Requests {
    private static final String BASE_URL = "https://www.speedrun.com/api/v1";

    public static void setup() {
        Unirest.config().defaultBaseUrl(BASE_URL);
    }

    private static CompletableFuture<HttpResponse<JsonNode>> getSingleSimpleObject(String resourceName, String id) {
        return Unirest.get("/{resource}/{id}")
                .routeParam("resource", resourceName)
                .routeParam("id", id)
                .asJsonAsync();
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
