package com.treescrub.spedran;

import com.treescrub.spedran.requests.builders.*;
import com.treescrub.spedran.requests.builders.run.*;
import com.treescrub.spedran.requests.builders.series.AllSeriesRequest;
import com.treescrub.spedran.requests.builders.series.SeriesGamesRequest;
import com.treescrub.spedran.requests.builders.series.SingleSeriesRequest;
import com.treescrub.spedran.requests.builders.user.ProfileRequest;
import com.treescrub.spedran.requests.builders.user.UserPBsRequest;
import com.treescrub.spedran.requests.builders.user.UserRequest;
import com.treescrub.spedran.requests.builders.user.UsersRequest;
import com.treescrub.spedran.data.*;
import com.treescrub.spedran.requests.builders.game.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The main Spedran API.
 */
public class Spedran {
    private static final Logger logger = LoggerFactory.getLogger(Spedran.class);

    private Spedran() {}

    /**
     * Sets the current API key.
     * The API key is not set if it is {@code null} or blank.
     *
     * @param key SRC API key
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public static void clearApiKey() {
        removeApiKey();
    }

    /**
     * Shuts down all work threads, allowing the application to exit.
     * <p>All new requests and requests currently queued will fail with a {@link SpedranStateException}.</p>
     */
    @SuppressWarnings("unused")
    public static void shutDown() {
        Requests.shutDown();
    }

    /**
     * Enable request caching.
     */
    @SuppressWarnings("unused")
    public static void enableCache() {
        Requests.enableCache();
    }

    /**
     * Disable request caching.
     */
    @SuppressWarnings("unused")
    public static void disableCache() {
        Requests.disableCache();
    }

    /**
     * Sets the maximum time that entries are considered valid in the request cache.
     *
     * @param newTimeLimit the new time limit in milliseconds
     */
    @SuppressWarnings("unused")
    public static void setCacheTimeLimit(long newTimeLimit) {
        Requests.setCacheTimeLimit(newTimeLimit);
    }

    /**
     * Sets the values for exponential backoff.
     * <br>
     * The backoff time is calculated as {@code base^count * constant} where {@code count} is the current rate limit count.
     *
     * @param base the exponent base
     * @param reduceDelay the minimum time in milliseconds before the rate can be increased after hitting a rate limit
     * @param constant a constant factor to multiply the backoff time by
     */
    @SuppressWarnings("unused")
    public static void setBackoffValues(double base, long reduceDelay, double constant) {
        Requests.setBackoffValues(base, reduceDelay, constant);
    }

    /**
     * Gets a {@link GameRequest} builder to request the specified {@link Game}.
     *
     * @param id the ID of the game to get. can be the game's abbreviation as well
     *
     * @return a {@code GameRequest} builder
     */
    @SuppressWarnings("unused")
    public static GameRequest getGame(String id) {
        return GameRequest.create(id);
    }

    /**
     * Gets a {@link GameCategoriesRequest} builder to request the categories for the specified {@link Game}.
     *
     * @param gameId the ID of the game to get the {@link Category}s for
     *
     * @return a {@code GameCategoriesRequest} builder
     */
    public static GameCategoriesRequest getGameCategories(String gameId) {
        return GameCategoriesRequest.create(gameId);
    }

    /**
     * Gets a {@link GameLevelsRequest} builder to request the levels for the specified {@link Game}.
     *
     * @param gameId the ID of the game to get the {@link Level}s for
     *
     * @return a {@code GameLevelsRequest} builder
     */
    public static GameLevelsRequest getGameLevels(String gameId) {
        return GameLevelsRequest.create(gameId);
    }

    /**
     * Gets a {@link GameRecordsRequest} builder to request the records for the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the {@link Leaderboard}s for
     *
     * @return a {@code GameRecordsRequest} builder
     */
    public static GameRecordsRequest getGameRecords(String gameId) {
        return GameRecordsRequest.create(gameId);
    }

    /**
     * Gets a {@link GameRomhacksRequest} builder to request the romhacks of the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the derived {@code Game}s for
     *
     * @return a {@code GameRomhacksRequest} builder
     */
    public static GameRomhacksRequest getGameRomhacks(String gameId) {
        return GameRomhacksRequest.create(gameId);
    }

