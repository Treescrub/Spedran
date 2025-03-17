package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Engine;
import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Gametype}.
 */
public class GametypeRequest extends SingleResourceRequest<Gametype> {
    @SuppressWarnings("unused")
    protected GametypeRequest(String id) {
        super(HttpMethod.GET, "gametypes/{id}", Map.of("id", id));
    }

    public static GametypeRequest create(Gametype gametype) {
        checkResource(gametype, "gametype");

        return new GametypeRequest(gametype.getId());
    }

    public static GametypeRequest create(String id) {
        checkId(id);

        return new GametypeRequest(id);
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
