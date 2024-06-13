package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * A platform which a game can be run on.
 * <br>
 * For example: PC, Xbox 360, Game Boy Advance, Amazon Fire TV, and so on.
 */
public class Platform extends IdentifiableNamedResource {
    private final int released;

    public Platform(JSONObject data) {
        super(data);

        released = data.getInt("released");
    }

    /**
     * Gets the year that this platform was released.
     *
     * @return release year
     */
    public int getReleaseYear() {
        return released;
    }

    @Override
    public String toString() {
        return "Platform[" + id + "]{" +
                "name='" + name + '\'' +
                ", released=" + released +
                "}";
    }
}
