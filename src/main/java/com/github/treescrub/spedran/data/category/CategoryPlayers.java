package com.github.treescrub.spedran.data.category;

import kong.unirest.json.JSONObject;

/**
 * Contains the rules for how many players can participate in the category.
 */
public class CategoryPlayers {
    private boolean isExact;
    private int players;

    public CategoryPlayers(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        isExact = data.getString("type").equals("exactly");
        players = data.getInt("value");
    }

    /**
     * If {@code true}, there must be exactly {@link CategoryPlayers#getPlayers()} players.
     * If {@code false}, there can be up to {@link CategoryPlayers#getPlayers()} players.
     *
     * @return {@code true} if there must be an exact amount of runners, {@code false} otherwise
     */
    public boolean isExact() {
        return isExact;
    }

    /**
     * Gets the number of allowed players.
     *
     * @return player count
     */
    public int getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "CategoryPlayers{" +
                "isExact=" + isExact +
                ", players=" + players +
                '}';
    }
}
