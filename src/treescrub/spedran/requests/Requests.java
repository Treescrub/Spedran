package treescrub.spedran.requests;

import kong.unirest.*;
import treescrub.spedran.api.request.category.CategoryRecordsRequest;
import treescrub.spedran.api.request.category.CategoryVariablesRequest;
import treescrub.spedran.api.request.developer.DevelopersRequest;
import treescrub.spedran.api.request.engine.EnginesRequest;
import treescrub.spedran.api.request.game.*;
import treescrub.spedran.api.request.gametype.GametypesRequest;
import treescrub.spedran.api.request.genre.GenresRequest;
import treescrub.spedran.api.request.leaderboard.LeaderboardRequest;
import treescrub.spedran.api.request.level.LevelCategoriesRequest;
import treescrub.spedran.api.request.level.LevelRecordsRequest;
import treescrub.spedran.api.request.level.LevelVariablesRequest;
import treescrub.spedran.api.request.platform.PlatformsRequest;
import treescrub.spedran.api.request.publisher.PublishersRequest;
import treescrub.spedran.api.request.region.RegionsRequest;
import treescrub.spedran.api.request.run.DeleteRunRequest;
import treescrub.spedran.api.request.run.RunPlayersRequest;
import treescrub.spedran.api.request.run.RunStatusRequest;
import treescrub.spedran.api.request.run.RunsRequest;
import treescrub.spedran.api.request.series.AllSeriesRequest;
import treescrub.spedran.api.request.series.SeriesGamesRequest;
import treescrub.spedran.api.request.user.UserPBsRequest;
import treescrub.spedran.api.request.user.UsersRequest;
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
    public static final String BASE_URL = "https://www.speedrun.com/api/v1/";

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
    private static final String RESOURCE_PUBLISHERS = "publishers";

    private static UnirestInstance unirestInstance;

    static {
        setup();
    }

    private static void setup() {
        unirestInstance = Unirest.spawnInstance();
        unirestInstance.config().addDefaultHeader("User-Agent", "Spedran/1.0");
        unirestInstance.config().defaultBaseUrl(BASE_URL);
        unirestInstance.config().interceptor(new LoggingInterceptor());
    }

    public static UnirestInstance getUnirestInstance() {
        return unirestInstance;
    }

    private static <T> CompletableFuture<T> getSingleSimpleObject(GetRequest request, Function<HttpResponse<JsonNode>, T> constructor) {
        return request
                .asJsonAsync()
                .thenApply(constructor);
    }

    private static GetRequest getSimpleResourceRequest(String resourceName, String id, Map<String, Object> queryParameters) {
        Map<String, Object> routeParams = new HashMap<>();
        routeParams.put("resource", resourceName);
        routeParams.put("id", id);

        return unirestInstance.get("{resource}/{id}")
                .routeParam(routeParams)
                .queryString(queryParameters);
    }

    public static CompletableFuture<Game> getGame(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GAMES, id, new HashMap<>());

        return getSingleSimpleObject(request, Game::new);
    }

    public static GameCategoriesRequest getGameCategories(String gameId) {
        return new GameCategoriesRequest(gameId);
    }

    public static GameLevelsRequest getGameLevels(String gameId) {
        return new GameLevelsRequest(gameId);
    }

    public static GameRecordsRequest getGameRecords(String gameId) {
        return new GameRecordsRequest(gameId);
    }

    public static GameRomhacksRequest getGameRomhacks(String gameId) {
        return new GameRomhacksRequest(gameId);
    }

    public static GameVariablesRequest getGameVariables(String gameId) {
        return new GameVariablesRequest(gameId);
    }

    public static GamesRequest getGames() {
        return new GamesRequest();
    }

    public static CompletableFuture<Level> getLevel(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_LEVELS, id, new HashMap<>());

        return getSingleSimpleObject(request, Level::new);
    }

    public static LevelCategoriesRequest getLevelCategories(String levelId) {
        return new LevelCategoriesRequest(levelId);
    }

    public static LevelRecordsRequest getLevelRecords(String levelId) {
        return new LevelRecordsRequest(levelId);
    }

    public static LevelVariablesRequest getLevelVariables(String levelId) {
        return new LevelVariablesRequest(levelId);
    }

    public static CompletableFuture<Category> getCategory(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_CATEGORIES, id, new HashMap<>());

        return getSingleSimpleObject(request, Category::new);
    }

    public static CategoryRecordsRequest getCategoryRecords(String categoryId) {
        return new CategoryRecordsRequest(categoryId);
    }

    public static CategoryVariablesRequest getCategoryVariables(String categoryId) {
        return new CategoryVariablesRequest(categoryId);
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_PLATFORMS, id, new HashMap<>());

        return getSingleSimpleObject(request, Platform::new);
    }

    public static PlatformsRequest getPlatforms() {
        return new PlatformsRequest();
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GENRES, id, new HashMap<>());

        return getSingleSimpleObject(request, Genre::new);
    }

    public static GenresRequest getGenres() {
        return new GenresRequest();
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_ENGINES, id, new HashMap<>());

        return getSingleSimpleObject(request, Engine::new);
    }

    public static EnginesRequest getEngines() {
        return new EnginesRequest();
    }

    public static CompletableFuture<Gametype> getGametype(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GAMETYPES, id, new HashMap<>());

        return getSingleSimpleObject(request, Gametype::new);
    }

    public static GametypesRequest getGametypes() {
        return new GametypesRequest();
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_DEVELOPERS, id, new HashMap<>());

        return getSingleSimpleObject(request, Developer::new);
    }

    public static DevelopersRequest getDevelopers() {
        return new DevelopersRequest();
    }

    public static CompletableFuture<Region> getRegion(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_REGIONS, id, new HashMap<>());

        return getSingleSimpleObject(request, Region::new);
    }

    public static RegionsRequest getRegions() {
        return new RegionsRequest();
    }

    public static CompletableFuture<Run> getRun(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_RUNS, id, new HashMap<>());

        return getSingleSimpleObject(request, Run::new);
    }

    public static DeleteRunRequest deleteRun(String runId, String apiKey) {
        return new DeleteRunRequest(runId, apiKey);
    }

    public static RunPlayersRequest getRunPlayers(String runId) {
        return new RunPlayersRequest(runId);
    }

    public static RunStatusRequest setRunStatus(String runId) {
        return new RunStatusRequest(runId);
    }

    public static RunsRequest getRuns() {
        return new RunsRequest();
    }

    public static CompletableFuture<Series> getSeries(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_SERIES, id, new HashMap<>());

        return getSingleSimpleObject(request, Series::new);
    }

    public static SeriesGamesRequest getSeriesGames(String seriesId) {
        return new SeriesGamesRequest(seriesId);
    }

    public static AllSeriesRequest getSeries() {
        return new AllSeriesRequest();
    }

    public static CompletableFuture<User> getUser(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_USERS, id, new HashMap<>());

        return getSingleSimpleObject(request, User::new);
    }

    public static UsersRequest getUsers() {
        return new UsersRequest();
    }

    public static UserPBsRequest getUserPBs(String userId) {
        return new UserPBsRequest(userId);
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_VARIABLES, id, new HashMap<>());

        return getSingleSimpleObject(request, Variable::new);
    }

    public static CompletableFuture<Guest> getGuest(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_GUESTS, id, new HashMap<>());

        return getSingleSimpleObject(request, Guest::new);
    }

    public static CompletableFuture<Publisher> getPublisher(String id) {
        GetRequest request = getSimpleResourceRequest(RESOURCE_PUBLISHERS, id, Map.of());

        return getSingleSimpleObject(request, Publisher::new);
    }

    public static PublishersRequest getPublishers() {
        return new PublishersRequest();
    }

    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        if(levelId == null) {
            return new LeaderboardRequest(gameId, categoryId);
        } else {
            return new LeaderboardRequest(gameId, categoryId, levelId);
        }
    }

    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return getLeaderboard(gameId, categoryId, null);
    }

    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return getLeaderboard(game.getId(), category.getId());
    }

    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return getLeaderboard(game.getId(), category.getId(), level.getId());
    }
}
