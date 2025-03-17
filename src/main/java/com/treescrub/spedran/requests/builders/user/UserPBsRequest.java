package com.treescrub.spedran.requests.builders.user;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.*;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the personal best {@link Run}s of a {@link User}.
 */
public class UserPBsRequest extends ResourceCollectionRequest<LeaderboardRun> {
    @SuppressWarnings("unused")
    protected UserPBsRequest(String id) {
        super(HttpMethod.GET, "users/{id}/personal-bests", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code UserPBsRequest} builder.
     *
     * @param user the user to get the personal bests for
     * @return a {@code UserPBsRequest} builder
     */
    public static UserPBsRequest create(User user) {
        checkResource(user, "user");

        return new UserPBsRequest(user.getId());
    }

    /**
     * Creates and returns a new {@code UserPBsRequest} builder.
     *
     * @param id the user to get the personal bests for
     * @return a {@code UserPBsRequest} builder
     */
    public static UserPBsRequest create(String id) {
        checkId(id);

        return new UserPBsRequest(id);
    }

    /**
     * Sets the minimum placement to restrict the results to.
     *
     * @param topPlace the top place to filter PBs by
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest top(int topPlace) {
        setParameter("top", topPlace);
        return this;
    }

    /**
     * Restricts the results to the given {@link Series}.
     *
     * @param id the series ID
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest series(String id) {
        setParameter("series", id);
        return this;
    }

    /**
     * Restricts the results to the given {@link Game}.
     *
     * @param id the game ID
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    /**
     * Embeds the game used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getGame()
     */
    public UserPBsRequest embedGame() {
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
    public UserPBsRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embeds the category used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getCategory()
     */
    public UserPBsRequest embedCategory() {
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
    public UserPBsRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    /**
     * Embeds the level used to filter this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getLevel()
     */
    public UserPBsRequest embedLevel() {
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
    public UserPBsRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    /**
     * Embeds the players that participated in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getPlayers()
     */
    public UserPBsRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embeds the regions that were used in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getRegions()
     */
    public UserPBsRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embeds the platforms that were used in this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getPlatforms()
     */
    public UserPBsRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embeds the applicable variables for the filtered levels/categories for this leaderboard.
     *
     * @return this object
     * @see Leaderboard#getVariables()
     */
    public UserPBsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<LeaderboardRun> getDataClass() {
        return LeaderboardRun.class;
    }
}
