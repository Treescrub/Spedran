package treescrub.spedran.requests;

import kong.unirest.*;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.*;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.user.User;
import treescrub.spedran.data.variables.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Requests {
    private static final String BASE_URL = "https://www.speedrun.com/api/v1";
    private static final int MAX_ITEMS = 200;

    private static final String RESOURCE_GAMES = "games";
    private static final String RESOURCE_LEVELS = "levels";
    private static final String RESOURCE_CATEGORIES = "categories";
    private static final String RESOURCE_PLATFORMS = "platforms";
    private static final String RESOURCE_GENRES = "genres";
    private static final String RESOURCE_ENGINES = "engines";
    private static final String RESOURCE_GAMETYPES = "gametypes";
    private static final String RESOURCE_DEVELOPERS = "developers";
    private static final String RESOURCE_REGIONS = "regions";
    private static final String RESOURCE_RUNS = "runs";
    private static final String RESOURCE_SERIES = "series";
    private static final String RESOURCE_USERS = "users";
    private static final String RESOURCE_VARIABLES = "variables";
    private static final String RESOURCE_GUESTS = "guests";

    public static void setup() {
        Unirest.config().defaultBaseUrl(BASE_URL);
    }

    private static <T> CompletableFuture<T> getSingleSimpleObject(String resourceName, Function<HttpResponse<JsonNode>, T> constructor, String id) {
        return Unirest.get("/{resource}/{id}")
                .routeParam("resource", resourceName)
                .routeParam("id", id)
                .asJsonAsync().thenApply(constructor);
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

    private static String extractPaginationLink(HttpResponse<JsonNode> response) {
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
    }

    private static GetRequest getCollectionRequest(String resourceName, Map<String, Object> parameters) {
        return Unirest.get("/{resource}")
                .routeParam("resource", resourceName)
                .queryString(parameters)
                .queryString("max", MAX_ITEMS);
    }

    private static <T extends Resource> CompletableFuture<List<T>> getCollection(String resourceName, Function<JSONObject, T> constructor, Map<String, Object> parameters) {
        return CompletableFuture.supplyAsync(() -> {
            PagedList<JsonNode> resources = getCollectionRequest(resourceName, parameters)
                    .asPaged(HttpRequest::asJson, Requests::extractPaginationLink);

            resources.ifFailure(response -> {
                System.out.println(getCollectionRequest(resourceName, parameters).toSummary().asString());
                System.out.println("request failed with " + response.getStatus());
            });

            return collectResources(resources, constructor);
        });
    }

    public static CompletableFuture<Game> getGame(String id) {
        return getSingleSimpleObject(RESOURCE_GAMES, Game::new, id);
    }

    public static CompletableFuture<List<Game>> getGames(Map<String, Object> parameters) {
        return getCollection(RESOURCE_GAMES, Game::new, parameters);
    }

    public static CompletableFuture<Level> getLevel(String id) {
        return getSingleSimpleObject(RESOURCE_LEVELS, Level::new, id);
    }

    public static CompletableFuture<Category> getCategory(String id) {
        return getSingleSimpleObject(RESOURCE_CATEGORIES, Category::new, id);
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        return getSingleSimpleObject(RESOURCE_PLATFORMS, Platform::new, id);
    }

    public static CompletableFuture<List<Platform>> getPlatforms(Map<String, Object> parameters) {
        return getCollection(RESOURCE_PLATFORMS, Platform::new, parameters);
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        return getSingleSimpleObject(RESOURCE_GENRES, Genre::new, id);
    }

    public static CompletableFuture<List<Genre>> getGenres(Map<String, Object> parameters) {
        return getCollection(RESOURCE_GENRES, Genre::new, parameters);
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        return getSingleSimpleObject(RESOURCE_ENGINES, Engine::new, id);
    }

    public static CompletableFuture<List<Engine>> getEngines(Map<String, Object> parameters) {
        return getCollection(RESOURCE_ENGINES, Engine::new, parameters);
    }
    public static CompletableFuture<Gametype> getGametype(String id) {
        return getSingleSimpleObject(RESOURCE_GAMETYPES, Gametype::new, id);
    }

    public static CompletableFuture<List<Gametype>> getGametypes(Map<String, Object> parameters) {
        return getCollection(RESOURCE_GAMETYPES, Gametype::new, parameters);
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        return getSingleSimpleObject(RESOURCE_DEVELOPERS, Developer::new, id);
    }

    public static CompletableFuture<List<Developer>> getDevelopers(Map<String, Object> parameters) {
        return getCollection(RESOURCE_DEVELOPERS, Developer::new, parameters);
    }

    public static CompletableFuture<Region> getRegion(String id) {
        return getSingleSimpleObject(RESOURCE_REGIONS, Region::new, id);
    }

    public static CompletableFuture<List<Region>> getRegions(Map<String, Object> parameters) {
        return getCollection(RESOURCE_REGIONS, Region::new, parameters);
    }

    public static CompletableFuture<Run> getRun(String id) {
        return getSingleSimpleObject(RESOURCE_RUNS, Run::new, id);
    }

    public static CompletableFuture<List<Run>> getRuns(Map<String, Object> parameters) {
        return getCollection(RESOURCE_RUNS, Run::new, parameters);
    }

    public static CompletableFuture<Series> getSeries(String id) {
        return getSingleSimpleObject(RESOURCE_SERIES, Series::new, id);
    }

    public static CompletableFuture<List<Series>> getSeries(Map<String, Object> parameters) {
        return getCollection(RESOURCE_SERIES, Series::new, parameters);
    }

    public static CompletableFuture<User> getUser(String id) {
        return getSingleSimpleObject(RESOURCE_USERS, User::new, id);
    }

    public static CompletableFuture<List<User>> getUsers(Map<String, Object> parameters) {
        return getCollection(RESOURCE_USERS, User::new, parameters);
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        return getSingleSimpleObject(RESOURCE_VARIABLES, Variable::new, id);
    }

    public static CompletableFuture<Guest> getGuest(String id) {
        return getSingleSimpleObject(RESOURCE_GUESTS, Guest::new, id);
    }
}
