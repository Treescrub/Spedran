package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Platform extends IdentifiableResource {
    private String name;
    private int released;

    public Platform(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Platform(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        name = data.getString("name");
        released = data.getInt("released");
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return released;
    }
}
