package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import com.github.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

/**
 * Historical regions of the world where games were distributed.
 * <br>
 * Name consists of a shortened country or region name and either {@code NTSC} or {@code PAL}.
 * <br>
 * For example: {@code USA / NTSC}.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Region extends IdentifiableNamedResource {

    Region(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all games that use this region.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public GamesRequest getGames() {
        return Spedran.getGames().region(this);
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs that are played in this region.
     *
     * @return a {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest getRuns() {
        return Spedran.getRuns().region(this);
    }

    @Override
    public String toString() {
        return "Region[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
