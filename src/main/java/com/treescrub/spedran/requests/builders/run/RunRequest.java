package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Run;
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
    protected RunRequest(String id) {
        super(HttpMethod.GET, "runs/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code RunRequest} builder.
     *
     * @param run the run to get
     * @return a {@code RunRequest} builder
     */
    public static RunRequest create(Run run) {
        checkResource(run, "run");

        return new RunRequest(run.getId());
    }

    /**
     * Creates and returns a new {@code RunRequest} builder.
     *
     * @param id the run to get
     * @return a {@code RunRequest} builder
     */
    public static RunRequest create(String id) {
        checkId(id);

        return new RunRequest(id);
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    /**
     * Embed this run's game.
     *
     * @return this object
     * @see Run#getGame()
     */
    public RunRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds this run's game and any provided embeds for the game.
     *
     * @param builder the embed builder for the game
     * @return this object
     * @see Run#getGame()
     */
    public RunRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embed this run's category.
     *
     * @return this object
     * @see Run#getCategory()
     */
    public RunRequest embedCategory() {
        addEmbed("category");
        return this;
    }

    /**
     * Embeds this run's category and any provided embeds for the category.
     *
     * @param builder the embed builder for the category
     * @return this object
     * @see Run#getCategory()
     */
    public RunRequest embedCategory(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "category");
        return this;
    }

    /**
     * Embed this run's level.
     *
     * @return this object
     * @see Run#getLevel()
     */
    public RunRequest embedLevel() {
        addEmbed("level");
        return this;
    }

    /**
     * Embeds this run's level and any provided embeds for the level.
     *
     * @param builder the embed builder for the level
     * @return this object
     * @see Run#getLevel()
     */
    public RunRequest embedLevel(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "level");
        return this;
    }

    /**
     * Embed this run's players.
     *
     * @return this object
     * @see Run#getPlayers()
     */
    public RunRequest embedPlayers() {
        addEmbed("players");
        return this;
    }

    /**
     * Embed this run's region.
     *
     * @return this object
     * @see Run#getRegion()
     */
    public RunRequest embedRegion() {
        addEmbed("region");
        return this;
    }

    /**
     * Embed this run's platform.
     *
     * @return this object
     * @see Run#getPlatform()
     */
    public RunRequest embedPlatform() {
        addEmbed("platform");
        return this;
    }
}
