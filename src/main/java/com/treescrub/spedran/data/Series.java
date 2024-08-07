package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.series.SeriesGamesRequest;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A collection of multiple games as part of one franchise.
 * <br>
 * For example: Super Mario, Sonic, Doom, Halo, and so on.
 * <br>
 * The special series named {@code N/A} is a placeholder when a game is not part of a series.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Series extends IdentifiableResource {
    private final Names names;
    private final String abbreviation;
    private final String weblink;
    private final String discord;
    private final Map<String, ModeratorType> moderators;
    private final Instant created;
    private final GameAssets assets;

    public Series(JSONObject data) {
        super(data);

        names = new Names(data.getJSONObject("names"));
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.optString("discord", null);
        Map<String, ModeratorType> tempModerators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            ModeratorType type = ModeratorType.fromAPI(data.getJSONObject("moderators").getString(key));
            tempModerators.put(key, type);
        }
        moderators = Collections.unmodifiableMap(tempModerators);
        if(!data.isNull("created")) {
            created = Instant.parse(data.getString("created"));
        } else {
            created = null;
        }
        assets = new GameAssets(data.getJSONObject("assets"));
    }

    /**
     * Gets a new {@link SeriesGamesRequest} builder object to request games that are part of this series.
     *
     * @return a {@code SeriesGamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest getGames() {
        return Spedran.getSeriesGames(id);
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
     * Gets a {@code Map} of user IDs as keys and moderator types as values.
     *
     * @return an unmodifiable {@code Map} of user IDs to moderator types
     *
     * @see User
     * @see Spedran#getUser(String)
     */
    public Map<String, ModeratorType> getModerators() {
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

    /**
     * Gets the {@link GameAssets} for this series.
     *
     * @return a {@code GameAssets} object
     */
    @SuppressWarnings("unused")
    public GameAssets getAssets() {
        return assets;
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
