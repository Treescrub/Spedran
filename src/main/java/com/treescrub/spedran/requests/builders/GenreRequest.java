package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Gametype;
import com.treescrub.spedran.data.Genre;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Genre}.
 */
public class GenreRequest extends SingleResourceRequest<Genre> {
    @SuppressWarnings("unused")
    protected GenreRequest(String id) {
        super(HttpMethod.GET, "genres/{id}", Map.of("id", id));
    }

    public static GenreRequest create(Genre genre) {
        checkResource(genre, "genre");

        return new GenreRequest(genre.getId());
    }

    public static GenreRequest create(String id) {
        checkId(id);

        return new GenreRequest(id);
    }

    @Override
    protected Class<Genre> getDataClass() {
        return Genre.class;
    }
}
