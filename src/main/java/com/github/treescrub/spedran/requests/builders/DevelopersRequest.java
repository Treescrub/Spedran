package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Developer;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Developer}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class DevelopersRequest extends ResourceCollectionRequest<Developer> {
    @SuppressWarnings("unused")
    public DevelopersRequest() {
        super(HttpMethod.GET, "developers");
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public DevelopersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
