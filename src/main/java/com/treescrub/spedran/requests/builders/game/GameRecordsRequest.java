package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.Leaderboard;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get records for a given {@link Game}.
 */
public class GameRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    @SuppressWarnings("unused")
    protected GameRecordsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/records", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code GameRecordsRequest} builder.
     *
     * @param game the game to get the records for
     * @return a {@code GameRecordsRequest} builder
     */
    public static GameRecordsRequest create(Game game) {
        checkResource(game, "game");

        return new GameRecordsRequest(game.getId());
    }

    /**
     * Creates and returns a new {@code GameRecordsRequest} builder.
     *
     * @param id the game to get the records for
     * @return a {@code GameRecordsRequest} builder
     */
    public static GameRecordsRequest create(String id) {
        checkId(id);

        return new GameRecordsRequest(id);
    }

    /**
     * Sets the number of places to return.
     * <p>
     * This will return more than {@code value} runs per leaderboard if there are ties.
     *
     * @param topPlaces the top places to filter for, clamped to {@code >= 1}
     * @return this {@code GameRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRecordsRequest top(int topPlaces) {
        topPlaces = Math.max(topPlaces, 1);
        setParameter("top", topPlaces);
        return this;
    }

    /**
     * Sets the scope type.
     * <p>
     * Valid values are: {@code "full-game"}, {@code "levels"}, and {@code "all"}.
     * <p>
     * Full-game scope returns only full-game categories.
     * Levels scope returns only individual levels.
     * All returns everything and is the default scope.
     *
     * @param recordsScope the scope to get records in
     * @return this {@code GameRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRecordsRequest scope(String recordsScope) {
        setParameter("scope", recordsScope);
        return this;
    }

    /**
     * Sets whether miscellaneous categories should be returned.
     * <p>
     * Defaults to {@code true}.
     *
     * @param includeMiscellaneous whether to include miscellaneous categories in the results
     * @return this {@code GameRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRecordsRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Sets whether record entries without any runs should be kept.
     *
     * @param skipEmptyRecords {@code true} to skip empty records; {@code false} otherwise
     * @return this {@code GameRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public GameRecordsRequest skipEmpty(boolean skipEmptyRecords) {
        setParameter("skip-empty", skipEmptyRecords);
        return this;
    }

    /**
     * Embeds the game used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getGame()
     */
    public GameRecordsRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds the game used to filter this leaderboard and any provided embeds for the game.
     *
     * @param builder the embed builder for the game
     * @return this object
     * @see Leaderboard#getGame()
     */
    public GameRecordsRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embeds the category used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getCategory()
     */
    public GameRecordsRequest embedCategory() {
        addEmbed("category");
        return this;
    }

    /**
     * Embeds the category used to filter this leaderboard and any provided embeds for the category.
     *
     * @param builder the embed builder for the category
     * @return this object
     * @see Leaderboard#getCategory()
     */
    public GameRecordsRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    /**
     * Embeds the level used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getLevel()
     */
    public GameRecordsRequest embedLevel() {
        addEmbed("level");
        return this;
    }

    /**
     * Embeds the level used to filter this leaderboard and any provided embeds for the level.
     *
     * @param builder the embed builder for the level
     * @return this object
     * @see Leaderboard#getLevel()
     */
    public GameRecordsRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    /**
     * Embeds the players that participated in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getPlayers()
     */
    public GameRecordsRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embeds the regions that were used in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getRegions()
     */
    public GameRecordsRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embeds the platforms that were used in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getPlatforms()
     */
    public GameRecordsRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embeds the applicable variables for the filtered levels/categories for this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getVariables()
     */
    public GameRecordsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
