package com.github.treescrub.spedran.data.game;

import com.github.treescrub.spedran.api.request.game.*;
import com.github.treescrub.spedran.data.IdentifiableResource;
import com.github.treescrub.spedran.data.Names;
import com.github.treescrub.spedran.data.ParseUtils;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 * A game which has a leaderboard on SRC.
 */
public class Game extends IdentifiableResource {
    private final Names names;
    private final Integer boostReceived;
    private final Integer boostDistinctDonors;
    private final String abbreviation;
    private final String weblink;
    private final String discord;
    private final LocalDate releaseDate;
    private final GameRuleset ruleset;
    private final List<String> gametypes;
    private final List<String> platforms;
    private final List<String> regions;
    private final List<String> genres;
    private final List<String> engines;
    private final List<String> developers;
    private final List<String> publishers;
    private final Map<String, String> moderators;
    private final Instant created;

    public Game(JSONObject data) {
        super(data);

        names = new Names(data.getJSONObject("names"));
        boostReceived = data.getInt("boostReceived");
        boostDistinctDonors = data.getInt("boostDistinctDonors");
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.getString("discord").isEmpty() ? null : data.getString("discord");
        releaseDate = LocalDate.parse(data.getString("release-date"));
        ruleset = new GameRuleset(data.getJSONObject("ruleset"));
        gametypes = ParseUtils.getStringList(data.getJSONArray("gametypes"));
        platforms = ParseUtils.getStringList(data.getJSONArray("platforms"));
        regions = ParseUtils.getStringList(data.getJSONArray("regions"));
        genres = ParseUtils.getStringList(data.getJSONArray("genres"));
        engines = ParseUtils.getStringList(data.getJSONArray("engines"));
        developers = ParseUtils.getStringList(data.getJSONArray("developers"));
        publishers = ParseUtils.getStringList(data.getJSONArray("publishers"));
        Map<String, String> tempModerators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            tempModerators.put(key, data.getJSONObject("moderators").getString(key));
        }
        moderators = Collections.unmodifiableMap(tempModerators);
        created = !data.isNull("created") ? Instant.parse(data.getString("created")) : null;
    }

    /**
     * Gets a new {@link GameCategoriesRequest} builder object to request categories for this game.
     *
     * @return a {@code GameCategoriesRequest} builder
     */
    public GameCategoriesRequest getCategories() {
        return new GameCategoriesRequest(this);
    }

    /**
     * Gets a new {@link GameLevelsRequest} builder object to request levels for this game.
     *
     * @return a {@code GameLevelsRequest} builder
     */
    public GameLevelsRequest getLevels() {
        return new GameLevelsRequest(this);
    }

    /**
     * Gets a new {@link GameRecordsRequest} builder object to request records for this game.
     *
     * @return a {@code GameRecordsRequest} builder
     */
    public GameRecordsRequest getRecords() {
        return new GameRecordsRequest(this);
    }

    /**
     * Gets a new {@link GameRomhacksRequest} builder object to request romhacks (derived games) for this game.
     *
     * @return a {@code GameRomhacksRequest} builder
     */
    public GameRomhacksRequest getRomhacks() {
        return new GameRomhacksRequest(this);
    }

    /**
     * Gets a new {@link GameVariablesRequest} builder object to request variables for this game.
     *
     * @return a {@code GameVariablesRequest} builder
     */
    public GameVariablesRequest getVariables() {
        return new GameVariablesRequest(this);
    }

    /**
     * Gets a {@link Names} object with the names for this game.
     *
     * @return a {@code Names} of this game's names
     */
    public Names getNames() {
        return names;
    }

    /**
     * Gets the current boosts for this game on SRC.
     *
     * @return current boosts used on this game
     *
     * @see <a href="https://www.speedrun.com/supporter/faq">SRC Supporter FAQ</a>
     */
    public Integer getBoostsReceived() {
        return boostReceived;
    }

    /**
     * Gets the number of unique supporters currently boosting this game.
     *
     * @return total unique users that have boosted this game
     *
     * @see <a href="https://www.speedrun.com/supporter/faq">SRC Supporter FAQ</a>
     */
    public Integer getDistinctBoosters() {
        return boostDistinctDonors;
    }

    /**
     * Gets the unique shortened name that is used by SRC.
     *
     * @return the shortened game title
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Gets a link to this game on SRC.
     *
     * @return a link to this game on SRC
     */
    public String getWebLink() {
        return weblink;
    }

    /**
     * Gets a Discord invite link to the official Discord server for this game, if it exists.
     *
     * @return an {@link Optional} with an invitation link to this game's Discord server
     */
    public Optional<String> getDiscordLink() {
        return Optional.ofNullable(discord);
    }

    /**
     * Gets the date when this game was released.
     *
     * @return a {@link LocalDate} describing when this game was released
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Gets a {@link GameRuleset} object with the game-wide rules.
     *
     * @return an {@link Optional} with a {@code GameRuleset}
     */
    public Optional<GameRuleset> getRuleset() {
        return Optional.ofNullable(ruleset);
    }

    /**
     * Gets a {@code List} of all gametype IDs that describe this game.
     *
     * @return a {@code List} of gametype IDs
     *
     * @see com.github.treescrub.spedran.data.Gametype
     * @see com.github.treescrub.spedran.api.Spedran#getGametype(String)
     */
    public List<String> getGametypes() {
        return gametypes;
    }

    /**
     * Gets a {@code List} of platform IDs that this game is on.
     *
     * @return a {@code List} of platform IDs
     *
     * @see com.github.treescrub.spedran.data.Platform
     * @see com.github.treescrub.spedran.api.Spedran#getPlatform(String)
     */
    public List<String> getPlatforms() {
        return platforms;
    }

    /**
     * Gets a {@code List} of region IDs that this game is in.
     *
     * @return a {@code List} of region IDs
     *
     * @see com.github.treescrub.spedran.data.Region
     * @see com.github.treescrub.spedran.api.Spedran#getRegion(String)
     */
    public List<String> getRegions() {
        return regions;
    }

    /**
     * Gets a {@code List} of genre IDs that this game is in.
     *
     * @return a {@code List} of genre IDs
     *
     * @see com.github.treescrub.spedran.data.Genre
     * @see com.github.treescrub.spedran.api.Spedran#getGenre(String)
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Gets a {@code List} of engine IDs that this game runs in.
     *
     * @return a {@code List} of engine IDs
     *
     * @see com.github.treescrub.spedran.data.Engine
     * @see com.github.treescrub.spedran.api.Spedran#getEngine(String)
     */
    public List<String> getEngines() {
        return engines;
    }

    /**
     * Gets a {@code List} of developer IDs that developed this game.
     *
     * @return a {@code List} of developer IDs
     *
     * @see com.github.treescrub.spedran.data.Developer
     * @see com.github.treescrub.spedran.api.Spedran#getDeveloper(String)
     */
    public List<String> getDevelopers() {
        return developers;
    }

    /**
     * Gets a {@code List} of publisher IDs that published this game.
     *
     * @return a {@code List} of publisher IDs
     *
     * @see com.github.treescrub.spedran.data.Publisher
     * @see com.github.treescrub.spedran.api.Spedran#getPublisher(String)
     */
    public List<String> getPublishers() {
        return publishers;
    }

    /**
     * Gets a {@code Map} of user IDs as keys and moderator types as values.
     *
     * @return a {@code Map} of user IDs to moderator types
     *
     * @see com.github.treescrub.spedran.data.user.User
     * @see com.github.treescrub.spedran.api.Spedran#getUser(String)
     */
    public Map<String, String> getModerators() {
        return moderators;
    }

    /**
     * Returns an {@link Instant} with the time this game was added to SRC.
     * <p>
     * Games added before this field was implemented will return an empty Optional.
     *
     * @return an {@link Optional} with an {@code Instant} describing when this game was added to SRC
     */
    public Optional<Instant> getCreationTime() {
        return Optional.ofNullable(created);
    }

    @Override
    public String toString() {
        return "Game[" + id + "]{" +
                "names=" + names +
                ", abbreviation='" + abbreviation + '\'' +
                ", releaseDate=" + releaseDate +
                ", created=" + created +
                "}";
    }
}
