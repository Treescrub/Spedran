package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Genre;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Genre}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class GenresRequest extends ResourceCollectionRequest<Genre> {
    @SuppressWarnings("unused")
    public GenresRequest() {
        super(HttpMethod.GET, "genres");
    }

    /**
     * Sorts the results alphanumerically by name.
     *
     * @return this {@code GenresRequest} builder
     */
    @SuppressWarnings("unused")
    public GenresRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public GenresRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Genre> getDataClass() {
        return Genre.class;
    }
}
