package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * Represents different types of unofficial games.
 * <br>
 * For example: ROM hacks, mods, category extensions, and so on.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Gametype extends IdentifiableNamedResource {

    Gametype(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games that fall under this gametype.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public GamesRequest getGames() {
        return Spedran.getGames().gameType(this);
    }

    @Override
    public String toString() {
        return "Gametype[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
