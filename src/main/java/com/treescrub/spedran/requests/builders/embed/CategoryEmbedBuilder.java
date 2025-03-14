package com.treescrub.spedran.requests.builders.embed;

public class CategoryEmbedBuilder extends EmbedBuilder {
    public CategoryEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    public CategoryEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
