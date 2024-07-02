package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import com.github.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

/**
 * A platform which a game can be run on.
 * <br>
 * For example: PC, Xbox 360, Game Boy Advance, Amazon Fire TV, and so on.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Platform extends IdentifiableNamedResource {
    private final int released;

    Platform(JSONObject data) {
        super(data);

        released = data.getInt("released");
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all games that are on this platform.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public GamesRequest getGames() {
        return Spedran.getGames().platform(this);
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs that are on this platform.
     *
     * @return a {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest getRuns() {
        return Spedran.getRuns().platform(this);
    }

    /**
     * Gets the year that this platform was released.
     *
     * @return release year
     */
    public int getReleaseYear() {
        return released;
    }

    @Override
    public String toString() {
        return "Platform[" + id + "]{" +
                "name='" + name + '\'' +
                ", released=" + released +
                "}";
    }
}
