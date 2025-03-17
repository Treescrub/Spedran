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
    protected SingleSeriesRequest(String id) {
        super(HttpMethod.GET, "series/{id}", Map.of("id", id));
    }

    public static SingleSeriesRequest create(Series series) {
        checkResource(series, "series");

        return new SingleSeriesRequest(series.getId());
    }

    public static SingleSeriesRequest create(String id) {
        checkId(id);

        return new SingleSeriesRequest(id);
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
