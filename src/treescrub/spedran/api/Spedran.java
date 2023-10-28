package treescrub.spedran.api;

import treescrub.spedran.api.request.developer.DevelopersRequest;
import treescrub.spedran.api.request.engine.EnginesRequest;
import treescrub.spedran.api.request.game.GamesRequest;
import treescrub.spedran.api.request.gametype.GametypesRequest;
import treescrub.spedran.api.request.genre.GenresRequest;
import treescrub.spedran.api.request.leaderboard.LeaderboardRequest;
import treescrub.spedran.api.request.platform.PlatformsRequest;
import treescrub.spedran.api.request.publisher.PublishersRequest;
import treescrub.spedran.api.request.region.RegionsRequest;
import treescrub.spedran.api.request.run.RunsRequest;
import treescrub.spedran.api.request.series.AllSeriesRequest;
import treescrub.spedran.api.request.user.UsersRequest;
import treescrub.spedran.data.*;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.user.User;
import treescrub.spedran.data.variables.Variable;
import treescrub.spedran.requests.Requests;

import java.util.concurrent.CompletableFuture;

public class Spedran {
    /**
     *
     * @param key SRC API key
     */
    public static void setApiKey(String key) {
        Requests.getUnirestInstance().config().addDefaultHeader("X-Api-Key", key);
    }

    /**
     *
     */
    public static void removeApiKey() {
        setApiKey("");
    }

    /**
     *
     * @param id game ID
     * @return
     */
    public static CompletableFuture<Game> getGame(String id) {
        return Requests.getGame(id);
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
     * @param id run ID
     * @return
     */
    public static CompletableFuture<Run> getRun(String id) {
        return Requests.getRun(id);
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
     * @param id category ID
     * @return
     */
    public static CompletableFuture<Category> getCategory(String id) {
        return Requests.getCategory(id);
    }

    /**
     *
     * @param id level ID
     * @return
     */
    public static CompletableFuture<Level> getLevel(String id) {
        return Requests.getLevel(id);
    }

    /**
     *
     * @param id variable ID
     * @return
     */
    public static CompletableFuture<Variable> getVariable(String id) {
        return Requests.getVariable(id);
    }

    /**
     *
     * @param id user ID
     * @return
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
     * @param name guest name
     * @return
     */
    public static CompletableFuture<Guest> getGuest(String name) {
        return Requests.getGuest(name);
    }

    /**
     *
     * @param id genre ID
     * @return
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
     * @param id engine ID
     * @return
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
     * @param id gametype ID
     * @return
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
     * @param id developer ID
     * @return
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
     * @param id region ID
     * @return
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
     * @param id series ID
     * @return
     */
    public static CompletableFuture<Series> getSingleSeries(String id) {
        return Requests.getSeries(id);
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
     * @param id platform ID
     * @return
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
     * @param id publisher ID
     * @return
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
     * @param gameId game ID
     * @param categoryId category ID
     * @param levelId level ID
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return Requests.getLeaderboard(gameId, categoryId, levelId);
    }

    /**
     *
     * @param gameId game ID
     * @param categoryId category ID
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return Requests.getLeaderboard(gameId, categoryId);
    }

    /**
     *
     * @param game game
     * @param category category
     * @param level level
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return Requests.getLeaderboard(game, category, level);
    }

    /**
     *
     * @param game game
     * @param category category
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return Requests.getLeaderboard(game, category);
    }
}
