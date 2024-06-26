package com.github.treescrub.spedran.requests.genre;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Genre;

import java.util.Map;

public class GenreRequest extends SingleResourceRequest<Genre> {
    public GenreRequest(String id) {
        super(HttpMethod.GET, "genres/{id}", Map.of("id", id));
    }

    public GenreRequest(Genre genre) {
        this(genre.getId());
    }

    @Override
    protected Genre parse(JSONObject data) {
        return new Genre(data);
    }
}
