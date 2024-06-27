package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Gametype;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Gametype}.
 */
public class GametypeRequest extends SingleResourceRequest<Gametype> {
    public GametypeRequest(String id) {
        super(HttpMethod.GET, "gametypes/{id}", Map.of("id", id));
    }

    public GametypeRequest(Gametype gametype) {
        this(gametype.getId());
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
