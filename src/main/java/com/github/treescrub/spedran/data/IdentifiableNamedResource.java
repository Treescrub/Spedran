package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public abstract class IdentifiableNamedResource extends IdentifiableResource {
    protected final String name;

    public IdentifiableNamedResource(JSONObject data) {
        super(data);

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
