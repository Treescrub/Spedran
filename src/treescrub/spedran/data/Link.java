package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Link {
    private String uri;
    private String rel;

    public Link(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Link(JSONObject data) {
        uri = data.getString("uri");
        if(data.has("rel"))
            rel = data.getString("rel");
    }

    public String getURI() {
        return uri;
    }

    public Optional<String> getRelation() {
        return Optional.ofNullable(rel);
    }
}
