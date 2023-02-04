package treescrub.spedran.api.request.publisher;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Publisher;

import java.util.Map;

public class PublisherRequest extends SingleResourceRequest<Publisher> {
    public PublisherRequest(String id) {
        super(HttpMethod.GET, "publishers/{id}", Map.of("id", id));
    }

    public PublisherRequest(Publisher publisher) {
        this(publisher.getId());
    }

    @Override
    protected Publisher parse(JSONObject data) {
        return new Publisher(data);
    }
}
