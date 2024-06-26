package com.github.treescrub.spedran.requests.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.game.Game;

import java.util.Map;

public class GameRequest extends SingleResourceRequest<Game> {
    public GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    public GameRequest(Game game) {
        this(game.getId());
    }

    @Override
    protected Game parse(JSONObject data) {
        return new Game(data);
    }
}
