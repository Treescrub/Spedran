package treescrub.spedran.api.request.series;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Series;
import treescrub.spedran.data.user.User;

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
    protected Function<JSONObject, Series> getConstructor() {
        return Series::new;
    }
}
