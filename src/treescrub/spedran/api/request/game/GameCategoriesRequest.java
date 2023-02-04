package treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.category.Category;

import java.util.Map;
import java.util.function.Function;

public class GameCategoriesRequest extends ResourceCollectionRequest<Category> {
    public GameCategoriesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/categories", Map.of("id", id));
    }

    public GameCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    public GameCategoriesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public GameCategoriesRequest sortByMiscellaneous() {
        setSortParameter("miscellaneous");
        return this;
    }

    public GameCategoriesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public GameCategoriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Category> getConstructor() {
        return Category::new;
    }
}
