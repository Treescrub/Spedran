package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 *
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

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getRegion(String)
     */
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Region[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
