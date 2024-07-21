package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Contains international, Japanese, and Twitch names.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Names {
    private final String international;
    private final String japanese;
    private final String twitch;

    Names(JSONObject data) {
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
     * Gets the Japanese name for this item.
     *
     * @return an {@link Optional} with the Japanese name, or empty if no Japanese name.
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
