package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public abstract class IdentifiableNamedResource extends IdentifiableResource {
    protected String name;

    public IdentifiableNamedResource(HttpResponse<JsonNode> data) {
        super(data);
    }

    public IdentifiableNamedResource(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        name = data.getString("name");
    }

    /**
     * Gets the name for this resource.
     *
     * @return the resource's name
     */
    public String getName() {
        return name;
    }
}
