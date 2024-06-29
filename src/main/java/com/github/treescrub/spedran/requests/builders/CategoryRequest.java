package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Category}.
 */
public class CategoryRequest extends SingleResourceRequest<Category> {
    @SuppressWarnings("unused")
    public CategoryRequest(String id) {
        super(HttpMethod.GET, "categories/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public CategoryRequest(Category category) {
        this(category.getId());
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
