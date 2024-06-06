package com.github.treescrub.spedran.data.category;

import kong.unirest.json.JSONObject;

/**
 *
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
     *
     * @return
     */
    public boolean isExact() {
        return isExact;
    }

    /**
     *
     * @return
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
