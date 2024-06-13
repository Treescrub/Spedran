package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * The developer of a game.
 */
public class Developer extends IdentifiableNamedResource {

    public Developer(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Developer[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
