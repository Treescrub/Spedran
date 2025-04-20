package com.treescrub.spedran.requests.builders.embed;

import com.treescrub.spedran.data.Level;

/**
 * A builder to select which resources to embed for a level.
 */
public class LevelEmbedBuilder extends EmbedBuilder {
    /**
     * Embed this level's categories.
     *
     * @return this object
     * @see Level#getCategories()
     */
    public LevelEmbedBuilder embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embed this level's variables.
     *
     * @return this object
     * @see Level#getVariables()
     */
    public LevelEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