    /**
     * Gets a {@link GameVariablesRequest} builder to request all the {@link Variable}s of the specified {@link Game}.
     *
     * @param gameId the ID of the {@code Game} to get the {@code Variable}s for
     *
     * @return a {@code GameVariablesRequest} builder
     */
    public static GameVariablesRequest getGameVariables(String gameId) {
        return GameVariablesRequest.create(gameId);
    }

    /**
     * Gets a {@link GamesRequest} builder to request all {@link Game}s matching the specified criteria.
     *
     * @return a {@code GamesRequest} builder
     */
    public static GamesRequest getGames() {
        return GamesRequest.create();
    }

    /**
     * Gets a {@link RunRequest} builder to request the specified {@link Run}.
     *
     * @param id the ID of the run to get
     *
     * @return a {@code RunRequest} builder
     */
    @SuppressWarnings("unused")
    public static RunRequest getRun(String id) {
        return RunRequest.create(id);
    }

    /**
     * Gets a {@link DeleteRunRequest} builder to delete a {@link Run}.
     *
     * @param runId the ID of the run to delete
     *
     * @return a {@code DeleteRunRequest} builder
     */
    public static DeleteRunRequest deleteRun(String runId) {
        return DeleteRunRequest.create(runId);
    }

    /**
     * Gets a {@link RunPlayersRequest} builder to change the players in a {@link Run}.
     *
     * @param runId the ID of the run to set the players for
     *
     * @return a {@code RunPlayersRequest} builder
     */
    public static RunPlayersRequest setRunPlayers(String runId) {
        return RunPlayersRequest.create(runId);
    }

    /**
     * Gets a {@link SubmitRunRequest} builder to submit a run to SRC.
     *
     * @return a {@code SubmitRunRequest} builder
     */
    @SuppressWarnings("unused")
    public static SubmitRunRequest submitRun() {
        return SubmitRunRequest.create();
    }

    /**
     * Gets a {@link RunStatusRequest} builder to change the {@link Run}'s verification status.
     *
     * @param runId the ID of the run to set the status of
     *
     * @return a {@code RunStatusRequest} builder
     */
    public static RunStatusRequest setRunStatus(String runId) {
        return RunStatusRequest.create(runId);
    }

    /**
     * Gets a {@link RunsRequest} builder to request all {@link Run}s matching the specified criteria.
     *
     * @return a {@code RunsRequest} builder
     */
    public static RunsRequest getRuns() {
        return RunsRequest.create();
    }

    /**
     * Gets a {@link CategoryRequest} builder to request the specified {@link Category}.
     *
     * @param id the ID of the category to get
     *
     * @return a {@code CategoryRequest} builder
     */
    @SuppressWarnings("unused")
    public static CategoryRequest getCategory(String id) {
        return CategoryRequest.create(id);
    }

    /**
     * Gets a {@link CategoryRecordsRequest} builder to request the records for the specified {@link Category}.
     *
     * @param categoryId the ID of the {@code Category} to get the {@link Leaderboard}s for
     *
     * @return a {@code CategoryRecordsRequest} builder
     */
    public static CategoryRecordsRequest getCategoryRecords(String categoryId) {
        return CategoryRecordsRequest.create(categoryId);
    }

    /**
     * Gets a {@link CategoryVariablesRequest} builder to request all the variables for the specified {@link Category}.
     *
     * @param categoryId the ID of the {@code Category} to get the {@link Variable}s for
     *
     * @return a {@code CategoryVariablesRequest} builder
     */
    public static CategoryVariablesRequest getCategoryVariables(String categoryId) {
        return CategoryVariablesRequest.create(categoryId);
    }

    /**
     * Gets a {@link LevelRequest} builder to request the specified {@link Level}.
     *
     * @param id the ID of the level to get
     *
     * @return a {@code LevelRequest} builder
     */
    @SuppressWarnings("unused")
    public static LevelRequest getLevel(String id) {
        return LevelRequest.create(id);
    }

