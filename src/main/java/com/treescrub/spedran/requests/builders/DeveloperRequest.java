package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Developer;
import com.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Developer}.
 */
public class DeveloperRequest extends SingleResourceRequest<Developer> {
    @SuppressWarnings("unused")
    public DeveloperRequest(String id) {
        super(HttpMethod.GET, "developers/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public DeveloperRequest(Developer developer) {
        this(developer.getId());
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
