package treescrub.spedran.data.filterbuilder;

public class UserFilterBuilder extends FilterBuilder {

    public UserFilterBuilder lookup(String value) {
        setOption("lookup", value);
        return this;
    }

    public UserFilterBuilder name(String value) {
        setOption("name", value);
        return this;
    }

    public UserFilterBuilder twitch(String value) {
        setOption("twitch", value);
        return this;
    }

    public UserFilterBuilder hitbox(String value) {
        setOption("hitbox", value);
        return this;
    }

    public UserFilterBuilder twitter(String value) {
        setOption("twitter", value);
        return this;
    }

    public UserFilterBuilder speedrunsLive(String value) {
        setOption("speedrunslive", value);
        return this;
    }

    public UserFilterBuilder sortByInternationalName() {
        setOption("orderby", "name.int");
        return this;
    }

    public UserFilterBuilder sortByJapaneseName() {
        setOption("orderby", "name.jap");
        return this;
    }

    public UserFilterBuilder sortBySignupDate() {
        setOption("orderby", "signup");
        return this;
    }

    public UserFilterBuilder sortByRole() {
        setOption("orderby", "role");
        return this;
    }

    public UserFilterBuilder sortAscending() {
        setOption("direction", "asc");
        return this;
    }

    public UserFilterBuilder sortDescending() {
        setOption("direction", "desc");
        return this;
    }
}
