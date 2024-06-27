package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

public class LevelCategoriesRequest extends ResourceCollectionRequest<Category> {
    public LevelCategoriesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/categories", Map.of("id", id));
    }

    public LevelCategoriesRequest(Level level) {
        this(level.getId());
    }

    public LevelCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    public LevelCategoriesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public LevelCategoriesRequest sortByMiscellaneous() {
        setSortParameter("miscellaneous");
        return this;
    }

    public LevelCategoriesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public LevelCategoriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
