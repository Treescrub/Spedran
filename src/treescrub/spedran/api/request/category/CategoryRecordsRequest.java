package treescrub.spedran.api.request.category;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

public class CategoryRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    public CategoryRecordsRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/records", Map.of("id", id));
    }

    public CategoryRecordsRequest topPlaces(int value) {
        setParameter("top", value);
        return this;
    }

    public CategoryRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    public CategoryRecordsRequest keepEmptyResults() {
        setParameter("skip-empty", false);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
