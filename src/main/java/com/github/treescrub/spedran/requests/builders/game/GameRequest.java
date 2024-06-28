package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Game}.
 */
public class GameRequest extends SingleResourceRequest<Game> {
    public GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    public GameRequest(Game game) {
        this(game.getId());
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
