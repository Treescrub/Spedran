package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 *
 */
public class Gametype extends IdentifiableNamedResource {

    public Gametype(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Gametype(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getGametype(String)
     */
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Gametype[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
