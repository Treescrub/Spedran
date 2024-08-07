package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Leaderboard;
import com.treescrub.spedran.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the top runs of a {@link Category}.
 */
public class CategoryRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    @SuppressWarnings("unused")
    public CategoryRecordsRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/records", Map.of("id", id));
    }

    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public CategoryRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    /**
     * Keeps all leaderboards in the results, regardless of whether they have any runs.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public CategoryRecordsRequest keepEmptyResults() {
        setParameter("skip-empty", false);
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
