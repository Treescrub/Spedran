package treescrub.spedran.data.filterbuilder;

import treescrub.spedran.data.user.User;

public class SeriesFilterBuilder extends FilterBuilder {
    public SeriesFilterBuilder getInstance() {
        return new SeriesFilterBuilder();
    }

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
}
