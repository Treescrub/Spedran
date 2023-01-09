package treescrub.spedran.data.filterbuilder;

import treescrub.spedran.data.*;
import treescrub.spedran.data.user.User;

public class GameFilterBuilder extends FilterBuilder {
    public static GameFilterBuilder getInstance() {
        return new GameFilterBuilder();
    }

    public GameFilterBuilder name(String value) {
        setOption("name", value);
        return this;
    }

    public GameFilterBuilder abbreviation(String value) {
        setOption("abbreviation", value);
        return this;
    }

    public GameFilterBuilder released(int value) {
        setOption("released", value);
        return this;
    }

    public GameFilterBuilder gametype(String id) {
        setOption("gametype", id);
        return this;
    }

    public GameFilterBuilder gametype(Gametype value) {
        return gametype(value.getId());
    }

    public GameFilterBuilder platform(String id) {
        setOption("platform", id);
        return this;
    }

    public GameFilterBuilder platform(Platform value) {
        return platform(value.getId());
    }

    public GameFilterBuilder region(String id) {
        setOption("region", id);
        return this;
    }

    public GameFilterBuilder region(Region value) {
        return region(value.getId());
    }

    public GameFilterBuilder genre(String id) {
        setOption("genre", id);
        return this;
    }

    public GameFilterBuilder genre(Genre value) {
        return genre(value.getId());
    }

    public GameFilterBuilder engine(String id) {
        setOption("engine", id);
        return this;
    }

    public GameFilterBuilder engine(Engine value) {
        return engine(value.getId());
    }

    public GameFilterBuilder developer(String id) {
        setOption("developer", id);
        return this;
    }

    public GameFilterBuilder developer(Developer value) {
        return developer(value.getId());
    }

    public GameFilterBuilder publisher(String id) {
        setOption("publisher", id);
        return this;
    }

    public GameFilterBuilder publisher(Publisher value) {
        return publisher(value.getId());
    }

    public GameFilterBuilder moderator(String id) {
        setOption("moderator", id);
        return this;
    }

    public GameFilterBuilder moderator(User user) {
        return moderator(user.getId());
    }
}
