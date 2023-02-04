package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Region;

import java.util.function.Function;

public class RegionsRequest extends ResourceCollectionRequest<Region> {
    public RegionsRequest() {
        super(HttpMethod.GET, "regions");
    }

    public RegionsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public RegionsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Region> getConstructor() {
        return Region::new;
    }
}
