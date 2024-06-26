package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * The game engine used in a game.
 */
public class Engine extends IdentifiableNamedResource {

    public Engine(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games using this game engine.
     *
     * @return a {@code GamesRequest} builder
     */
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
