package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Game}.
 */
public class GameRequest extends SingleResourceRequest<Game> {
    @SuppressWarnings("unused")
    public GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GameRequest(Game game) {
        this(game.getId());
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }

    public GameRequest embedLevels() {
        addEmbed("levels");
        return this;
    }

    public GameRequest embedLevels(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "levels");
        return this;
    }

    public GameRequest embedCategories() {
        addEmbed("categories");
        return this;
    }

    public GameRequest embedCategories(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "categories");
        return this;
    }

    public GameRequest embedGametypes() {
        addEmbed("gametypes");
        return this;
    }

    public GameRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    public GameRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    public GameRequest embedGenres() {
        addEmbed("genres");
        return this;
    }

    public GameRequest embedEngines() {
        addEmbed("engines");
        return this;
    }

    public GameRequest embedDevelopers() {
        addEmbed("developers");
        return this;
    }

    public GameRequest embedPublishers() {
        addEmbed("publishers");
        return this;
    }

    public GameRequest embedVariables() {
        addEmbed("variables");
        return this;
    }
}
