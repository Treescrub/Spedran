package com.github.treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Contains international, Japanese, and Twitch names.
 */
public class Names {
    private String international;
    private String japanese;
    private String twitch;

    public Names(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Names(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        international = data.getString("international");
        japanese = data.optString("japanese", null);
        twitch = data.optString("twitch", null);
    }

    /**
     * Gets the international name for this item.
     *
     * @return international name
     */
    public String getInternationalName() {
        return international;
    }

    /**
     * Gets the japanese name for this item.
     *
     * @return an {@link Optional} with the japanese name, or empty if no japanese name.
     */
    public Optional<String> getJapaneseName() {
        return Optional.ofNullable(japanese);
    }

    /**
     * Gets the Twitch (as in the streaming site) name for this item.
     *
     * @return an {@link Optional} with the Twitch name, or empty if no Twitch name.
     */
    public Optional<String> getTwitchName() {
        return Optional.ofNullable(twitch);
    }

    @Override
    public String toString() {
        return "Names{" +
                "international='" + international + '\'' +
                ", japanese='" + japanese + '\'' +
                ", twitch='" + twitch + '\'' +
                '}';
    }
}
