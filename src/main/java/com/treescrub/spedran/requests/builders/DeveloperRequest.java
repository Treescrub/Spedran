package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Developer;
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

    /**
     * Creates and returns a new {@code DeveloperRequest} builder.
     *
     * @param developer the developer to get
     * @return a {@code DeveloperRequest} builder
     */
    public static DeveloperRequest create(Developer developer) {
        checkResource(developer, "developer");

        return new DeveloperRequest(developer.getId());
    }

    /**
     * Creates and returns a new {@code DeveloperRequest} builder.
     *
     * @param id the developer to get
     * @return a {@code DeveloperRequest} builder
     */
    public static DeveloperRequest create(String id) {
        checkId(id);

        return new DeveloperRequest(id);
    }

    @Override
    protected Class<Developer> getDataClass() {
        return Developer.class;
    }
}
