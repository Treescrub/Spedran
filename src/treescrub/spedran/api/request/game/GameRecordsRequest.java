package treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

/**
 * A request builder to get records for a given game.
 */
public class GameRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    public GameRecordsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/records", Map.of("id", id));
    }

    public GameRecordsRequest(Game game) {
        this(game.getId());
    }

    /**
     * Sets the number of places to return.
     * <p>
     * This will return more than {@code value} runs per leaderboard if there are ties.
     *
     * @param topPlaces the top places to filter for, clamped to {@code >= 1}
     * @return
     */
    public GameRecordsRequest top(int topPlaces) {
        topPlaces = Math.max(topPlaces, 1);
        setParameter("top", topPlaces);
        return this;
    }

    /**
     * Sets the scope type.
     * <p>
     * Valid values are: {@code "full-game"}, {@code "levels"}, and {@code "all"}.
     * <p>
     * Full-game scope returns only full-game categories.
     * Levels scope returns only individual levels.
     * All returns everything and is the default scope.
     *
     * @param recordsScope the scope to get records in
     * @return this object
     */
    public GameRecordsRequest scope(String recordsScope) {
        setParameter("scope", recordsScope);
        return this;
    }

    /**
     * Sets whether miscellaneous categories should be returned.
     * <p>
     * Defaults to {@code true}.
     *
     * @param includeMiscellaneous whether to include miscellaneous categories in the results
     * @return this object
     */
    public GameRecordsRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Sets whether record entries without any runs should be kept.
     *
     * @param skipEmptyRecords {@code true} to skip empty records; {@code false} otherwise
     * @return this object
     */
    public GameRecordsRequest skipEmpty(boolean skipEmptyRecords) {
        setParameter("skip-empty", skipEmptyRecords);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
