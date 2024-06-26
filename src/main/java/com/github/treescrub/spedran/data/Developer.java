package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * The developer of a game.
 */
public class Developer extends IdentifiableNamedResource {

    public Developer(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games developed by this developer.
     *
     * @return a {@code GamesRequest} builder
     */
    public GamesRequest getGames() {
        return Spedran.getGames().developer(this);
    }

    @Override
    public String toString() {
        return "Developer[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
