package com.treescrub.spedran.requests.builders.embed;

public class LevelEmbedBuilder extends EmbedBuilder {
    public LevelEmbedBuilder embedCategories() {
        addEmbed("categories");
        return this;
    }

    public LevelEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
