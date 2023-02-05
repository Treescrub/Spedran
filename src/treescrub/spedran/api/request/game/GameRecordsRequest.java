package treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

public class GameRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    public GameRecordsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/records", Map.of("id", id));
    }

    public GameRecordsRequest(Game game) {
        this(game.getId());
    }

    public GameRecordsRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    public GameRecordsRequest scope(String recordsScope) {
        setParameter("scope", recordsScope);
        return this;
    }

    public GameRecordsRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    public GameRecordsRequest skipEmpty(boolean skipEmptyRecords) {
        setParameter("skip-empty", skipEmptyRecords);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
