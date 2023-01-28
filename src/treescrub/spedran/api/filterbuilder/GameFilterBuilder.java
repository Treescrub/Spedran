package treescrub.spedran.api.filterbuilder;

import treescrub.spedran.data.*;
import treescrub.spedran.data.user.User;

public class GameFilterBuilder extends FilterBuilder {

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

    public GameFilterBuilder sortByInternationalName() {
        setOption("orderby", "name.int");
        return this;
    }

    public GameFilterBuilder sortByJapaneseName() {
        setOption("orderby", "name.jap");
        return this;
    }

    public GameFilterBuilder sortByAbbreviation() {
        setOption("orderby", "abbreviation");
        return this;
    }

    public GameFilterBuilder sortByReleaseDate() {
        setOption("orderby", "released");
        return this;
    }

    public GameFilterBuilder sortByCreationDate() {
        setOption("orderby", "created");
        return this;
    }

    public GameFilterBuilder sortBySimilarity() {
        setOption("orderby", "similarity");
        return this;
    }

    public GameFilterBuilder sortAscending() {
        setOption("direction", "asc");
        return this;
    }

    public GameFilterBuilder sortDescending() {
        setOption("direction", "desc");
        return this;
    }
}
