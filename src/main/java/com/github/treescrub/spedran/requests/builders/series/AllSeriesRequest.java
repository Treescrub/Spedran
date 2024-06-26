package com.github.treescrub.spedran.requests.builders.series;

import com.github.treescrub.spedran.data.Series;
import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

public class AllSeriesRequest extends ResourceCollectionRequest<Series> {
    public AllSeriesRequest() {
        super(HttpMethod.GET, "series");
    }

    public AllSeriesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    public AllSeriesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    public AllSeriesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public AllSeriesRequest moderator(User user) {
        return moderator(user.getId());
    }

    public AllSeriesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    public AllSeriesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    public AllSeriesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    public AllSeriesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    public AllSeriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
