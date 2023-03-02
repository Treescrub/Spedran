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
    public static CompletableFuture<Game> getGame(String id) {
        return Requests.getGame(id);
    }

    public static GamesRequest getGames() {
        return Requests.getGames();
    }

    public static CompletableFuture<Run> getRun(String id) {
        return Requests.getRun(id);
    }

    public static RunsRequest getRuns() {
        return Requests.getRuns();
    }

    public static CompletableFuture<Category> getCategory(String id) {
        return Requests.getCategory(id);
    }

    public static CompletableFuture<Level> getLevel(String id) {
        return Requests.getLevel(id);
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        return Requests.getVariable(id);
    }

    public static CompletableFuture<User> getUser(String id) {
        return Requests.getUser(id);
    }

    public static UsersRequest getUsers() {
        return Requests.getUsers();
    }

    public static CompletableFuture<Guest> getGuest(String name) {
        return Requests.getGuest(name);
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        return Requests.getGenre(id);
    }

    public static GenresRequest getGenres() {
        return Requests.getGenres();
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        return Requests.getEngine(id);
    }

    public static EnginesRequest getEngines() {
        return Requests.getEngines();
    }

    public static CompletableFuture<Gametype> getGametype(String id) {
        return Requests.getGametype(id);
    }

    public static GametypesRequest getGametypes() {
        return Requests.getGametypes();
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        return Requests.getDeveloper(id);
    }

    public static DevelopersRequest getDevelopers() {
        return Requests.getDevelopers();
    }

    public static CompletableFuture<Region> getRegion(String id) {
        return Requests.getRegion(id);
    }

    public static RegionsRequest getRegions() {
        return Requests.getRegions();
    }

    public static CompletableFuture<Series> getSingleSeries(String id) {
        return Requests.getSeries(id);
    }

    public static AllSeriesRequest getMultipleSeries() {
        return Requests.getSeries();
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        return Requests.getPlatform(id);
    }

    public static PlatformsRequest getPlatforms() {
        return Requests.getPlatforms();
    }

    public static CompletableFuture<Publisher> getPublisher(String id) {
        return Requests.getPublisher(id);
    }

    public static PublishersRequest getPublishers() {
        return Requests.getPublishers();
    }

    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return Requests.getLeaderboard(gameId, categoryId, levelId);
    }

    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return Requests.getLeaderboard(gameId, categoryId);
    }

    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return Requests.getLeaderboard(game, category, level);
    }

    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return Requests.getLeaderboard(game, category);
    }
}
