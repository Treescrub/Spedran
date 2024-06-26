package com.github.treescrub.spedran.requests.gametype;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Gametype;

import java.util.Map;

public class GametypeRequest extends SingleResourceRequest<Gametype> {
    public GametypeRequest(String id) {
        super(HttpMethod.GET, "gametypes/{id}", Map.of("id", id));
    }

    public GametypeRequest(Gametype gametype) {
        this(gametype.getId());
    }

    @Override
    protected Gametype parse(JSONObject data) {
        return new Gametype(data);
    }
}
