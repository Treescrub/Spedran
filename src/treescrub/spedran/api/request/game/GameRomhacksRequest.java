package treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.*;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.user.User;

import java.util.Map;
import java.util.function.Function;

public class GameRomhacksRequest extends ResourceCollectionRequest<Game> {
    public GameRomhacksRequest(String id) {
        super(HttpMethod.GET, "games/{id}/derived-games", Map.of("id", id));
    }

    public GameRomhacksRequest(Game game) {
        this(game.getId());
    }

    public GameRomhacksRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    public GameRomhacksRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    public GameRomhacksRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    public GameRomhacksRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    public GameRomhacksRequest gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    public GameRomhacksRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public GameRomhacksRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    public GameRomhacksRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public GameRomhacksRequest region(Region region) {
        return region(region.getId());
    }

    public GameRomhacksRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    public GameRomhacksRequest genre(Genre genre) {
        return genre(genre.getId());
    }

    public GameRomhacksRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    public GameRomhacksRequest engine(Engine engine) {
        return engine(engine.getId());
    }

    public GameRomhacksRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    public GameRomhacksRequest developer(Developer developer) {
        return developer(developer.getId());
    }

    public GameRomhacksRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    public GameRomhacksRequest publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    public GameRomhacksRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public GameRomhacksRequest moderator(User user) {
        return moderator(user.getId());
    }
    
    public GameRomhacksRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    public GameRomhacksRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    public GameRomhacksRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    public GameRomhacksRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    public GameRomhacksRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    public GameRomhacksRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    public GameRomhacksRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Game> getConstructor() {
        return Game::new;
    }
}
