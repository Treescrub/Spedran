package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Leaderboard;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.User;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import com.treescrub.spedran.requests.builders.user.UserRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the top runs of a {@link Category}.
 */
public class CategoryRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    @SuppressWarnings("unused")
    protected CategoryRecordsRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/records", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code CategoryRecordsRequest} builder.
     *
     * @param category the category to get the records for
     * @return a {@code CategoryRecordsRequest} builder
     */
    public static CategoryRecordsRequest create(Category category) {
        checkResource(category, "category");

        return new CategoryRecordsRequest(category.getId());
    }

    /**
     * Creates and returns a new {@code CategoryRecordsRequest} builder.
     *
     * @param id the category to get the records for
     * @return a {@code CategoryRecordsRequest} builder
     */
    public static CategoryRecordsRequest create(String id) {
        checkId(id);

        return new CategoryRecordsRequest(id);
    }

    /**
     * Sets number of places to return.
     * <p>
     * This will return more than {@code value} runs per leaderboard if there are ties.
     *
     * @param value the top places to filter for, clamped to {@code >= 1}
     * @return this object
     */
    @SuppressWarnings("unused")
    public CategoryRecordsRequest topPlaces(int value) {
        value = Math.max(value, 1);
        setParameter("top", value);
        return this;
    }

    /**
     * Skips leaderboards if they do not contain any runs.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public CategoryRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    /**
     * Keeps all leaderboards in the results, regardless of whether they have any runs.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public CategoryRecordsRequest keepEmptyResults() {
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
    public CategoryRecordsRequest embedGame() {
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
    public CategoryRecordsRequest embedGame(GameEmbedBuilder builder) {
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
    public CategoryRecordsRequest embedCategory() {
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
    public CategoryRecordsRequest embedCategory(CategoryEmbedBuilder builder) {
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
    public CategoryRecordsRequest embedLevel() {
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
    public CategoryRecordsRequest embedLevel(LevelEmbedBuilder builder) {
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
    public CategoryRecordsRequest embedPlayers() {
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
    public CategoryRecordsRequest embedRegions() {
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
    public CategoryRecordsRequest embedPlatforms() {
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
    public CategoryRecordsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
