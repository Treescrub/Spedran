package com.github.treescrub.spedran.requests.builders.series;

import com.github.treescrub.spedran.data.Series;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class SingleSeriesRequest extends SingleResourceRequest<Series> {
    public SingleSeriesRequest(String id) {
        super(HttpMethod.GET, "series/{id}", Map.of("id", id));
    }

    public SingleSeriesRequest(Series series) {
        this(series.getId());
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
