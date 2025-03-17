package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.data.Publisher;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Gametype}s matching the set filters.
 * <br><br>
 * Always sorts by name.
 */
public class PublishersRequest extends ResourceCollectionRequest<Publisher> {
    @SuppressWarnings("unused")
    protected PublishersRequest() {
        super(HttpMethod.GET, "publishers");
    }

    /**
     * Creates and returns a new {@code PublishersRequest} builder.
     *
     * @return a {@code PublishersRequest} builder
     */
    public static PublishersRequest create() {
        return new PublishersRequest();
    }

    /**
     * Sorts the results alphanumerically by name.
     *
     * @return this {@code GenresRequest} builder
     */
    @SuppressWarnings("unused")
    public PublishersRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code PublishersRequest} builder
     */
    @SuppressWarnings("unused")
    public PublishersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Publisher> getDataClass() {
        return Publisher.class;
    }
}
