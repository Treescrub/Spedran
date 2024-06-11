package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 * Historical regions of the world where games were distributed.
 * <br>
 * Name consists of a shortened country or region name and either {@code NTSC} or {@code PAL}.
 * <br>
 * For example: {@code USA / NTSC}.
 */
public class Region extends IdentifiableNamedResource {

    public Region(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Region(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Region[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