    /**
     * Gets a {@link LevelCategoriesRequest} builder to request all applicable categories for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Category}s for
     *
     * @return a {@code LevelCategoriesRequest} builder
     */
    public static LevelCategoriesRequest getLevelCategories(String levelId) {
        return LevelCategoriesRequest.create(levelId);
    }

    /**
     * Gets a {@link LevelRecordsRequest} builder to request the records for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Leaderboard}s for
     *
     * @return a {@code LevelRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public static LevelRecordsRequest getLevelRecords(String levelId) {
        return LevelRecordsRequest.create(levelId);
    }

    /**
     * Gets a {@link LevelVariablesRequest} builder to request all the variables for the specified {@link Level}.
     *
     * @param levelId the ID of the {@code Level} to get the {@link Variable}s for
     *
     * @return a {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public static LevelVariablesRequest getLevelVariables(String levelId) {
        return LevelVariablesRequest.create(levelId);
    }

    /**
     * Gets the {@link Variable} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the variable to get
     *
     * @return a {@link CompletableFuture} of a {@code Variable}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Variable> getVariable(String id) {
        return VariableRequest.create(id).complete();
    }

    /**
     * Gets the {@link User} that owns the current API key.
     *
     * @return a {@link CompletableFuture} of the current authenticated {@code User}
     * @see Spedran#setApiKey(String)
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<User> getProfile() {
        return ProfileRequest.create().complete();
    }

    /**
     * Gets all of the {@link Notification}s for the currently authenticated user.
     *
     * @return a {@link CompletableFuture} with a {@code List} of notifications
     * @see Spedran#setApiKey(String)
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<List<Notification>> getNotifications() {
        return NotificationsRequest.create().complete();
    }

    /**
     * Gets the {@link User} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the user to get
     *
     * @return a {@link CompletableFuture} of a {@code User}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<User> getUser(String id) {
        return UserRequest.create(id).complete();
    }

    /**
     * Gets a {@link UsersRequest} builder to request all {@link User}s matching the specified criteria.
     *
     * @return a {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public static UsersRequest getUsers() {
        return UsersRequest.create();
    }

    /**
     * Gets a {@link UserPBsRequest} builder to request the personal best runs for the specified {@link User}.
     *
     * @param userId the ID of the {@code User} to get the {@link LeaderboardRun}s for
     *
     * @return a {@code UserPBsRequest} builder
     */
    public static UserPBsRequest getUserPBs(String userId) {
        return UserPBsRequest.create(userId);
    }

    /**
     * Gets the {@link Guest} that corresponds to the provided {@code name} asynchronously.
     *
     * @param name the name of the guest to get
     *
     * @return a {@link CompletableFuture} of a {@code Guest}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Guest> getGuest(String name) {
        return GuestRequest.create(name).complete();
    }

    /**
     * Gets the {@link Genre} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the genre to get
     *
     * @return a {@link CompletableFuture} of a {@code Genre}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Genre> getGenre(String id) {
        return GenreRequest.create(id).complete();
    }

    /**
     * Gets a {@link GenresRequest} builder to request all {@link Genre}s.
     *
     * @return a {@code GenresRequest} builder
     */
    @SuppressWarnings("unused")
    public static GenresRequest getGenres() {
        return GenresRequest.create();
    }

    /**
     * Gets the {@link Engine} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the engine to get
     *
     * @return a {@link CompletableFuture} of a {@code Engine}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Engine> getEngine(String id) {
        return EngineRequest.create(id).complete();
    }

    /**
     * Gets a {@link EnginesRequest} builder to request all {@link Engine}s.
     *
     * @return a {@code EnginesRequest} builder
     */
    @SuppressWarnings("unused")
    public static EnginesRequest getEngines() {
        return EnginesRequest.create();
    }

    /**
     * Gets the {@link Gametype} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the gametype to get
     *
     * @return a {@link CompletableFuture} of a {@code Gametype}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Gametype> getGametype(String id) {
        return GametypeRequest.create(id).complete();
    }

    /**
     * Gets a {@link GametypesRequest} builder to request all {@link Gametype}s.
     *
     * @return a {@code GametypesRequest} builder
     */
    @SuppressWarnings("unused")
    public static GametypesRequest getGametypes() {
        return GametypesRequest.create();
    }

