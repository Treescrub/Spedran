package treescrub.spedran.api.request.developer;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Developer;

import java.util.function.Function;

public class DevelopersRequest extends ResourceCollectionRequest<Developer> {
    public DevelopersRequest() {
        super(HttpMethod.GET, "developers");
    }

    public DevelopersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Developer> getConstructor() {
        return Developer::new;
    }
}
