package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Game}.
 */
public class GameRequest extends SingleResourceRequest<Game> {
    @SuppressWarnings("unused")
    public GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GameRequest(Game game) {
        this(game.getId());
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
