package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Publisher;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class PublisherRequest extends SingleResourceRequest<Publisher> {
    public PublisherRequest(String id) {
        super(HttpMethod.GET, "publishers/{id}", Map.of("id", id));
    }

    public PublisherRequest(Publisher publisher) {
        this(publisher.getId());
    }

    @Override
    protected Class<Publisher> getDataClass() {
        return Publisher.class;
    }
}
