package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A link consisting of a URI and optionally a relation.
 */
public class Link {
    private final String uri;
    private final String rel;

    public Link(JSONObject data) {
        uri = data.getString("uri");
        rel = data.optString("rel", null);
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
