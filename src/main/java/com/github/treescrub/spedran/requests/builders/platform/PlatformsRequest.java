package com.github.treescrub.spedran.requests.builders.platform;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.data.Platform;

import java.util.function.Function;

public class PlatformsRequest extends ResourceCollectionRequest<Platform> {
    public PlatformsRequest() {
        super(HttpMethod.GET, "platforms");
    }

    public PlatformsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public PlatformsRequest sortByReleaseYear() {
        setSortParameter("released");
        return this;
    }

    @Override
    protected Function<JSONObject, Platform> getConstructor() {
        return Platform::new;
    }
}
