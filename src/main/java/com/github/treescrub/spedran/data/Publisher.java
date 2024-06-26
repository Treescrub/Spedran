package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * A publisher of games.
 * <br>
 * For example: Bethesda Softworks, Valve, Nintendo, and so on.
 */
public class Publisher extends IdentifiableNamedResource {

    public Publisher(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all games that were published by this publisher.
     *
     * @return a {@code GamesRequest} builder
     */
    public GamesRequest getGames() {
        return Spedran.getGames().publisher(this);
    }

    @Override
    public String toString() {
        return "Publisher[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
