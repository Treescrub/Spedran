package treescrub.spedran.data.filterbuilder;

public class UserFilterBuilder extends FilterBuilder {
    public static UserFilterBuilder getInstance() {
        return new UserFilterBuilder();
    }

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
}
