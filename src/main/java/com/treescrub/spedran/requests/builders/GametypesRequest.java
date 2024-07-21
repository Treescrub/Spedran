package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.requests.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Gametype}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class GametypesRequest extends ResourceCollectionRequest<Gametype> {
    @SuppressWarnings("unused")
    public GametypesRequest() {
        super(HttpMethod.GET, "gametypes");
    }

    /**
     * Sorts the results alphanumerically by name.
     *
     * @return this {@code GametypesRequest} builder
     */
    @SuppressWarnings("unused")
    public GametypesRequest sortByName() {
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
    public GametypesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
