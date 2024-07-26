package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.data.Region;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Gametype}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class RegionsRequest extends ResourceCollectionRequest<Region> {
    @SuppressWarnings("unused")
    public RegionsRequest() {
        super(HttpMethod.GET, "regions");
    }

    /**
     * Sorts the results alphanumerically by name.
     *
     * @return this {@code GenresRequest} builder
     */
    @SuppressWarnings("unused")
    public RegionsRequest sortByName() {
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
    public RegionsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
