package treescrub.spedran.api;

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
import treescrub.spedran.requests.Requests;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class Spedran {
    /**
     * Sets the current API key.
     *
     * @param key SRC API key
     */
    public static void setApiKey(String key) {
        Requests.getUnirestInstance().config().addDefaultHeader("X-Api-Key", key);
    }

    /**
     * Identical to {@link Spedran#clearApiKey()}
     */
    public static void removeApiKey() {
        setApiKey("");
    }

    /**
     * Clears the current API key.
     */
    public static void clearApiKey() {
        removeApiKey();
    }

    /**
     *
     *
     * @param id ID of the game to get
     * @return a CompletableFuture of a game
     */
    public static CompletableFuture<Game> getGame(String id) {
        return Requests.getGame(id);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameCategoriesRequest getGameCategories(String gameId) {
        return Requests.getGameCategories(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameLevelsRequest getGameLevels(String gameId) {
        return Requests.getGameLevels(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameRecordsRequest getGameRecords(String gameId) {
        return Requests.getGameRecords(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameRomhacksRequest getGameRomhacks(String gameId) {
        return Requests.getGameRomhacks(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameVariablesRequest getGameVariables(String gameId) {
        return Requests.getGameVariables(gameId);
    }

    /**
     *
     * @return
     */
    public static GamesRequest getGames() {
        return Requests.getGames();
    }

    /**
     *
     * @param id ID of the run to get
     * @return a CompletableFuture of a run
     */
    public static CompletableFuture<Run> getRun(String id) {
        return Requests.getRun(id);
    }

    /**
     *
     * @param runId
     * @param apiKey
     * @return
     */
    public static DeleteRunRequest deleteRun(String runId, String apiKey) {
        return Requests.deleteRun(runId, apiKey);
    }

    /**
     *
     * @param runId
     * @return
     */
    public static RunPlayersRequest getRunPlayers(String runId) {
        return Requests.getRunPlayers(runId);
    }

    /**
     *
     * @param runId
     * @return
     */
    public static RunStatusRequest setRunStatus(String runId) {
        return Requests.setRunStatus(runId);
    }

    /**
     *
     * @return
     */
    public static RunsRequest getRuns() {
        return Requests.getRuns();
    }

    /**
     *
     * @param id ID of the category to get
     * @return a CompletableFuture of a category
     */
    public static CompletableFuture<Category> getCategory(String id) {
        return Requests.getCategory(id);
    }

    /**
     *
     * @param categoryId
     * @return
     */
    public static CategoryRecordsRequest getCategoryRecords(String categoryId) {
        return Requests.getCategoryRecords(categoryId);
    }

    /**
     *
     * @param categoryId
     * @return
     */
    public static CategoryVariablesRequest getCategoryVariables(String categoryId) {
        return Requests.getCategoryVariables(categoryId);
    }

    /**
     *
     * @param id ID of the level to get
     * @return a CompletableFuture of a level
     */
    public static CompletableFuture<Level> getLevel(String id) {
        return Requests.getLevel(id);
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelCategoriesRequest getLevelCategories(String levelId) {
        return Requests.getLevelCategories(levelId);
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelRecordsRequest getLevelRecords(String levelId) {
        return Requests.getLevelRecords(levelId);
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelVariablesRequest getLevelVariables(String levelId) {
        return Requests.getLevelVariables(levelId);
    }

    /**
     *
     * @param id ID of the variable to get
     * @return a CompletableFuture of a variable
     */
    public static CompletableFuture<Variable> getVariable(String id) {
        return Requests.getVariable(id);
    }

    /**
     *
     * @param id ID of the user to get
     * @return a CompletableFuture of a user
     */
    public static CompletableFuture<User> getUser(String id) {
        return Requests.getUser(id);
    }

    /**
     *
     * @return
     */
    public static UsersRequest getUsers() {
        return Requests.getUsers();
    }

    /**
     *
     * @param userId
     * @return
     */
    public static UserPBsRequest getUserPBs(String userId) {
        return Requests.getUserPBs(userId);
    }

    /**
     *
     * @param name name of the guest to get
     * @return a CompletableFuture of a guest
     */
    public static CompletableFuture<Guest> getGuest(String name) {
        return Requests.getGuest(name);
    }

    /**
     *
     * @param id ID of the genre to get
     * @return a CompletableFuture of a genre
     */
    public static CompletableFuture<Genre> getGenre(String id) {
        return Requests.getGenre(id);
    }

    /**
     *
     * @return
     */
    public static GenresRequest getGenres() {
        return Requests.getGenres();
    }

    /**
     *
     * @param id ID of the engine to get
     * @return a CompletableFuture of an engine
     */
    public static CompletableFuture<Engine> getEngine(String id) {
        return Requests.getEngine(id);
    }

    /**
     *
     * @return
     */
    public static EnginesRequest getEngines() {
        return Requests.getEngines();
    }

    /**
     *
     * @param id ID of the gametype to get
     * @return a CompletableFuture of a gametype
     */
    public static CompletableFuture<Gametype> getGametype(String id) {
        return Requests.getGametype(id);
    }

    /**
     *
     * @return
     */
    public static GametypesRequest getGametypes() {
        return Requests.getGametypes();
    }

    /**
     *
     * @param id ID of the developer to get
     * @return a CompletableFuture of a developer
     */
    public static CompletableFuture<Developer> getDeveloper(String id) {
        return Requests.getDeveloper(id);
    }

    /**
     *
     * @return
     */
    public static DevelopersRequest getDevelopers() {
        return Requests.getDevelopers();
    }

    /**
     *
     * @param id ID of the region to get
     * @return a CompletableFuture of a region
     */
    public static CompletableFuture<Region> getRegion(String id) {
        return Requests.getRegion(id);
    }

    /**
     *
     * @return
     */
    public static RegionsRequest getRegions() {
        return Requests.getRegions();
    }

    /**
     *
     * @param id ID of the series to get
     * @return a CompletableFuture of a series
     */
    public static CompletableFuture<Series> getSingleSeries(String id) {
        return Requests.getSeries(id);
    }

    /**
     *
     * @param seriesId
     * @return
     */
    public static SeriesGamesRequest getSeriesGames(String seriesId) {
        return Requests.getSeriesGames(seriesId);
    }

    /**
     *
     * @return
     */
    public static AllSeriesRequest getMultipleSeries() {
        return Requests.getSeries();
    }

    /**
     *
     * @param id ID of the platform to get
     * @return a CompletableFuture of a platform
     */
    public static CompletableFuture<Platform> getPlatform(String id) {
        return Requests.getPlatform(id);
    }

    /**
     *
     * @return
     */
    public static PlatformsRequest getPlatforms() {
        return Requests.getPlatforms();
    }

    /**
     *
     * @param id ID of the publisher to get
     * @return a CompletableFuture of a publisher
     */
    public static CompletableFuture<Publisher> getPublisher(String id) {
        return Requests.getPublisher(id);
    }

    /**
     *
     * @return
     */
    public static PublishersRequest getPublishers() {
        return Requests.getPublishers();
    }

    /**
     *
     * @param gameId game ID to filter the leaderboard
     * @param categoryId category ID to filter the leaderboard
     * @param levelId level ID to filter the leaderboard
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return Requests.getLeaderboard(gameId, categoryId, levelId);
    }

    /**
     *
     * @param gameId game ID to filter the leaderboard
     * @param categoryId category ID to filter the leaderboard
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return Requests.getLeaderboard(gameId, categoryId);
    }

    /**
     *
     * @param game game filter
     * @param category category filter
     * @param level level filter
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return Requests.getLeaderboard(game, category, level);
    }

    /**
     *
     * @param game game filter
     * @param category category filter
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return Requests.getLeaderboard(game, category);
    }
}
