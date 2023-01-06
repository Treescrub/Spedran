package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Engine extends IdentifiableNamedResource {

    public Engine(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Engine(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Engine[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
