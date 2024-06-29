package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the possible {@link Category}s for a given {@link Level}.
 */
public class LevelCategoriesRequest extends ResourceCollectionRequest<Category> {
    @SuppressWarnings("unused")
    public LevelCategoriesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/categories", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public LevelCategoriesRequest(Level level) {
        this(level.getId());
    }

    /**
     * Restricts whether miscellaneous categories should be in the results.
     *
     * @param includeMiscellaneous {@code true} to include miscellaneous categories, otherwise {@code false}
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Sorts the results alphanumerically by the category name.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the results by the miscellaneous boolean flag.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByMiscellaneous() {
        setSortParameter("miscellaneous");
        return this;
    }

    /**
     * Sorts the results by the moderator defined category position.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
