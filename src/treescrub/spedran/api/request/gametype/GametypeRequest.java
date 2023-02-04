package treescrub.spedran.api.request.gametype;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Gametype;

import java.util.Map;

public class GametypeRequest extends SingleResourceRequest<Gametype> {
    public GametypeRequest(String id) {
        super(HttpMethod.GET, "gametypes/{id}", Map.of("id", id));
    }

    @Override
    protected Gametype parse(JSONObject data) {
        return new Gametype(data);
    }
}
