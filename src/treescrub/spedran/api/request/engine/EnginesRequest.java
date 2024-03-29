package treescrub.spedran.api.request.engine;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Engine;

import java.util.function.Function;

/**
 * A request builder to get all engines.
 * Always sorts by name.
 */
public class EnginesRequest extends ResourceCollectionRequest<Engine> {
    public EnginesRequest() {
        super(HttpMethod.GET, "engines");
    }

    /**
     * Sets the direction to sort the returned engines.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    public EnginesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Engine> getConstructor() {
        return Engine::new;
    }
}
