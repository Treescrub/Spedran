package com.treescrub.spedran.requests.builders.embed;

import com.treescrub.spedran.data.Run;

/**
 * A builder to select which resources to embed for a run.
 */
public class RunEmbedBuilder extends EmbedBuilder {
    /**
     * Embed this run's game.
     *
     * @return this object
     * @see Run#getGame()
     */
    public RunEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embed this run's category.
     *
     * @return this object
     * @see Run#getCategory()
     */
    public RunEmbedBuilder embedCategory() {
        addEmbed("category");
        return this;
    }

    /**
     * Embed this run's level.
     *
     * @return this object
     * @see Run#getLevel()
     */
    public RunEmbedBuilder embedLevel() {
        addEmbed("level");
        return this;
    }

    /**
     * Embed this run's players.
     *
     * @return this object
     * @see Run#getPlayers()
     */
    public RunEmbedBuilder embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embed this run's region.
     *
     * @return this object
     * @see Run#getRegion()
     */
    public RunEmbedBuilder embedRegion() {
        addEmbed("region");
        return this;
    }

    /**
     * Embed this run's platform.
     *
     * @return this object
     * @see Run#getPlatform()
     */
    public RunEmbedBuilder embedPlatform() {
        addEmbed("platform");
        return this;
    }
}
