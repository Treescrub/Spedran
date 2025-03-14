package com.treescrub.spedran.requests.builders.embed;

public class LeaderboardEmbedBuilder extends EmbedBuilder {
    public LeaderboardEmbedBuilder embedGame() {
        addEmbed("game");
        return this;
    }

    public LeaderboardEmbedBuilder embedCategory() {
        addEmbed("category");
        return this;
    }

    public LeaderboardEmbedBuilder embedLevel() {
        addEmbed("level");
        return this;
    }

    public LeaderboardEmbedBuilder embedPlayers() {
        addEmbed("players");
        return this;
    }

    public LeaderboardEmbedBuilder embedRegions() {
        addEmbed("regions");
        return this;
    }

    public LeaderboardEmbedBuilder embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    public LeaderboardEmbedBuilder embedVariables() {
        addEmbed("variables");
        return this;
    }
}
