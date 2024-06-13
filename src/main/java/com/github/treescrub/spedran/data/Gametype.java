package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * Represents different types of unofficial games.
 * <br>
 * For example: ROM hacks, mods, category extensions, and so on.
 */
public class Gametype extends IdentifiableNamedResource {

    public Gametype(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Gametype[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
