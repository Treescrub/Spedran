package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Publisher;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Publisher}.
 */
public class PublisherRequest extends SingleResourceRequest<Publisher> {
    @SuppressWarnings("unused")
    public PublisherRequest(String id) {
        super(HttpMethod.GET, "publishers/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public PublisherRequest(Publisher publisher) {
        this(publisher.getId());
    }

    @Override
    protected Class<Publisher> getDataClass() {
        return Publisher.class;
    }
}
