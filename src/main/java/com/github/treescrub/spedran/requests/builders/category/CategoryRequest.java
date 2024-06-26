package com.github.treescrub.spedran.requests.builders.category;

import com.github.treescrub.spedran.data.category.Category;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class CategoryRequest extends SingleResourceRequest<Category> {
    public CategoryRequest(String id) {
        super(HttpMethod.GET, "categories/{id}", Map.of("id", id));
    }

    public CategoryRequest(Category category) {
        this(category.getId());
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
