package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A link consisting of a URI and optionally a relation.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Link {
    private final String uri;
    private final String rel;

    Link(JSONObject data) {
        uri = data.getString("uri");
        rel = data.optString("rel", null);
    }

    private static boolean isEmpty(JSONObject data) {
        return data.optString("uri", null) == null;
    }

    /**
     * Gets a {@link Link} from the provided JSON, or {@code null} if it's an empty {@code Link}.
     *
     * @param data the JSON data
     * @return a {@code Link}, null if not a valid {@code Link}
     */
    static Link getLinkOrNull(JSONObject data) {
        if(isEmpty(data)) {
            return null;
        } else {
            return new Link(data);
        }
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
