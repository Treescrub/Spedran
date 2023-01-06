package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Platform extends IdentifiableNamedResource {
    private int released;

    public Platform(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Platform(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        released = data.getInt("released");
    }

    public int getReleaseYear() {
        return released;
    }

    @Override
    public String toString() {
        return "Platform[" + id + "]{" +
                "name='" + name + '\'' +
                ", released=" + released +
                "}";
    }
}
