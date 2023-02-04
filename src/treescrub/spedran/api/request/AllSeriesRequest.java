package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Series;

import java.util.function.Function;

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
    protected Function<JSONObject, Series> getConstructor() {
        return Series::new;
    }
}
