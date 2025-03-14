package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Level}.
 */
public class LevelRequest extends SingleResourceRequest<Level> {
    @SuppressWarnings("unused")
    public LevelRequest(String id) {
        super(HttpMethod.GET, "levels/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public LevelRequest(Level level) {
        this(level.getId());
    }

    @Override
    protected Class<Level> getDataClass() {
        return Level.class;
    }

    /**
     * Embed this level's categories.
     *
     * @return this object
     *
     * @see Level#getCategories()
     */
    public LevelRequest embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embeds this level's categories and any provided embeds for the categories.
     *
     * @param builder the embed builder for the categories
     * @return this object
     *
     * @see Level#getCategories()
     */
    public LevelRequest embedCategories(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "categories");
        return this;
    }

    /**
     * Embed this level's applicable variables.
     *
     * @return this object
     *
     * @see Level#getVariables()
     */
    public LevelRequest embedVariables() {
        addEmbed("variables");
        return this;
    }
}
