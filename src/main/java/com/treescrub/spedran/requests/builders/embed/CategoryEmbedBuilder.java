package com.treescrub.spedran.requests.builders.embed;

import com.treescrub.spedran.data.Category;

/**
 * A builder to select which resources to embed for a category.
 */
public class CategoryEmbedBuilder extends EmbedBuilder {
    /**
     * Embed the category's game.
     *
     * @return this object
     * @see Category#getGame()
     */
    public CategoryEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embed the category's variables.
     *
     * @return this object
     * @see Category#getVariables()
     */
    public CategoryEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
