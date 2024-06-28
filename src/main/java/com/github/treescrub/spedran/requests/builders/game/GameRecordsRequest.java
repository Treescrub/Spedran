package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Leaderboard;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get records for a given {@link Game}.
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
     * @return this {@code GameRecordsRequest} builder
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
     * @return this {@code GameRecordsRequest} builder
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
     * @return this {@code GameRecordsRequest} builder
     */
    public GameRecordsRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Sets whether record entries without any runs should be kept.
     *
     * @param skipEmptyRecords {@code true} to skip empty records; {@code false} otherwise
     * @return this {@code GameRecordsRequest} builder
     */
    public GameRecordsRequest skipEmpty(boolean skipEmptyRecords) {
        setParameter("skip-empty", skipEmptyRecords);
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
