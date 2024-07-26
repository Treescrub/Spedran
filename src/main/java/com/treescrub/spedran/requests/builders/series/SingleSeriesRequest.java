package com.treescrub.spedran.requests.builders.series;

import com.treescrub.spedran.data.Series;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Series}.
 */
public class SingleSeriesRequest extends SingleResourceRequest<Series> {
    @SuppressWarnings("unused")
    public SingleSeriesRequest(String id) {
        super(HttpMethod.GET, "series/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public SingleSeriesRequest(Series series) {
        this(series.getId());
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
