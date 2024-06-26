package com.github.treescrub.spedran.requests.builders.developer;

import com.github.treescrub.spedran.data.Developer;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class DeveloperRequest extends SingleResourceRequest<Developer> {
    public DeveloperRequest(String id) {
        super(HttpMethod.GET, "developers/{id}", Map.of("id", id));
    }

    public DeveloperRequest(Developer developer) {
        this(developer.getId());
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
