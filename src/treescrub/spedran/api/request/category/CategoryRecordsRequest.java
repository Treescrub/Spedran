package treescrub.spedran.api.request.category;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

public class CategoryRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    public CategoryRecordsRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/records", Map.of("id", id));
    }

    public CategoryRecordsRequest(Category category) {
        this(category.getId());
    }

    /**
     * Sets number of places to return.
     * <p>
     * This will return more than {@code value} runs per leaderboard if there are ties.
     *
     * @param value the top places to filter for, clamped to {@code >= 1}
     * @return this object
     */
    public CategoryRecordsRequest topPlaces(int value) {
        value = Math.max(value, 1);
        setParameter("top", value);
        return this;
    }

    /**
     * Skips leaderboards if they do not contain any runs.
     *
     * @return this object
     */
    public CategoryRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    /**
     * Keeps all leaderboards in the results, regardless of whether they have any runs.
     *
     * @return this object
     */
    public CategoryRecordsRequest keepEmptyResults() {
        setParameter("skip-empty", false);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
