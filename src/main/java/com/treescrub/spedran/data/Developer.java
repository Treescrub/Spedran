package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * The developer of a game.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Developer extends IdentifiableNamedResource {

    Developer(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games developed by this developer.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
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
