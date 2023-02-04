package treescrub.spedran.api.request.genre;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Genre;

import java.util.function.Function;

public class GenresRequest extends ResourceCollectionRequest<Genre> {
    public GenresRequest() {
        super(HttpMethod.GET, "genres");
    }

    public GenresRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public GenresRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Genre> getConstructor() {
        return Genre::new;
    }
}
