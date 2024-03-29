package treescrub.spedran.api.request.level;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Level;

import java.util.Map;

public class LevelRequest extends SingleResourceRequest<Level> {
    public LevelRequest(String id) {
        super(HttpMethod.GET, "levels/{id}", Map.of("id", id));
    }

    public LevelRequest(Level level) {
        this(level.getId());
    }

    @Override
    protected Level parse(JSONObject data) {
        return new Level(data);
    }
}
