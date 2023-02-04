package treescrub.spedran.api.request.series;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.game.GamesRequest;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.game.Game;

import java.util.Map;
import java.util.function.Function;

public class SeriesGamesRequest extends ResourceCollectionRequest<Game> {
    public SeriesGamesRequest(String id) {
        super(HttpMethod.GET, "series/{id}/games", Map.of("id", id));
    }

    public SeriesGamesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    public SeriesGamesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    public SeriesGamesRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    public SeriesGamesRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    public SeriesGamesRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public SeriesGamesRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public SeriesGamesRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    public SeriesGamesRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    public SeriesGamesRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    public SeriesGamesRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    public SeriesGamesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public SeriesGamesRequest asBulk() {
        setParameter("max", GamesRequest.MAX_ITEMS_BULK);
        return this;
    }

    public SeriesGamesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    public SeriesGamesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    public SeriesGamesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    public SeriesGamesRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    public SeriesGamesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    public SeriesGamesRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    public SeriesGamesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }
    
    @Override
    protected Function<JSONObject, Game> getConstructor() {
        return Game::new;
    }
}
