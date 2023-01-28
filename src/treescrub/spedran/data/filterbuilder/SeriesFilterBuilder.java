package treescrub.spedran.data.filterbuilder;

import treescrub.spedran.data.user.User;

public class SeriesFilterBuilder extends FilterBuilder {

    public SeriesFilterBuilder name(String value) {
        setOption("name", value);
        return this;
    }

    public SeriesFilterBuilder abbreviation(String value) {
        setOption("abbreviation", value);
        return this;
    }

    public SeriesFilterBuilder moderator(String id) {
        setOption("moderator", id);
        return this;
    }

    public SeriesFilterBuilder moderator(User user) {
        return moderator(user.getId());
    }

    public SeriesFilterBuilder sortByInternationalName() {
        setOption("orderby", "name.int");
        return this;
    }

    public SeriesFilterBuilder sortByJapaneseName() {
        setOption("orderby", "name.jap");
        return this;
    }

    public SeriesFilterBuilder sortByAbbreviation() {
        setOption("orderby", "abbreviation");
        return this;
    }

    public SeriesFilterBuilder sortByCreationDate() {
        setOption("orderby", "created");
        return this;
    }

    public SeriesFilterBuilder sortAscending() {
        setOption("direction", "asc");
        return this;
    }

    public SeriesFilterBuilder sortDescending() {
        setOption("direction", "desc");
        return this;
    }
}
