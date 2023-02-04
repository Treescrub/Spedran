package treescrub.spedran.api.request.category;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.category.Category;

import java.util.Map;

public class CategoryRequest extends SingleResourceRequest<Category> {
    protected CategoryRequest(String id) {
        super(HttpMethod.GET, "categories/{id}", Map.of("id", id));
    }

    @Override
    protected Category parse(JSONObject data) {
        return new Category(data);
    }
}
