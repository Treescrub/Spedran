package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
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