    /**
     * Gets the {@link Developer} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the developer to get
     *
     * @return a {@link CompletableFuture} of a {@code Developer}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Developer> getDeveloper(String id) {
        return DeveloperRequest.create(id).complete();
    }

    /**
     * Gets a {@link DevelopersRequest} builder to request all {@link Developer}s.
     *
     * @return a {@code DevelopersRequest} builder
     */
    @SuppressWarnings("unused")
    public static DevelopersRequest getDevelopers() {
        return DevelopersRequest.create();
    }

    /**
     * Gets the {@link Region} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the region to get
     *
     * @return a {@link CompletableFuture} of a {@code Region}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Region> getRegion(String id) {
        return RegionRequest.create(id).complete();
    }

    /**
     * Gets a {@link RegionsRequest} builder to request all {@link Region}s.
     *
     * @return a {@code RegionsRequest} builder
     */
    @SuppressWarnings("unused")
    public static RegionsRequest getRegions() {
        return RegionsRequest.create();
    }

    /**
     * Gets the {@link Series} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the region to get
     *
     * @return a {@link CompletableFuture} of a {@code Series}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Series> getSingleSeries(String id) {
        return SingleSeriesRequest.create(id).complete();
    }

    /**
     * Gets a {@link SeriesGamesRequest} builder to request the games in the specified {@link Series}.
     *
     * @param seriesId the ID of the {@code Series} to get the {@link Game}s that belong to the series
     *
     * @return a {@code SeriesGamesRequest} builder
     */
    public static SeriesGamesRequest getSeriesGames(String seriesId) {
        return SeriesGamesRequest.create(seriesId);
    }

    /**
     * Gets a {@link AllSeriesRequest} builder to request all {@link Series}s.
     *
     * @return a {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public static AllSeriesRequest getMultipleSeries() {
        return AllSeriesRequest.create();
    }

    /**
     * Gets the {@link Platform} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the platform to get
     *
     * @return a {@link CompletableFuture} of a {@code Platform}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Platform> getPlatform(String id) {
        return PlatformRequest.create(id).complete();
    }

    /**
     * Gets a {@link PlatformsRequest} builder to request all {@link Platform}s.
     *
     * @return a {@code PlatformsRequest} builder
     */
    @SuppressWarnings("unused")
    public static PlatformsRequest getPlatforms() {
        return PlatformsRequest.create();
    }

    /**
     * Gets the {@link Publisher} that corresponds to the provided {@code id} asynchronously.
     *
     * @param id the ID of the publisher to get
     *
     * @return a {@link CompletableFuture} of a {@code Publisher}
     */
    @SuppressWarnings("unused")
    public static CompletableFuture<Publisher> getPublisher(String id) {
        return PublisherRequest.create(id).complete();
    }

    /**
     * Gets a {@link PublishersRequest} builder to request all {@link Publisher}s.
     *
     * @return a {@code PublishersRequest} builder
     */
    @SuppressWarnings("unused")
    public static PublishersRequest getPublishers() {
        return PublishersRequest.create();
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
    @SuppressWarnings("unused")
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId, String levelId) {
        return LeaderboardRequest.create(gameId, categoryId, levelId);
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param gameId game ID to filter the leaderboard by
     * @param categoryId category ID to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public static LeaderboardRequest getLeaderboard(String gameId, String categoryId) {
        return LeaderboardRequest.create(gameId, categoryId);
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
    @SuppressWarnings("unused")
    public static LeaderboardRequest getLeaderboard(Game game, Category category, Level level) {
        return LeaderboardRequest.create(game, category, level);
    }

    /**
     * Gets a {@link LeaderboardRequest} builder to request a specific {@link Leaderboard}.
     *
     * @param game game to filter the leaderboard by
     * @param category category to filter the leaderboard by
     *
     * @return a {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public static LeaderboardRequest getLeaderboard(Game game, Category category) {
        return LeaderboardRequest.create(game, category);
    }
}
