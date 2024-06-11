package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 * The game engine used in a game.
 */
public class Engine extends IdentifiableNamedResource {

    public Engine(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Engine(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Engine[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
