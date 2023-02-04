package treescrub.spedran.api.request.developer;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Developer;

import java.util.Map;

public class DeveloperRequest extends SingleResourceRequest<Developer> {
    public DeveloperRequest(String id) {
        super(HttpMethod.GET, "developers/{id}", Map.of("id", id));
    }

    @Override
    protected Developer parse(JSONObject data) {
        return new Developer(data);
    }
}
