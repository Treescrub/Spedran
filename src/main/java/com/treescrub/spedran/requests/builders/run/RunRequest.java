package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Run}.
 */
public class RunRequest extends SingleResourceRequest<Run> {
    @SuppressWarnings("unused")
    public RunRequest(String id) {
        super(HttpMethod.GET, "runs/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public RunRequest(Run run) {
        this(run.getId());
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    public RunRequest embedGame() {
        addEmbed("game");
        return this;
    }

    public RunRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    public RunRequest embedCategory() {
        addEmbed("category");
        return this;
    }

    public RunRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    public RunRequest embedLevel() {
        addEmbed("level");
        return this;
    }

    public RunRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    public RunRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    public RunRequest embedRegion() {
        addEmbed("region");
        return this;
    }

    public RunRequest embedPlatform() {
        addEmbed("platform");
        return this;
    }
}
