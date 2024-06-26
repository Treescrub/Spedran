package com.github.treescrub.spedran.requests.builders.genre;

import com.github.treescrub.spedran.data.Genre;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

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
    protected Class<Genre> getDataClass() {
        return Genre.class;
    }
}
