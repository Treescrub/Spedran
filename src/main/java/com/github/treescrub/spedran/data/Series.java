package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.api.request.series.SeriesGamesRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A collection of multiple games as part of one franchise.
 * <br>
 * For example: Super Mario, Sonic, Doom, Halo, and so on.
 * <br>
 * The special series named {@code N/A} is a placeholder when a game is not part of a series.
 */
public class Series extends IdentifiableResource {
    private Names names;
    private String abbreviation;
    private String weblink;
    private String discord;
    private Map<String, String> moderators;
    private Instant created;

    public Series(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Series(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link SeriesGamesRequest} builder object to request games that are part of this series.
     *
     * @return a {@code SeriesGamesRequest} builder
     */
    public SeriesGamesRequest getGames() {
        return new SeriesGamesRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        names = new Names(data.getJSONObject("names"));
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.optString("discord", null);
        moderators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            moderators.put(key, data.getJSONObject("moderators").getString(key));
        }
        if(!data.isNull("created"))
            created = Instant.parse(data.getString("created"));
    }

    /**
     * Gets the {@link Names} for this series.
     *
     * @return a {@code Names} for the series name
     */
    public Names getNames() {
        return names;
    }

    /**
     * Gets the abbreviation for this series as used on SRC.
     *
     * @return the abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Gets the link to this series on SRC.
     *
     * @return the link
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * Gets the Discord invite link for the Discord server dedicated to this series.
     *
     * @return an {@link Optional} with the invite link
     */
    public Optional<String> getDiscord() {
        return Optional.ofNullable(discord);
    }

    /**
     * Gets a {@code Map} of moderator user IDs to their moderator role (either {@code moderator} or {@code super-moderator}).
     *
     * @return a {@link Map} with user IDs as keys and role as values
     */
    public Map<String, String> getModerators() {
        return moderators;
    }

    /**
     * Gets the time that this series was created on SRC.
     *
     * @return an {@link Optional} with the {@link Instant} this series was created, empty if unknown.
     */
    public Optional<Instant> getCreationTime() {
        return Optional.ofNullable(created);
    }

    @Override
    public String toString() {
        return "Series[" + id + "]{" +
                "names=" + names +
                ", abbreviation='" + abbreviation + '\'' +
                ", created=" + created +
                "}";
    }
}
