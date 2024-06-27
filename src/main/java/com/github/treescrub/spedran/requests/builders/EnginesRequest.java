package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Engine;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all engines.
 * Always sorts by name.
 */
public class EnginesRequest extends ResourceCollectionRequest<Engine> {
    public EnginesRequest() {
        super(HttpMethod.GET, "engines");
    }

    /**
     * Sets the direction to sort the returned engines.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    public EnginesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Engine> getDataClass() {
        return Engine.class;
    }
}
