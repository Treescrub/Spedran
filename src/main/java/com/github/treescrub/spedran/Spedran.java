package com.github.treescrub.spedran;

import com.github.treescrub.spedran.data.*;
import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Series;
import com.github.treescrub.spedran.data.Leaderboard;
import com.github.treescrub.spedran.data.LeaderboardRun;
import com.github.treescrub.spedran.data.Notification;
import com.github.treescrub.spedran.data.Run;
import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.Requests;
import com.github.treescrub.spedran.requests.builders.category.CategoryRecordsRequest;
import com.github.treescrub.spedran.requests.builders.category.CategoryRequest;
import com.github.treescrub.spedran.requests.builders.category.CategoryVariablesRequest;
import com.github.treescrub.spedran.requests.builders.developer.DeveloperRequest;
import com.github.treescrub.spedran.requests.builders.developer.DevelopersRequest;
import com.github.treescrub.spedran.requests.builders.engine.EngineRequest;
import com.github.treescrub.spedran.requests.builders.engine.EnginesRequest;
import com.github.treescrub.spedran.requests.builders.game.*;
import com.github.treescrub.spedran.requests.builders.gametype.GametypeRequest;
import com.github.treescrub.spedran.requests.builders.gametype.GametypesRequest;
import com.github.treescrub.spedran.requests.builders.genre.GenreRequest;
import com.github.treescrub.spedran.requests.builders.genre.GenresRequest;
import com.github.treescrub.spedran.requests.builders.guest.GuestRequest;
import com.github.treescrub.spedran.requests.builders.leaderboard.LeaderboardRequest;
import com.github.treescrub.spedran.requests.builders.level.LevelCategoriesRequest;
import com.github.treescrub.spedran.requests.builders.level.LevelRecordsRequest;
import com.github.treescrub.spedran.requests.builders.level.LevelRequest;
import com.github.treescrub.spedran.requests.builders.level.LevelVariablesRequest;
import com.github.treescrub.spedran.requests.builders.notification.NotificationsRequest;
import com.github.treescrub.spedran.requests.builders.platform.PlatformRequest;
import com.github.treescrub.spedran.requests.builders.platform.PlatformsRequest;
import com.github.treescrub.spedran.requests.builders.publisher.PublisherRequest;
import com.github.treescrub.spedran.requests.builders.publisher.PublishersRequest;
import com.github.treescrub.spedran.requests.builders.region.RegionRequest;
import com.github.treescrub.spedran.requests.builders.region.RegionsRequest;
import com.github.treescrub.spedran.requests.builders.run.*;
import com.github.treescrub.spedran.requests.builders.series.AllSeriesRequest;
import com.github.treescrub.spedran.requests.builders.series.SeriesGamesRequest;
import com.github.treescrub.spedran.requests.builders.series.SingleSeriesRequest;
import com.github.treescrub.spedran.requests.builders.user.ProfileRequest;
import com.github.treescrub.spedran.requests.builders.user.UserPBsRequest;
import com.github.treescrub.spedran.requests.builders.user.UserRequest;
import com.github.treescrub.spedran.requests.builders.user.UsersRequest;
import com.github.treescrub.spedran.requests.builders.variable.VariableRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
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
     * Enable request caching.
     */
    public static void enableCache() {
        Requests.enableCache();
    }

    /**
     * Disable request caching.
     */
    public static void disableCache() {
        Requests.disableCache();
    }

    /**
     * Sets the maximum time that entries are considered valid in the request cache.
     *
     * @param newTimeLimit the new time limit in milliseconds
     */
    public static void setCacheTimeLimit(long newTimeLimit) {
        Requests.setCacheTimeLimit(newTimeLimit);
    }

    /**
     * Gets the {@link Game} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the game to get. can be the game's abbreviation as well
     *
     * @return a {@link CompletableFuture} of a {@code Game}
     */
    public static CompletableFuture<Game> getGame(String id) {
        return new GameRequest(id).complete();
    }

    /**
     * Gets a {@link GameCategoriesRequest} builder to request the categories for the specified {@link Game}.
     *
     * @param gameId the ID of the game to get the {@link Category}s for
     *
     * @return a {@code GameCategoriesRequest} builder
     */
    public static GameCategoriesRequest getGameCategories(String gameId) {
        return new GameCategoriesRequest(gameId);
    }

    /**
     * Gets a {@link GameLevelsRequest} builder to request the levels for the specified {@link Game}.
     *
     * @param gameId the ID of the game to get the {@link Level}s for
     *
     * @return a {@code GameLevelsRequest} builder
     */
    public static GameLevelsRequest getGameLevels(String gameId) {
        return new GameLevelsRequest(gameId);
    }

    /**
     * Gets a {@link GameRecordsRequest} builder to request the records for the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the {@link Leaderboard}s for
     *
     * @return a {@code GameRecordsRequest} builder
     */
    public static GameRecordsRequest getGameRecords(String gameId) {
        return new GameRecordsRequest(gameId);
    }

    /**
     * Gets a {@link GameRomhacksRequest} builder to request the romhacks of the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the derived {@code Game}s for
     *
     * @return a {@code GameRomhacksRequest} builder
     */
    public static GameRomhacksRequest getGameRomhacks(String gameId) {
        return new GameRomhacksRequest(gameId);
    }

    /**
     * Gets a {@link GameVariablesRequest} builder to request all the {@link Variable}s of the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the {@code Variable}s for
     *
     * @return a {@code GameVariablesRequest} builder
     */
    public static GameVariablesRequest getGameVariables(String gameId) {
        return new GameVariablesRequest(gameId);
    }

    /**
     * Gets a {@link GamesRequest} builder to request all {@link Game}s matching the specified criteria.
     *
     * @return a {@code GamesRequest} builder
     */
    public static GamesRequest getGames() {
        return new GamesRequest();
    }

    /**
     * Gets the {@link Run} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the run to get
     *
     * @return a {@link CompletableFuture} of a {@code Run}
     */
    public static CompletableFuture<Run> getRun(String id) {
        return new RunRequest(id).complete();
    }

    /**
     * Gets a {@link DeleteRunRequest} builder to delete a {@link Run}.
     *
     * @param runId the ID of the run to delete
     *
     * @return a {@code DeleteRunRequest} builder
     */
    public static DeleteRunRequest deleteRun(String runId) {
        return new DeleteRunRequest(runId);
    }

    /**
     * Gets a {@link RunPlayersRequest} builder to change the players in a {@link Run}.
     *
     * @param runId the ID of the run to set the players for
     *
     * @return a {@code RunPlayersRequest} builder
     */
    public static RunPlayersRequest setRunPlayers(String runId) {
        return new RunPlayersRequest(runId);
    }

    /**
     * Gets a {@link SubmitRunRequest} builder to submit a run to SRC.
     *
     * @return a {@code SubmitRunRequest} builder
     */
    public static SubmitRunRequest submitRun() {
        return new SubmitRunRequest();
    }

    /**
     * Gets a {@link RunStatusRequest} builder to change the {@link Run}'s verification status.
     *
     * @param runId the ID of the run to set the status of
     *
     * @return a {@code RunStatusRequest} builder
     */
    public static RunStatusRequest setRunStatus(String runId) {
        return new RunStatusRequest(runId);
    }

    /**
     * Gets a {@link RunsRequest} builder to request all {@link Run}s matching the specified criteria.
     *
     * @return a {@code RunsRequest} builder
     */
    public static RunsRequest getRuns() {
        return new RunsRequest();
    }

    /**
     * Gets the {@link Category} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the category to get
     *
     * @return a {@link CompletableFuture} of a {@code Category}
     */
    public static CompletableFuture<Category> getCategory(String id) {
        return new CategoryRequest(id).complete();
    }

    /**
     * Gets a {@link CategoryRecordsRequest} builder to request the records for the specified {@link Category}.
     *
     * @param categoryId the ID of the {@code Category} to get the {@link Leaderboard}s for
     *
     * @return a {@code CategoryRecordsRequest} builder
     */
    public static CategoryRecordsRequest getCategoryRecords(String categoryId) {
        return new CategoryRecordsRequest(categoryId);
    }

    /**
     * Gets a {@link CategoryVariablesRequest} builder to request all the variables for the specified {@link Category}.
     *
     * @param categoryId the ID of the {@code Category} to get the {@link Variable}s for
     *
     * @return a {@code CategoryVariablesRequest} builder
     */
    public static CategoryVariablesRequest getCategoryVariables(String categoryId) {
        return new CategoryVariablesRequest(categoryId);
    }

    /**
     * Gets the {@link Level} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the level to get
     *
     * @return a {@link CompletableFuture} of a {@code Level}
     */
    public static CompletableFuture<Level> getLevel(String id) {
        return new LevelRequest(id).complete();
    }

    /**
     * Gets a {@link LevelCategoriesRequest} builder to request all applicable categories for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Category}s for
     *
     * @return a {@code LevelCategoriesRequest} builder
     */
    public static LevelCategoriesRequest getLevelCategories(String levelId) {
        return new LevelCategoriesRequest(levelId);
    }

    /**
     * Gets a {@link LevelRecordsRequest} builder to request the records for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Leaderboard}s for
     *
     * @return a {@code LevelRecordsRequest} builder
     */
    public static LevelRecordsRequest getLevelRecords(String levelId) {
        return new LevelRecordsRequest(levelId);
    }

    /**
     * Gets a {@link LevelVariablesRequest} builder to request all the variables for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Variable}s for
     *
     * @return a {@code LevelVariablesRequest} builder
     */
    public static LevelVariablesRequest getLevelVariables(String levelId) {
        return new LevelVariablesRequest(levelId);
    }

    /**
     * Gets the {@link Variable} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the variable to get
     *
     * @return a {@link CompletableFuture} of a {@code Variable}
     */
    public static CompletableFuture<Variable> getVariable(String id) {
        return new VariableRequest(id).complete();
    }

    /**
     * Gets the {@link User} that owns the current API key.
     *
     * @return a {@link CompletableFuture} of the current authenticated {@code User}
     * @see Spedran#setApiKey(String)
     */
    public static CompletableFuture<User> getProfile() {
        return new ProfileRequest().complete();
    }

    /**
     * Gets all of the {@link Notification}s for the currently authenticated user.
     *
     * @return a {@link CompletableFuture} with a {@code List} of notifications
     * @see Spedran#setApiKey(String)
     */
    public static CompletableFuture<List<Notification>> getNotifications() {
        return new NotificationsRequest().complete();
    }

    /**
     * Gets the {@link User} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the user to get
     *
     * @return a {@link CompletableFuture} of a {@code User}
     */
    public static CompletableFuture<User> getUser(String id) {
        return new UserRequest(id).complete();
    }

    /**
     * Gets a {@link UsersRequest} builder to request all {@link User}s matching the specified criteria.
     *
     * @return a {@code UsersRequest} builder
     */
    public static UsersRequest getUsers() {
        return new UsersRequest();
    }

    /**
     * Gets a {@link UserPBsRequest} builder to request the personal best runs for the specified {@link User}.
     *
     * @param userId the ID of the {@code User} to get the {@link LeaderboardRun}s for
     *
     * @return a {@code UserPBsRequest} builder
     */
    public static UserPBsRequest getUserPBs(String userId) {
        return new UserPBsRequest(userId);
    }

    /**
     * Gets the {@link Guest} that corresponds to the provided {@code name} asynchronously.
     *
     * @param name the name of the guest to get
     *
     * @return a {@link CompletableFuture} of a {@code Guest}
     */
    public static CompletableFuture<Guest> getGuest(String name) {
        return new GuestRequest(name).complete();
    }

    /**
     * Gets the {@link Genre} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the genre to get
     *
     * @return a {@link CompletableFuture} of a {@code Genre}
     */
    public static CompletableFuture<Genre> getGenre(String id) {
        return new GenreRequest(id).complete();
    }

    /**
     * Gets a {@link GenresRequest} builder to request all {@link Genre}s.
     *
     * @return a {@code GenresRequest} builder
     */
    public static GenresRequest getGenres() {
        return new GenresRequest();
    }

    /**
     * Gets the {@link Engine} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the engine to get
     *
     * @return a {@link CompletableFuture} of a {@code Engine}
     */
    public static CompletableFuture<Engine> getEngine(String id) {
        return new EngineRequest(id).complete();
    }

    /**
     * Gets a {@link EnginesRequest} builder to request all {@link Engine}s.
     *
     * @return a {@code EnginesRequest} builder
     */
    public static EnginesRequest getEngines() {
        return new EnginesRequest();
    }

    /**
     * Gets the {@link Gametype} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the gametype to get
     *
     * @return a {@link CompletableFuture} of a {@code Gametype}
     */
    public static CompletableFuture<Gametype> getGametype(String id) {
        return new GametypeRequest(id).complete();
    }

    /**
     * Gets a {@link GametypesRequest} builder to request all {@link Gametype}s.
     *
     * @return a {@code GametypesRequest} builder
     */
    public static GametypesRequest getGametypes() {
        return new GametypesRequest();
    }

    /**
     * Gets the {@link Developer} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the developer to get
     *
     * @return a {@link CompletableFuture} of a {@code Developer}
     */
    public static CompletableFuture<Developer> getDeveloper(String id) {
        return new DeveloperRequest(id).complete();
    }

    /**
     * Gets a {@link DevelopersRequest} builder to request all {@link Developer}s.
     *
     * @return a {@code DevelopersRequest} builder
     */
    public static DevelopersRequest getDevelopers() {
        return new DevelopersRequest();
    }

    /**
     * Gets the {@link Region} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the region to get
     *
     * @return a {@link CompletableFuture} of a {@code Region}
     */
    public static CompletableFuture<Region> getRegion(String id) {
        return new RegionRequest(id).complete();
    }

    /**
     * Gets a {@link RegionsRequest} builder to request all {@link Region}s.
     *
     * @return a {@code RegionsRequest} builder
     */
    public static RegionsRequest getRegions() {
        return new RegionsRequest();
    }

    /**
     * Gets the {@link Series} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the region to get
     *
     * @return a {@link CompletableFuture} of a {@code Series}
     */
    public static CompletableFuture<Series> getSingleSeries(String id) {
        return new SingleSeriesRequest(id).complete();
    }

    /**
     * Gets a {@link SeriesGamesRequest} builder to request the games in the specified {@link Series}.
     *
     * @param seriesId the ID of the {@code Series} to get the {@link Game}s that belong to the series
     *
     * @return a {@code SeriesGamesRequest} builder
     */
    public static SeriesGamesRequest getSeriesGames(String seriesId) {
        return new SeriesGamesRequest(seriesId);
    }

    /**
     * Gets a {@link AllSeriesRequest} builder to request all {@link Series}s.
     *
     * @return a {@code AllSeriesRequest} builder
     */
    public static AllSeriesRequest getMultipleSeries() {
        return new AllSeriesRequest();
    }

    /**
     * Gets the {@link Platform} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the platform to get
     *
     * @return a {@link CompletableFuture} of a {@code Platform}
     */
    public static CompletableFuture<Platform> getPlatform(String id) {
        return new PlatformRequest(id).complete();
    }

    /**
     * Gets a {@link PlatformsRequest} builder to request all {@link Platform}s.
     *
     * @return a {@code PlatformsRequest} builder
     */
    public static PlatformsRequest getPlatforms() {
        return new PlatformsRequest();
    }

    /**
     * Gets the {@link Publisher} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the publisher to get
     *
     * @return a {@link CompletableFuture} of a {@code Publisher}
     */
    public static CompletableFuture<Publisher> getPublisher(String id) {
        return new PublisherRequest(id).complete();
    }

    /**
     * Gets a {@link PublishersRequest} builder to request all {@link Publisher}s.
     *
     * @return a {@code PublishersRequest} builder
     */
    public static PublishersRequest getPublishers() {
        return new PublishersRequest();
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param gameId game ID to filter the leaderboard by
     * @param categoryId category ID to filter the leaderboard by
     * @param levelId level ID to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return new LeaderboardRequest(gameId, categoryId, levelId);
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param gameId game ID to filter the leaderboard by
     * @param categoryId category ID to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return new LeaderboardRequest(gameId, categoryId);
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param game game to filter the leaderboard by
     * @param category category to filter the leaderboard by
     * @param level level to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return new LeaderboardRequest(game, category, level);
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param game game to filter the leaderboard by
     * @param category category to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return new LeaderboardRequest(game, category);
    }
}
