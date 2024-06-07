package com.github.treescrub.spedran.api;

import com.github.treescrub.spedran.api.request.category.*;
import com.github.treescrub.spedran.api.request.developer.*;
import com.github.treescrub.spedran.api.request.engine.*;
import com.github.treescrub.spedran.api.request.game.*;
import com.github.treescrub.spedran.api.request.gametype.*;
import com.github.treescrub.spedran.api.request.genre.*;
import com.github.treescrub.spedran.api.request.guest.GuestRequest;
import com.github.treescrub.spedran.api.request.leaderboard.LeaderboardRequest;
import com.github.treescrub.spedran.api.request.level.*;
import com.github.treescrub.spedran.api.request.platform.*;
import com.github.treescrub.spedran.api.request.publisher.*;
import com.github.treescrub.spedran.api.request.region.*;
import com.github.treescrub.spedran.api.request.run.*;
import com.github.treescrub.spedran.api.request.series.*;
import com.github.treescrub.spedran.api.request.user.*;
import com.github.treescrub.spedran.api.request.variable.VariableRequest;
import com.github.treescrub.spedran.data.*;
import com.github.treescrub.spedran.data.category.Category;
import com.github.treescrub.spedran.data.game.Game;
import com.github.treescrub.spedran.data.run.Run;
import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.data.variables.Variable;
import com.github.treescrub.spedran.requests.Requests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class Spedran {
    private static final Logger logger = LogManager.getLogger(Spedran.class);

    /**
     * Sets the current API key.
     * The API key is not set if it is {@code null} or blank.
     *
     * @param key SRC API key
     */
    public static void setApiKey(String key) {
        if(key == null) {
            logger.warn("Attempted to set SRC API key with a null string");
            return;
        }
        if(key.isBlank()) {
            logger.warn("Attempted to set SRC API key with a blank string");
            return;
        }
        if(!key.chars().allMatch(character -> character > 32 && character < 127)) {
            logger.warn("Setting SRC API key with key that contains non-ascii or non-printable characters");
        }

        Requests.setKey(key);
    }

    /**
     * Identical to {@link Spedran#clearApiKey()}
     */
    public static void removeApiKey() {
        Requests.clearKey();
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
        return new GameRequest(id).complete();
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameCategoriesRequest getGameCategories(String gameId) {
        return new GameCategoriesRequest(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameLevelsRequest getGameLevels(String gameId) {
        return new GameLevelsRequest(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameRecordsRequest getGameRecords(String gameId) {
        return new GameRecordsRequest(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameRomhacksRequest getGameRomhacks(String gameId) {
        return new GameRomhacksRequest(gameId);
    }

    /**
     *
     * @param gameId
     * @return
     */
    public static GameVariablesRequest getGameVariables(String gameId) {
        return new GameVariablesRequest(gameId);
    }

    /**
     *
     * @return
     */
    public static GamesRequest getGames() {
        return new GamesRequest();
    }

    /**
     *
     * @param id ID of the run to get
     * @return a CompletableFuture of a run
     */
    public static CompletableFuture<Run> getRun(String id) {
        return new RunRequest(id).complete();
    }

    /**
     *
     * @param runId
     * @param apiKey
     * @return
     */
    public static DeleteRunRequest deleteRun(String runId, String apiKey) {
        return new DeleteRunRequest(runId, apiKey);
    }

    /**
     *
     * @param runId
     * @return
     */
    public static RunPlayersRequest getRunPlayers(String runId) {
        return new RunPlayersRequest(runId);
    }

    /**
     *
     * @param runId
     * @return
     */
    public static RunStatusRequest setRunStatus(String runId) {
        return new RunStatusRequest(runId);
    }

    /**
     *
     * @return
     */
    public static RunsRequest getRuns() {
        return new RunsRequest();
    }

    /**
     *
     * @param id ID of the category to get
     * @return a CompletableFuture of a category
     */
    public static CompletableFuture<Category> getCategory(String id) {
        return new CategoryRequest(id).complete();
    }

    /**
     *
     * @param categoryId
     * @return
     */
    public static CategoryRecordsRequest getCategoryRecords(String categoryId) {
        return new CategoryRecordsRequest(categoryId);
    }

    /**
     *
     * @param categoryId
     * @return
     */
    public static CategoryVariablesRequest getCategoryVariables(String categoryId) {
        return new CategoryVariablesRequest(categoryId);
    }

    /**
     *
     * @param id ID of the level to get
     * @return a CompletableFuture of a level
     */
    public static CompletableFuture<Level> getLevel(String id) {
        return new LevelRequest(id).complete();
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelCategoriesRequest getLevelCategories(String levelId) {
        return new LevelCategoriesRequest(levelId);
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelRecordsRequest getLevelRecords(String levelId) {
        return new LevelRecordsRequest(levelId);
    }

    /**
     *
     * @param levelId
     * @return
     */
    public static LevelVariablesRequest getLevelVariables(String levelId) {
        return new LevelVariablesRequest(levelId);
    }

    /**
     *
     * @param id ID of the variable to get
     * @return a CompletableFuture of a variable
     */
    public static CompletableFuture<Variable> getVariable(String id) {
        return new VariableRequest(id).complete();
    }

    /**
     *
     * @param id ID of the user to get
     * @return a CompletableFuture of a user
     */
    public static CompletableFuture<User> getUser(String id) {
        return new UserRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static UsersRequest getUsers() {
        return new UsersRequest();
    }

    /**
     *
     * @param userId
     * @return
     */
    public static UserPBsRequest getUserPBs(String userId) {
        return new UserPBsRequest(userId);
    }

    /**
     *
     * @param name name of the guest to get
     * @return a CompletableFuture of a guest
     */
    public static CompletableFuture<Guest> getGuest(String name) {
        return new GuestRequest(name).complete();
    }

    /**
     *
     * @param id ID of the genre to get
     * @return a CompletableFuture of a genre
     */
    public static CompletableFuture<Genre> getGenre(String id) {
        return new GenreRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static GenresRequest getGenres() {
        return new GenresRequest();
    }

    /**
     *
     * @param id ID of the engine to get
     * @return a CompletableFuture of an engine
     */
    public static CompletableFuture<Engine> getEngine(String id) {
        return new EngineRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static EnginesRequest getEngines() {
        return new EnginesRequest();
    }

    /**
     *
     * @param id ID of the gametype to get
     * @return a CompletableFuture of a gametype
     */
    public static CompletableFuture<Gametype> getGametype(String id) {
        return new GametypeRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static GametypesRequest getGametypes() {
        return new GametypesRequest();
    }

    /**
     *
     * @param id ID of the developer to get
     * @return a CompletableFuture of a developer
     */
    public static CompletableFuture<Developer> getDeveloper(String id) {
        return new DeveloperRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static DevelopersRequest getDevelopers() {
        return new DevelopersRequest();
    }

    /**
     *
     * @param id ID of the region to get
     * @return a CompletableFuture of a region
     */
    public static CompletableFuture<Region> getRegion(String id) {
        return new RegionRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static RegionsRequest getRegions() {
        return new RegionsRequest();
    }

    /**
     *
     * @param id ID of the series to get
     * @return a CompletableFuture of a series
     */
    public static CompletableFuture<Series> getSingleSeries(String id) {
        return new SingleSeriesRequest(id).complete();
    }

    /**
     *
     * @param seriesId
     * @return
     */
    public static SeriesGamesRequest getSeriesGames(String seriesId) {
        return new SeriesGamesRequest(seriesId);
    }

    /**
     *
     * @return
     */
    public static AllSeriesRequest getMultipleSeries() {
        return new AllSeriesRequest();
    }

    /**
     *
     * @param id ID of the platform to get
     * @return a CompletableFuture of a platform
     */
    public static CompletableFuture<Platform> getPlatform(String id) {
        return new PlatformRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static PlatformsRequest getPlatforms() {
        return new PlatformsRequest();
    }

    /**
     *
     * @param id ID of the publisher to get
     * @return a CompletableFuture of a publisher
     */
    public static CompletableFuture<Publisher> getPublisher(String id) {
        return new PublisherRequest(id).complete();
    }

    /**
     *
     * @return
     */
    public static PublishersRequest getPublishers() {
        return new PublishersRequest();
    }

    /**
     *
     * @param gameId game ID to filter the leaderboard
     * @param categoryId category ID to filter the leaderboard
     * @param levelId level ID to filter the leaderboard
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return new LeaderboardRequest(gameId, categoryId, levelId);
    }

    /**
     *
     * @param gameId game ID to filter the leaderboard
     * @param categoryId category ID to filter the leaderboard
     * @return
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return new LeaderboardRequest(gameId, categoryId);
    }

    /**
     *
     * @param game game filter
     * @param category category filter
     * @param level level filter
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return new LeaderboardRequest(game, category, level);
    }

    /**
     *
     * @param game game filter
     * @param category category filter
     * @return
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return new LeaderboardRequest(game, category);
    }
}
