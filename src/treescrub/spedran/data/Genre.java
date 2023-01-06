package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Genre extends IdentifiableNamedResource {

    public Genre(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Genre(JSONObject data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Genre[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
