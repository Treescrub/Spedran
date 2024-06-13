package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * A genre of game.
 * <br>
 * For example: FPS, platformer, and so on.
 */
public class Genre extends IdentifiableNamedResource {

    public Genre(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Genre[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
