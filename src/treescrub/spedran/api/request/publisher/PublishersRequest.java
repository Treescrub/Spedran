package treescrub.spedran.api.request.publisher;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Publisher;

import java.util.function.Function;

public class PublishersRequest extends ResourceCollectionRequest<Publisher> {
    public PublishersRequest() {
        super(HttpMethod.GET, "publishers");
    }

    public PublishersRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public PublishersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Publisher> getConstructor() {
        return Publisher::new;
    }
}
