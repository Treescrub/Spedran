package treescrub.spedran.api.request.genre;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Genre;

import java.util.Map;

public class GenreRequest extends SingleResourceRequest<Genre> {
    public GenreRequest(String id) {
        super(HttpMethod.GET, "genres/{id}", Map.of("id", id));
    }

    @Override
    protected Genre parse(JSONObject data) {
        return new Genre(data);
    }
}
