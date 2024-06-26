package com.github.treescrub.spedran.requests.builders.region;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import com.github.treescrub.spedran.data.Region;

import java.util.function.Function;

public class RegionsRequest extends ResourceCollectionRequest<Region> {
    public RegionsRequest() {
        super(HttpMethod.GET, "regions");
    }

    public RegionsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public RegionsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Region> getConstructor() {
        return Region::new;
    }
}
