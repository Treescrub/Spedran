package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A link consisting of a URI and optionally a relation.
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
     * Gets the URI for this link.
     *
     * @return the URI
     */
    public String getURI() {
        return uri;
    }

    /**
     * Gets the relation for this link.
     *
     * @return an {@link Optional} with the relation, or empty if not set
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
