package com.github.treescrub.spedran.requests.builders.developer;

import com.github.treescrub.spedran.data.Developer;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all developers.
 * Always sorts by name.
 */
public class DevelopersRequest extends ResourceCollectionRequest<Developer> {
    public DevelopersRequest() {
        super(HttpMethod.GET, "developers");
    }

    /**
     * Sets the direction to sort the returned developers.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    public DevelopersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
