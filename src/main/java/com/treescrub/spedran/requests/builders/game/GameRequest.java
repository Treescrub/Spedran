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
    protected GameRequest(String id) {
        super(HttpMethod.GET, "games/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code GameRequest} builder.
     *
     * @param game the game to get
     * @return a {@code GameRequest} builder
     */
    public static GameRequest create(Game game) {
        checkResource(game, "game");

        return new GameRequest(game.getId());
    }

    /**
     * Creates and returns a new {@code GameRequest} builder.
     *
     * @param id the game to get
     * @return a {@code GameRequest} builder
     */
    public static GameRequest create(String id) {
        checkId(id);

        return new GameRequest(id);
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }

    /**
     * Embed this game's levels.
     *
     * @return this object
     *
     * @see Game#getLevels()
     */
    public GameRequest embedLevels() {
        addEmbed("levels");
        return this;
    }

    /**
     * Embeds this game's levels and any provided embeds for the levels.
     *
     * @param builder the embed builder for the levels
     * @return this object
     *
     * @see Game#getLevels()
     */
    public GameRequest embedLevels(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "levels");
        return this;
    }

    /**
     * Embed this game's categories.
     *
     * @return this object
     *
     * @see Game#getCategories()
     */
    public GameRequest embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embeds this game's categories and any provided embeds for the categories.
     *
     * @param builder the embed builder for the categories
     * @return this object
     *
     * @see Game#getCategories()
     */
    public GameRequest embedCategories(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "categories");
        return this;
    }

    /**
     * Embed this game's gametypes.
     *
     * @return this object
     *
     * @see Game#getGametypes()
     */
    public GameRequest embedGametypes() {
        addEmbed("gametypes");
        return this;
    }

    /**
     * Embed this game's platforms.
     *
     * @return this object
     *
     * @see Game#getPlatforms()
     */
    public GameRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embed this game's regions.
     *
     * @return this object
     *
     * @see Game#getRegions()
     */
    public GameRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embed this game's genres.
     *
     * @return this object
     *
     * @see Game#getGenres()
     */
    public GameRequest embedGenres() {
        addEmbed("genres");
        return this;
    }

    /**
     * Embed this game's engines.
     *
     * @return this object
     *
     * @see Game#getEngines()
     */
    public GameRequest embedEngines() {
        addEmbed("engines");
        return this;
    }

    /**
     * Embed this game's developers.
     *
     * @return this object
     *
     * @see Game#getDevelopers()
     */
    public GameRequest embedDevelopers() {
        addEmbed("developers");
        return this;
    }

    /**
     * Embed this game's publishers.
     *
     * @return this object
     *
     * @see Game#getPublishers()
     */
    public GameRequest embedPublishers() {
        addEmbed("publishers");
        return this;
    }

    /**
     * Embed this game's variables.
     *
     * @return this object
     *
     * @see Game#getVariables()
     */
    public GameRequest embedVariables() {
        addEmbed("variables");
        return this;
    }
}
