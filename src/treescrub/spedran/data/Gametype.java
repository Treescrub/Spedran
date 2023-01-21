package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Gametype extends IdentifiableNamedResource {

    public Gametype(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Gametype(JSONObject data) {
        super(data);
    }

    public Gametype(String data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Gametype[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
