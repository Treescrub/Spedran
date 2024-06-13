package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * The game engine used in a game.
 */
public class Engine extends IdentifiableNamedResource {

    public Engine(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Engine[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
