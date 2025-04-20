package com.treescrub.spedran.requests.builders.embed;

import com.treescrub.spedran.data.Leaderboard;

/**
 * A builder to select which resources to embed for a leaderboard.
 */
public class LeaderboardEmbedBuilder extends EmbedBuilder {
    /**
     * Embed the leaderboard's game.
     *
     * @return this object
     * @see Leaderboard#getGame()
     */
    public LeaderboardEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embed the leaderboard's category.
     *
     * @return this object
     * @see Leaderboard#getCategory()
     */
    public LeaderboardEmbedBuilder embedCategory() {
        addEmbed("category");
        return this;
    }

    /**
     * Embed the leaderboard's level.
     *
     * @return this object
     * @see Leaderboard#getLevel()
     */
    public LeaderboardEmbedBuilder embedLevel() {
        addEmbed("level");
        return this;
    }

    /**
     * Embed the leaderboard's players.
     *
     * @return this object
     * @see Leaderboard#getPlayers()
     */
    public LeaderboardEmbedBuilder embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embed the leaderboard's regions.
     *
     * @return this object
     * @see Leaderboard#getRegions()
     */
    public LeaderboardEmbedBuilder embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embed the leaderboard's platforms.
     *
     * @return this object
     * @see Leaderboard#getPlatforms()
     */
    public LeaderboardEmbedBuilder embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embed the leaderboard's variables.
     *
     * @return this object
     * @see Leaderboard#getVariables()
     */
    public LeaderboardEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
