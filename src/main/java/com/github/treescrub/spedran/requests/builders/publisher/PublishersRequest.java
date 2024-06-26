package com.github.treescrub.spedran.requests.builders.publisher;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import com.github.treescrub.spedran.data.Publisher;

import java.util.function.Function;

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
    protected Function<JSONObject, Publisher> getConstructor() {
        return Publisher::new;
    }
}
