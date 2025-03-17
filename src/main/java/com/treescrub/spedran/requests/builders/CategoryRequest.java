package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Category}.
 */
public class CategoryRequest extends SingleResourceRequest<Category> {
    @SuppressWarnings("unused")
    protected CategoryRequest(String id) {
        super(HttpMethod.GET, "categories/{id}", Map.of("id", id));
    }

    public static CategoryRequest create(Category category) {
        checkResource(category, "category");

        return new CategoryRequest(category.getId());
    }

    public static CategoryRequest create(String id) {
        checkId(id);

        return new CategoryRequest(id);
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }

    /**
     * Embed this category's game.
     *
     * @return this object
     *
     * @see Category#getGame()
     */
    public CategoryRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds this category's game and any provided embeds for the game.
     *
     * @param builder the embed builder for the game
     * @return this object
     *
     * @see Category#getGame()
     */
    public CategoryRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embed this category's variables.
     *
     * @return this object
     *
     * @see Category#getVariables()
     */
    public CategoryRequest embedVariables() {
        addEmbed("variables");
        return this;
    }
}
