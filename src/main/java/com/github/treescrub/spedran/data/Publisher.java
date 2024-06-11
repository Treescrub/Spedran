package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 * A publisher of games.
 * <br>
 * For example: Bethesda Softworks, Valve, Nintendo, and so on.
 */
public class Publisher extends IdentifiableNamedResource {

    public Publisher(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Publisher(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Publisher[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
