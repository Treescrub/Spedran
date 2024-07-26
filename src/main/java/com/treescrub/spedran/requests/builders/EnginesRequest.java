package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Engine;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Engine}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class EnginesRequest extends ResourceCollectionRequest<Engine> {
    @SuppressWarnings("unused")
    public EnginesRequest() {
        super(HttpMethod.GET, "engines");
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public EnginesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Engine> getDataClass() {
        return Engine.class;
    }
}
