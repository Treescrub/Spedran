package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Gametype}.
 */
public class GametypeRequest extends SingleResourceRequest<Gametype> {
    @SuppressWarnings("unused")
    public GametypeRequest(String id) {
        super(HttpMethod.GET, "gametypes/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GametypeRequest(Gametype gametype) {
        this(gametype.getId());
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
