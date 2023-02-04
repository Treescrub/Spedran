package treescrub.spedran.api.request.series;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Series;

import java.util.Map;

public class SingleSeriesRequest extends SingleResourceRequest<Series> {
    public SingleSeriesRequest(String id) {
        super(HttpMethod.GET, "series/{id}", Map.of("id", id));
    }

    @Override
    protected Series parse(JSONObject data) {
        return new Series(data);
    }
}
