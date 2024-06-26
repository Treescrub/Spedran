package com.github.treescrub.spedran.requests.builders.publisher;

import com.github.treescrub.spedran.data.Publisher;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

public class PublishersRequest extends ResourceCollectionRequest<Publisher> {
    public PublishersRequest() {
        super(HttpMethod.GET, "publishers");
    }

    public PublishersRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public PublishersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Publisher> getDataClass() {
        return Publisher.class;
    }
}
