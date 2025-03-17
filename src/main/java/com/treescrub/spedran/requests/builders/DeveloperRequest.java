package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Developer;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Developer}.
 */
public class DeveloperRequest extends SingleResourceRequest<Developer> {
    @SuppressWarnings("unused")
    protected DeveloperRequest(String id) {
        super(HttpMethod.GET, "developers/{id}", Map.of("id", id));
    }

    public static DeveloperRequest create(Developer developer) {
        checkResource(developer, "developer");

        return new DeveloperRequest(developer.getId());
    }

    public static DeveloperRequest create(String id) {
        checkId(id);

        return new DeveloperRequest(id);
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
