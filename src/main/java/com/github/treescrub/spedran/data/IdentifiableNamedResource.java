package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * A resource from the SRC API that has a unique ID and a name.
 */
public abstract class IdentifiableNamedResource extends IdentifiableResource {
    protected final String name;

    protected IdentifiableNamedResource(JSONObject data) {
        super(data);

        name = data.getString("name");
    }

    /**
     * Gets the name for this resource.
     *
     * @return the resource's name
     */
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }
}
