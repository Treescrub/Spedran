package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Region;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

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
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
