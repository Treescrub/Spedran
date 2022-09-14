package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Platform {
    private String id;
    private String name;
    private int released;

    public Platform(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Platform(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
        released = data.getInt("released");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return released;
    }
}
