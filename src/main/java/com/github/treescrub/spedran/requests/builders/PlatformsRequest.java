package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Platform;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Platform}s matching the set filters.
 */
public class PlatformsRequest extends ResourceCollectionRequest<Platform> {
    @SuppressWarnings("unused")
    public PlatformsRequest() {
        super(HttpMethod.GET, "platforms");
    }

    /**
     * Sorts the results alphanumerically by the platform name.
     *
     * @return this {@code PlatformsRequest} builder
     */
    @SuppressWarnings("unused")
    public PlatformsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the results by the year the platform was released.
     *
     * @return this {@code PlatformsRequest} builder
     */
    @SuppressWarnings("unused")
    public PlatformsRequest sortByReleaseYear() {
        setSortParameter("released");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code PlatformsRequest} builder
     */
    @SuppressWarnings("unused")
    public PlatformsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Platform> getDataClass() {
        return Platform.class;
    }
}
