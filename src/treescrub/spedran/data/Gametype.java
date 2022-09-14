package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Gametype extends Resource {
    private String id;
    private String name;

    public Gametype(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Gametype(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
