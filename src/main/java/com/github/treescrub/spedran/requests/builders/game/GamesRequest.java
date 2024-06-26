package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.*;
import com.github.treescrub.spedran.data.game.Game;
import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

public class GamesRequest extends ResourceCollectionRequest<Game> {
    public static final int MAX_ITEMS_BULK = 1000;

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

    public GamesRequest gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    public GamesRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public GamesRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    public GamesRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public GamesRequest region(Region region) {
        return region(region.getId());
    }

    public GamesRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    public GamesRequest genre(Genre genre) {
        return genre(genre.getId());
    }

    public GamesRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    public GamesRequest engine(Engine engine) {
        return engine(engine.getId());
    }

    public GamesRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    public GamesRequest developer(Developer developer) {
        return developer(developer.getId());
    }

    public GamesRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    public GamesRequest publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    public GamesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public GamesRequest moderator(User user) {
        return moderator(user.getId());
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
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
