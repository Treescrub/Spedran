package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public class CategoryPlayers {
    private boolean isExact;
    private int players;

    CategoryPlayers(JSONObject data) {
        isExact = data.getString("type").equals("exactly");
        players = data.getInt("value");
    }

    public boolean isExact() {
        return isExact;
    }

    public int getPlayers() {
        return players;
    }
}
