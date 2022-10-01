package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public class Developer extends IdentifiableNamedResource {

    public Developer(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Developer(JSONObject data) {
        super(data);
    }
}
