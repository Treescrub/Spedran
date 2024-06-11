package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 * The developer of a game.
 */
public class Developer extends IdentifiableNamedResource {

    public Developer(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Developer(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Developer[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
