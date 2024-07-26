package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Genre;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Genre}.
 */
public class GenreRequest extends SingleResourceRequest<Genre> {
    @SuppressWarnings("unused")
    public GenreRequest(String id) {
        super(HttpMethod.GET, "genres/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GenreRequest(Genre genre) {
        this(genre.getId());
    }

    @Override
    protected Class<Genre> getDataClass() {
        return Genre.class;
    }
}
