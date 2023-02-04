package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.category.Category;

import java.util.Map;
import java.util.function.Function;

public class LevelCategoriesRequest extends ResourceCollectionRequest<Category> {
    public LevelCategoriesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/categories", Map.of("id", id));
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
    protected Function<JSONObject, Category> getConstructor() {
        return Category::new;
    }
}
