package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Gametype extends IdentifiableNamedResource {

    public Gametype(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Gametype(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Gametype[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
