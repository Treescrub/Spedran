package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.game.Game;

import java.util.function.Function;

public class GamesRequest extends ResourceCollectionRequest<Game> {
    protected static final int MAX_ITEMS_BULK = 1000;

    public GamesRequest() {
        super(HttpMethod.GET, "games");
    }

    public GamesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    public GamesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    public GamesRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    public GamesRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    public GamesRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public GamesRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public GamesRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    public GamesRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    public GamesRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    public GamesRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    public GamesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public GamesRequest asBulk() {
        setParameter("max", MAX_ITEMS_BULK);
        return this;
    }

    public GamesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    public GamesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    public GamesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    public GamesRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    public GamesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    public GamesRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    public GamesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Game> getConstructor() {
        return Game::new;
    }
}
