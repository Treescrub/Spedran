package com.treescrub.spedran.requests.builders.embed;

import com.treescrub.spedran.data.Game;

/**
 * A builder to select which resources to embed for a game.
 */
public class GameEmbedBuilder extends EmbedBuilder {
    /**
     * Embed the game's levels.
     *
     * @return this object
     * @see Game#getLevels()
     */
    public GameEmbedBuilder embedLevels() {
        addEmbed("levels");
        return this;
    }

    /**
     * Embed the game's categories.
     *
     * @return this object
     * @see Game#getCategories()
     */
    public GameEmbedBuilder embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embed the game's gametypes.
     *
     * @return this object
     * @see Game#getGametypes()
     */
    public GameEmbedBuilder embedGametypes() {
        addEmbed("gametypes");
        return this;
    }

    /**
     * Embed the game's platforms.
     *
     * @return this object
     * @see Game#getPlatforms()
     */
    public GameEmbedBuilder embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embed the game's regions.
     *
     * @return this object
     * @see Game#getRegions()
     */
    public GameEmbedBuilder embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embed the game's genres.
     *
     * @return this object
     * @see Game#getGenres()
     */
    public GameEmbedBuilder embedGenres() {
        addEmbed("genres");
        return this;
    }

    /**
     * Embed the game's engines.
     *
     * @return this object
     * @see Game#getEngines()
     */
    public GameEmbedBuilder embedEngines() {
        addEmbed("engines");
        return this;
    }

    /**
     * Embed the game's developers.
     *
     * @return this object
     * @see Game#getDevelopers()
     */
    public GameEmbedBuilder embedDevelopers() {
        addEmbed("developers");
        return this;
    }

    /**
     * Embed the game's publishers.
     *
     * @return this object
     * @see Game#getPublishers()
     */
    public GameEmbedBuilder embedPublishers() {
        addEmbed("publishers");
        return this;
    }

    /**
     * Embed the game's variables.
     *
     * @return this object
     * @see Game#getVariables()
     */
    public GameEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
