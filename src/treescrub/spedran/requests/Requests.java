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

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Requests {
    private static final String BASE_URL = "https://www.speedrun.com/api/v1/";
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

    private static UnirestInstance unirestInstance;

    static {
        setup();
    }

    private static void setup() {
        unirestInstance = Unirest.spawnInstance();
        unirestInstance.config().defaultBaseUrl(BASE_URL);
    }

    public static UnirestInstance getUnirestInstance() {
        return unirestInstance;
    }

    private static <T> CompletableFuture<T> getSingleSimpleObject(GetRequest request, Function<HttpResponse<JsonNode>, T> constructor) {
        return request
                .asJsonAsync()
                .thenApply(constructor);
    }

    private static <T extends Resource> List<T> removeDuplicates(List<T> resources) {
        return new ArrayList<>(new LinkedHashSet<>(resources));
    }

    public static <T extends Resource> List<T> collectResources(PagedList<JsonNode> pagedList, Function<JSONObject, T> constructor) {
        List<T> resources = new ArrayList<>();

        for(JsonNode body : pagedList.getBodies()) {
            JSONArray data = body.getObject().getJSONArray("data");

            for(Object element : data) {
                resources.add(constructor.apply((JSONObject) element));
            }
        }

        return removeDuplicates(resources);
    }

    public static String extractPaginationLink(HttpResponse<JsonNode> response) {
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

    private static GetRequest getSimpleResourceRequest(String resourceName, String id, Map<String, Object> queryParameters) {
        Map<String, Object> routeParams = new HashMap<>();
        routeParams.put("resource", resourceName);
        routeParams.put("id", id);

        return getResourceRequest("{resource}/{id}", routeParams, queryParameters);
    }

    private static GetRequest getResourceRequest(String url, Map<String, Object> routeParams, Map<String, Object> queryParameters) {
        return unirestInstance.get(url)
                .routeParam(routeParams)
                .queryString(queryParameters);
    }

    private static GetRequest getSimpleCollectionRequest(String resourceName, Map<String, Object> queryParameters) {
        return getCollectionRequest(resourceName, new HashMap<>(), queryParameters);
    }

    private static GetRequest getCollectionRequest(String url, Map<String, Object> routeParams, Map<String, Object> queryParameters) {
        return getResourceRequest(url, routeParams, queryParameters)
                .queryString("max", MAX_ITEMS);
    }

    public static <T extends Resource> CompletableFuture<List<T>> getCollection(HttpRequest<?> request, Function<JSONObject, T> constructor) {
        return CompletableFuture.supplyAsync(() -> {
            PagedList<JsonNode> resources = request.asPaged(HttpRequest::asJson, Requests::extractPaginationLink);

            return collectResources(resources, constructor);
        });
    }

    public static CompletableFuture<Game> getGame(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GAMES, id, new HashMap<>());

        return getSingleSimpleObject(request, Game::new);
    }

    public static CompletableFuture<List<Game>> getGames(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_GAMES, queryParameters);

        return getCollection(request, Game::new);
    }

    public static CompletableFuture<Level> getLevel(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_LEVELS, id, new HashMap<>());

        return getSingleSimpleObject(request, Level::new);
    }

    public static CompletableFuture<Category> getCategory(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_CATEGORIES, id, new HashMap<>());

        return getSingleSimpleObject(request, Category::new);
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_PLATFORMS, id, new HashMap<>());

        return getSingleSimpleObject(request, Platform::new);
    }

    public static CompletableFuture<List<Platform>> getPlatforms(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_PLATFORMS, queryParameters);

        return getCollection(request, Platform::new);
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GENRES, id, new HashMap<>());

        return getSingleSimpleObject(request, Genre::new);
    }

    public static CompletableFuture<List<Genre>> getGenres(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_GENRES, queryParameters);

        return getCollection(request, Genre::new);
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_ENGINES, id, new HashMap<>());

        return getSingleSimpleObject(request, Engine::new);
    }

    public static CompletableFuture<List<Engine>> getEngines(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_ENGINES, queryParameters);

        return getCollection(request, Engine::new);
    }
    public static CompletableFuture<Gametype> getGametype(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GAMETYPES, id, new HashMap<>());

        return getSingleSimpleObject(request, Gametype::new);
    }

    public static CompletableFuture<List<Gametype>> getGametypes(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_GAMETYPES, queryParameters);

        return getCollection(request, Gametype::new);
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_DEVELOPERS, id, new HashMap<>());

        return getSingleSimpleObject(request, Developer::new);
    }

    public static CompletableFuture<List<Developer>> getDevelopers(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_DEVELOPERS, queryParameters);

        return getCollection(request, Developer::new);
    }

    public static CompletableFuture<Region> getRegion(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_REGIONS, id, new HashMap<>());

        return getSingleSimpleObject(request, Region::new);
    }

    public static CompletableFuture<List<Region>> getRegions(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_REGIONS, queryParameters);

        return getCollection(request, Region::new);
    }

    public static CompletableFuture<Run> getRun(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_RUNS, id, new HashMap<>());

        return getSingleSimpleObject(request, Run::new);
    }

    public static CompletableFuture<List<Run>> getRuns(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_RUNS, queryParameters);

        return getCollection(request, Run::new);
    }

    public static CompletableFuture<Series> getSeries(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_SERIES, id, new HashMap<>());

        return getSingleSimpleObject(request, Series::new);
    }

    public static CompletableFuture<List<Series>> getSeries(Map<String, Object> parameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_SERIES, parameters);

        return getCollection(request, Series::new);
    }

    public static CompletableFuture<User> getUser(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_USERS, id, new HashMap<>());

        return getSingleSimpleObject(request, User::new);
    }

    public static CompletableFuture<List<User>> getUsers(Map<String, Object> queryParameters) {
        GetRequest request = getSimpleCollectionRequest(RESOURCE_USERS, queryParameters);

        return getCollection(request, User::new);
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_VARIABLES, id, new HashMap<>());

        return getSingleSimpleObject(request, Variable::new);
    }

    public static CompletableFuture<Guest> getGuest(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GUESTS, id, new HashMap<>());

        return getSingleSimpleObject(request, Guest::new);
    }
}
