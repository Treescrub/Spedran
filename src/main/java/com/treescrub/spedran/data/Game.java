package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.game.*;
import com.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 * A game which has a leaderboard on SRC.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Game extends IdentifiableResource {
    private final Names names;
    private final int boostReceived;
    private final int boostDistinctDonors;
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
    private final Map<String, ModeratorType> moderators;
    private final Instant created;
    private final GameAssets assets;

    Game(JSONObject data) {
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
        Map<String, ModeratorType> tempModerators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            ModeratorType type = ModeratorType.fromAPI(data.getJSONObject("moderators").getString(key));
            tempModerators.put(key, type);
        }
        moderators = Collections.unmodifiableMap(tempModerators);
        created = !data.isNull("created") ? Instant.parse(data.getString("created")) : null;
        assets = new GameAssets(data.getJSONObject("assets"));
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs for this game.
     *
     * @return a {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest getRuns() {
        return Spedran.getRuns().game(this);
    }

    /**
     * Gets a new {@link GameCategoriesRequest} builder object to request categories for this game.
     *
     * @return a {@code GameCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest getCategories() {
        return Spedran.getGameCategories(id);
    }

    /**
     * Gets a new {@link GameLevelsRequest} builder object to request levels for this game.
     *
     * @return a {@code GameLevelsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameLevelsRequest getLevels() {
        return Spedran.getGameLevels(id);
    }

    /**
     * Gets a new {@link GameRecordsRequest} builder object to request records for this game.
     *
     * @return a {@code GameRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRecordsRequest getRecords() {
        return Spedran.getGameRecords(id);
    }

    /**
     * Gets a new {@link GameRomhacksRequest} builder object to request romhacks (derived games) for this game.
     *
     * @return a {@code GameRomhacksRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest getRomhacks() {
        return Spedran.getGameRomhacks(id);
    }

    /**
     * Gets a new {@link GameVariablesRequest} builder object to request variables for this game.
     *
     * @return a {@code GameVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public GameVariablesRequest getVariables() {
        return Spedran.getGameVariables(id);
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
    public int getBoostsReceived() {
        return boostReceived;
    }

    /**
     * Gets the number of unique supporters currently boosting this game.
     *
     * @return total unique users that have boosted this game
     *
     * @see <a href="https://www.speedrun.com/supporter/faq">SRC Supporter FAQ</a>
     */
    public int getDistinctBoosters() {
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
     * @return an unmodifiable {@code List} of gametype IDs
     *
     * @see Gametype
     * @see Spedran#getGametype(String)
     */
    public List<String> getGametypes() {
        return gametypes;
    }

    /**
     * Gets a {@code List} of platform IDs that this game is on.
     *
     * @return an unmodifiable {@code List} of platform IDs
     *
     * @see Platform
     * @see Spedran#getPlatform(String)
     */
    public List<String> getPlatforms() {
        return platforms;
    }

    /**
     * Gets a {@code List} of region IDs that this game is in.
     *
     * @return an unmodifiable {@code List} of region IDs
     *
     * @see Region
     * @see Spedran#getRegion(String)
     */
    public List<String> getRegions() {
        return regions;
    }

    /**
     * Gets a {@code List} of genre IDs that this game is in.
     *
     * @return an unmodifiable {@code List} of genre IDs
     *
     * @see Genre
     * @see Spedran#getGenre(String)
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Gets a {@code List} of engine IDs that this game runs in.
     *
     * @return an unmodifiable {@code List} of engine IDs
     *
     * @see Engine
     * @see Spedran#getEngine(String)
     */
    public List<String> getEngines() {
        return engines;
    }

    /**
     * Gets a {@code List} of developer IDs that developed this game.
     *
     * @return an unmodifiable {@code List} of developer IDs
     *
     * @see Developer
     * @see Spedran#getDeveloper(String)
     */
    public List<String> getDevelopers() {
        return developers;
    }

    /**
     * Gets a {@code List} of publisher IDs that published this game.
     *
     * @return an unmodifiable {@code List} of publisher IDs
     *
     * @see Publisher
     * @see Spedran#getPublisher(String)
     */
    public List<String> getPublishers() {
        return publishers;
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
     * Returns an {@link Instant} with the time this game was added to SRC.
     * <p>
     * Games added before this field was implemented will return an empty Optional.
     *
     * @return an {@link Optional} with an {@code Instant} describing when this game was added to SRC
     */
    public Optional<Instant> getCreationTime() {
        return Optional.ofNullable(created);
    }

    /**
     * Gets the {@link GameAssets} for this game.
     *
     * @return a {@code GameAssets} object
     */
    @SuppressWarnings("unused")
    public GameAssets getAssets() {
        return assets;
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
