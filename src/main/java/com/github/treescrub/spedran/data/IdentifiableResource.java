package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Objects;

public abstract class IdentifiableResource extends Resource {
    protected final String id;

    public IdentifiableResource(JSONObject data) {
        super(data);

        id = data.getString("id");
    }

    /**
     * Gets the ID for this resource.
     *
     * @return the resource ID
     */
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiableResource that = (IdentifiableResource) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
