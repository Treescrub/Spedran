package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 *
 */
public class Link {
    private String uri;
    private String rel;

    public Link(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Link(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        uri = data.getString("uri");
        if(data.has("rel"))
            rel = data.getString("rel");
    }

    /**
     *
     * @return
     */
    public String getURI() {
        return uri;
    }

    /**
     *
     * @return
     */
    public Optional<String> getRelation() {
        return Optional.ofNullable(rel);
    }

    @Override
    public String toString() {
        return "Link{" +
                "uri='" + uri + '\'' +
                ", rel='" + rel + '\'' +
                '}';
    }
}
