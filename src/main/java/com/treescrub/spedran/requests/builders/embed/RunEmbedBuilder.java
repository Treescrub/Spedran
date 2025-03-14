package com.treescrub.spedran.requests.builders.embed;

public class RunEmbedBuilder extends EmbedBuilder {
    public RunEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    public RunEmbedBuilder embedCategory() {
        addEmbed("category");
        return this;
    }

    public RunEmbedBuilder embedLevel() {
        addEmbed("level");
        return this;
    }

    public RunEmbedBuilder embedPlayers() {
        addEmbed("players");
        return this;
    }

    public RunEmbedBuilder embedRegion() {
        addEmbed("region");
        return this;
    }

    public RunEmbedBuilder embedPlatform() {
        addEmbed("platform");
        return this;
    }
}
