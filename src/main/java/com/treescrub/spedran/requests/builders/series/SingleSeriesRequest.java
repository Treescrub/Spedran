package com.treescrub.spedran.requests.builders.series;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Series;
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

    /**
     * Creates and returns a new {@code SingleSeriesRequest} builder.
     *
     * @param series the series to get
     * @return a {@code SingleSeriesRequest} builder
     */
    public static SingleSeriesRequest create(Series series) {
        checkResource(series, "series");

        return new SingleSeriesRequest(series.getId());
    }

    /**
     * Creates and returns a new {@code SingleSeriesRequest} builder.
     *
     * @param id the series to get
     * @return a {@code SingleSeriesRequest} builder
     */
    public static SingleSeriesRequest create(String id) {
        checkId(id);

        return new SingleSeriesRequest(id);
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
