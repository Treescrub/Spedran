package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

public class GameRecords extends ResourceCollectionRequest<Leaderboard> {
    public GameRecords(String id) {
        super(HttpMethod.GET, "games/{id}/records", Map.of("id", id));
    }

    public GameRecords top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    public GameRecords scope(String recordsScope) {
        setParameter("scope", recordsScope);
        return this;
    }

    public GameRecords miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    public GameRecords skipEmpty(boolean skipEmptyRecords) {
        setParameter("skip-empty", skipEmptyRecords);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
