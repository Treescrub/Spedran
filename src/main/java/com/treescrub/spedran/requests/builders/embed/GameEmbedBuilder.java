package com.treescrub.spedran.requests.builders.embed;

public class GameEmbedBuilder extends EmbedBuilder {
    public GameEmbedBuilder embedLevels() {
        addEmbed("levels");
        return this;
    }

    public GameEmbedBuilder embedCategories() {
        addEmbed("categories");
        return this;
    }

    public GameEmbedBuilder embedGametypes() {
        addEmbed("gametypes");
        return this;
    }

    public GameEmbedBuilder embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    public GameEmbedBuilder embedRegions() {
        addEmbed("regions");
        return this;
    }

    public GameEmbedBuilder embedGenres() {
        addEmbed("genres");
        return this;
    }

    public GameEmbedBuilder embedEngines() {
        addEmbed("engines");
        return this;
    }

    public GameEmbedBuilder embedDevelopers() {
        addEmbed("developers");
        return this;
    }

    public GameEmbedBuilder embedPublishers() {
        addEmbed("publishers");
        return this;
    }

    public GameEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
