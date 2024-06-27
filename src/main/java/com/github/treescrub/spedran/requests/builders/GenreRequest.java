package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Genre;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class GenreRequest extends SingleResourceRequest<Genre> {
    public GenreRequest(String id) {
        super(HttpMethod.GET, "genres/{id}", Map.of("id", id));
    }

    public GenreRequest(Genre genre) {
        this(genre.getId());
    }

    @Override
    protected Class<Genre> getDataClass() {
        return Genre.class;
    }
}
