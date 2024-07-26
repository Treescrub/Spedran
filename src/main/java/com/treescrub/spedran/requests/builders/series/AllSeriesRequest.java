package com.treescrub.spedran.requests.builders.series;

import com.treescrub.spedran.data.Series;
import com.treescrub.spedran.data.User;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Series} matching the set filters.
 */
public class AllSeriesRequest extends ResourceCollectionRequest<Series> {
    @SuppressWarnings("unused")
    public AllSeriesRequest() {
        super(HttpMethod.GET, "series");
    }

    /**
     * Use a fuzzy search to filter series names and abbreviations.
     *
     * @param name the {@code String} to search for
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    /**
     * Search for an exact series abbreviation.
     *
     * @param abbreviation the abbreviation to search for
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    /**
     * Restricts the results to series moderated by the given {@link User}.
     *
     * @param id the user ID
     * @return this {@code AllSeriesRequest} builder
     */
    public AllSeriesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    /**
     * Restricts the results to series moderated by the given {@link User}.
     *
     * @param user the user
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest moderator(User user) {
        return moderator(user.getId());
    }

    /**
     * Sorts the results alphanumerically by the international name of the series.
     *
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the Japanese name of the series.
     *
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the abbreviation of the series.
     *
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    /**
     * Sorts the results by the creation time of the series on SRC.
     *
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code AllSeriesRequest} builder
     */
    @SuppressWarnings("unused")
    public AllSeriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Series> getDataClass() {
        return Series.class;
    }
}
