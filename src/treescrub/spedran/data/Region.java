package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Region extends IdentifiableNamedResource {

    public Region(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Region(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Region[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
