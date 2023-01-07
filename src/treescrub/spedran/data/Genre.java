package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Genre extends IdentifiableNamedResource {

    public Genre(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Genre(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    @Override
    public String toString() {
        return "Genre[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
