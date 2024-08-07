package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * A publisher of games.
 * <br>
 * For example: Bethesda Softworks, Valve, Nintendo, and so on.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Publisher extends IdentifiableNamedResource {

    Publisher(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all games that were published by this publisher.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
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
