package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * The game engine used in a game.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Engine extends IdentifiableNamedResource {

    Engine(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games using this game engine.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public GamesRequest getGames() {
        return Spedran.getGames().engine(this);
    }

    @Override
    public String toString() {
        return "Engine[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
