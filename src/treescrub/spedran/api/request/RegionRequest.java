package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Region;

import java.util.Map;

public class RegionRequest extends SingleResourceRequest<Region> {
    public RegionRequest(String id) {
        super(HttpMethod.GET, "regions/{id}", Map.of("id", id));
    }

    @Override
    protected Region parse(JSONObject data) {
        return new Region(data);
    }
}
