package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Leaderboard;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the top runs of a {@link Category}.
 */
public class CategoryRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    @SuppressWarnings("unused")
    public CategoryRecordsRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/records", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public CategoryRecordsRequest(Category category) {
        this(category.getId());
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

    public CategoryRecordsRequest embedGame() {
        addEmbed("game");
        return this;
    }

    public CategoryRecordsRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    public CategoryRecordsRequest embedCategory() {
        addEmbed("category");
        return this;
    }

    public CategoryRecordsRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    public CategoryRecordsRequest embedLevel() {
        addEmbed("level");
        return this;
    }

    public CategoryRecordsRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    public CategoryRecordsRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    public CategoryRecordsRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    public CategoryRecordsRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    public CategoryRecordsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
