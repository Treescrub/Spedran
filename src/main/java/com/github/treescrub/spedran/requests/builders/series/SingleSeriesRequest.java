package com.github.treescrub.spedran.requests.builders.series;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Series;

import java.util.Map;

public class SingleSeriesRequest extends SingleResourceRequest<Series> {
    public SingleSeriesRequest(String id) {
        super(HttpMethod.GET, "series/{id}", Map.of("id", id));
    }

    public SingleSeriesRequest(Series series) {
        this(series.getId());
    }

    @Override
    protected Series parse(JSONObject data) {
        return new Series(data);
    }
}
