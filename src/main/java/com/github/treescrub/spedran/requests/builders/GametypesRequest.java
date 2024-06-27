package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Gametype;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

public class GametypesRequest extends ResourceCollectionRequest<Gametype> {
    public GametypesRequest() {
        super(HttpMethod.GET, "gametypes");
    }

    public GametypesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public GametypesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
