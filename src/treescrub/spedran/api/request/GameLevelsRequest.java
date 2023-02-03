package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Level;

import java.util.Map;
import java.util.function.Function;

public class GameLevelsRequest extends ResourceCollectionRequest<Level> {
    public GameLevelsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/levels", Map.of("id", id));
    }

    public GameLevelsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public GameLevelsRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public GameLevelsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Level> getConstructor() {
        return Level::new;
    }
}
