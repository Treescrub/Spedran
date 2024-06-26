package com.github.treescrub.spedran.requests.builders.platform;

import com.github.treescrub.spedran.data.Platform;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

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
    protected Class<Platform> getDataClass() {
        return Platform.class;
    }
}
