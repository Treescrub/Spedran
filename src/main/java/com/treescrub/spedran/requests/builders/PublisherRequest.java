package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Publisher;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Publisher}.
 */
public class PublisherRequest extends SingleResourceRequest<Publisher> {
    @SuppressWarnings("unused")
    protected PublisherRequest(String id) {
        super(HttpMethod.GET, "publishers/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code PublisherRequest} builder.
     *
     * @param publisher the publisher to get
     * @return a {@code PublisherRequest} builder
     */
    public static PublisherRequest create(Publisher publisher) {
        checkResource(publisher, "publisher");

        return new PublisherRequest(publisher.getId());
    }

    /**
     * Creates and returns a new {@code PublisherRequest} builder.
     *
     * @param id the publisher to get
     * @return a {@code PublisherRequest} builder
     */
    public static PublisherRequest create(String id) {
        checkId(id);

        return new PublisherRequest(id);
    }

    @Override
    protected Class<Publisher> getDataClass() {
        return Publisher.class;
    }
}
