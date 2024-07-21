package com.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 * A resource from the SRC API.
 */
public abstract class Resource {
    @SuppressWarnings("unused")
    protected Resource(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    @SuppressWarnings("unused")
    protected Resource(JSONObject data) {}
}
