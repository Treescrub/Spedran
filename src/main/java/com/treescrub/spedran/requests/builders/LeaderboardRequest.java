package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.*;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a specific {@link Leaderboard}.
 */
public class LeaderboardRequest extends SingleResourceRequest<Leaderboard> {
    @SuppressWarnings("unused")
    public LeaderboardRequest(String game, String category) {
        super(HttpMethod.GET, "leaderboards/{game}/category/{category}", Map.of("game", game, "category", category));
    }

    @SuppressWarnings("unused")
    public LeaderboardRequest(String game, String category, String level) {
        super(HttpMethod.GET, "leaderboards/{game}/level/{level}/{category}", Map.of("game", game, "category", category, "level", level));
    }

    public LeaderboardRequest(Game game, Category category) {
        this(game.getId(), category.getId());
    }

    public LeaderboardRequest(Game game, Category category, Level level) {
        this(game.getId(), category.getId(), level.getId());
    }

    @SuppressWarnings("unused")
    public LeaderboardRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    /**
     * Restricts the results to runs done on the given {@link Platform}.
     *
     * @param id the platform ID
     * @return this {@code LeaderboardRequest} builder
     */
    public LeaderboardRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    /**
     * Restricts the results to runs done on the given {@link Platform}.
     *
     * @param platform the platform
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Restricts the results to runs done on the given {@link Region}.
     *
     * @param id the region ID
     * @return this {@code LeaderboardRequest} builder
     */
    public LeaderboardRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    /**
     * Restricts the results to runs done on the given {@link Region}.
     *
     * @param region the region
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Restricts the results to runs done on an emulator.
     *
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest onlyEmulators() {
        setParameter("emulators", true);
        return this;
    }

    /**
     * Restricts the results to runs done on hardware (that is, not an emulator).
     *
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest onlyRealDevices() {
        setParameter("emulators", false);
        return this;
    }

    /**
     * Restricts the results to runs with videos specified.
     *
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest videosOnly() {
        setParameter("video-only", true);
        return this;
    }

    /**
     * Sorts the leaderboard by the timing type.
     *
     * @param timingType the type to sort by
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest timing(TimingType timingType) {
        setParameter("timing", timingType.name().toLowerCase());
        return this;
    }

    /**
     * Restricts the results to runs done before or on this date.
     *
     * @param date the date in ISO 8601 format
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest beforeDate(String date) {
        setParameter("date", date);
        return this;
    }

    /**
     * Restricts the results to runs with the given {@link Variable} set to the given variable value.
     *
     * @param id the variable ID
     * @param value the variable value ID
     * @return this {@code LeaderboardRequest} builder
     */
    public LeaderboardRequest variable(String id, String value) {
        setParameter("var-" + id, value);
        return this;
    }

    /**
     * Restricts the results to runs with the given {@link Variable} set to the given variable value.
     *
     * @param variable the variable
     * @param valueId the variable value ID
     * @return this {@code LeaderboardRequest} builder
     */
    @SuppressWarnings("unused")
    public LeaderboardRequest variable(Variable variable, String valueId) {
        return variable(variable.getId(), valueId);
    }

    /**
     * Embeds the game used to filter this leaderboard.
     *
     * @return this object
     *
     * @see Leaderboard#getGame()
     */
    public LeaderboardRequest embedGame() {
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
    public LeaderboardRequest embedGame(GameEmbedBuilder builder) {
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
    public LeaderboardRequest embedCategory() {
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
    public LeaderboardRequest embedCategory(CategoryEmbedBuilder builder) {
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
    public LeaderboardRequest embedLevel() {
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
    public LeaderboardRequest embedLevel(LevelEmbedBuilder builder) {
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
    public LeaderboardRequest embedPlayers() {
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
    public LeaderboardRequest embedRegions() {
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
    public LeaderboardRequest embedPlatforms() {
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
    public LeaderboardRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
