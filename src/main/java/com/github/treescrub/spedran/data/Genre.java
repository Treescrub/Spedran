package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.json.JSONObject;

/**
 * A genre of game.
 * <br>
 * For example: FPS, platformer, and so on.
 */
public class Genre extends IdentifiableNamedResource {

    public Genre(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games that are in this genre.
     *
     * @return a {@code GamesRequest} builder
     */
    public GamesRequest getGames() {
        return Spedran.getGames().genre(this);
    }

    @Override
    public String toString() {
        return "Genre[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
