package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.game.GamesRequest;
import com.github.treescrub.spedran.requests.run.RunsRequest;
import kong.unirest.json.JSONObject;

/**
 * Historical regions of the world where games were distributed.
 * <br>
 * Name consists of a shortened country or region name and either {@code NTSC} or {@code PAL}.
 * <br>
 * For example: {@code USA / NTSC}.
 */
public class Region extends IdentifiableNamedResource {

    public Region(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all games that use this region.
     *
     * @return a {@code GamesRequest} builder
     */
    public GamesRequest getGames() {
        return Spedran.getGames().region(this);
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs that are played in this region.
     *
     * @return a {@code RunsRequest} builder
     */
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
