package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Gametype;
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

    /**
     * Creates and returns a new {@code GametypeRequest} builder.
     *
     * @param gametype the gametype to get
     * @return a {@code GametypeRequest} builder
     */
    public static GametypeRequest create(Gametype gametype) {
        checkResource(gametype, "gametype");

        return new GametypeRequest(gametype.getId());
    }

    /**
     * Creates and returns a new {@code GametypeRequest} builder.
     *
     * @param id the gametype to get
     * @return a {@code GametypeRequest} builder
     */
    public static GametypeRequest create(String id) {
        checkId(id);

        return new GametypeRequest(id);
    }

    @Override
    protected Class<Gametype> getDataClass() {
        return Gametype.class;
    }
}
