package com.github.treescrub.spedran.requests.builders.gametype;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import com.github.treescrub.spedran.data.Gametype;

import java.util.function.Function;

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
    protected Function<JSONObject, Gametype> getConstructor() {
        return Gametype::new;
    }
}
