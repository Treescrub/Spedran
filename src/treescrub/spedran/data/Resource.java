package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public abstract class Resource {
    public Resource(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Resource(JSONObject data) {
        parseFromJson(data);
    }

    protected Resource() {}

    protected abstract void parseFromJson(JSONObject data);
}
