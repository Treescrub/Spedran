package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Leaderboard;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get records for a given {@link Level}.
 */
public class LevelRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    @SuppressWarnings("unused")
    public LevelRecordsRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/records", Map.of("id", id));
    }

    public LevelRecordsRequest(Level level) {
        this(level.getId());
    }

    /**
     * Sets the number of places to return.
     * <p>
     * This will return more than {@code value} runs per leaderboard if there are ties.
     *
     * @param topPlaces the top places to filter for
     * @return this {@code LevelRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelRecordsRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    /**
     * Skips leaderboards with no runs.
     *
     * @return this {@code LevelRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    /**
     * Keeps leaderboards with no runs.
     *
     * @return this {@code LevelRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelRecordsRequest keepEmptyResults() {
        setParameter("skip-empty", false);
        return this;
    }

    /**
     * Embeds the game used to filter this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getGame()
     */
    public LevelRecordsRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds the game used to filter this leaderboard and any provided embeds for the game.
     *
     * @param builder the embed builder for the game
     * @return this object
     *
     * @see Leaderboard#getGame()
     */
    public LevelRecordsRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embeds the category used to filter this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getCategory()
     */
    public LevelRecordsRequest embedCategory() {
        addEmbed("category");
        return this;
    }

    /**
     * Embeds the category used to filter this leaderboard and any provided embeds for the category.
     *
     * @param builder the embed builder for the category
     * @return this object
     *
     * @see Leaderboard#getCategory()
     */
    public LevelRecordsRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    /**
     * Embeds the level used to filter this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getLevel()
     */
    public LevelRecordsRequest embedLevel() {
        addEmbed("level");
        return this;
    }

    /**
     * Embeds the level used to filter this leaderboard and any provided embeds for the level.
     *
     * @param builder the embed builder for the level
     * @return this object
     *
     * @see Leaderboard#getLevel()
     */
    public LevelRecordsRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    /**
     * Embeds the players that participated in this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getPlayers()
     */
    public LevelRecordsRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embeds the regions that were used in this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getRegions()
     */
    public LevelRecordsRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embeds the platforms that were used in this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getPlatforms()
     */
    public LevelRecordsRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embeds the applicable variables for the filtered levels/categories for this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getVariables()
     */
    public LevelRecordsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
