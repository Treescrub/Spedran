package com.github.treescrub.spedran.requests.builders.category;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.category.Category;

import java.util.Map;

public class CategoryRequest extends SingleResourceRequest<Category> {
    public CategoryRequest(String id) {
        super(HttpMethod.GET, "categories/{id}", Map.of("id", id));
    }

    public CategoryRequest(Category category) {
        this(category.getId());
    }

    @Override
    protected Category parse(JSONObject data) {
        return new Category(data);
    }
}
