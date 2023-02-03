package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.game.Game;

import java.util.Map;

public class GameRequest extends SingleResourceRequest<Game> {
    public GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    @Override
    protected Game parse(JSONObject data) {
        return new Game(data);
    }
}
