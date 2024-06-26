package com.github.treescrub.spedran.requests.builders.series;

import com.github.treescrub.spedran.data.*;
import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Series;
import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import com.github.treescrub.spedran.requests.builders.game.GamesRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class SeriesGamesRequest extends ResourceCollectionRequest<Game> {
    public SeriesGamesRequest(String id) {
        super(HttpMethod.GET, "series/{id}/games", Map.of("id", id));
    }

    public SeriesGamesRequest(Series series) {
        this(series.getId());
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
    
    public SeriesGamesRequest  gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    public SeriesGamesRequest  gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    public SeriesGamesRequest  platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public SeriesGamesRequest  platform(Platform platform) {
        return platform(platform.getId());
    }

    public SeriesGamesRequest  region(String id) {
        setParameter("region", id);
        return this;
    }

    public SeriesGamesRequest  region(Region region) {
        return region(region.getId());
    }

    public SeriesGamesRequest  genre(String id) {
        setParameter("genre", id);
        return this;
    }

    public SeriesGamesRequest  genre(Genre genre) {
        return genre(genre.getId());
    }

    public SeriesGamesRequest  engine(String id) {
        setParameter("engine", id);
        return this;
    }

    public SeriesGamesRequest  engine(Engine engine) {
        return engine(engine.getId());
    }

    public SeriesGamesRequest  developer(String id) {
        setParameter("developer", id);
        return this;
    }

    public SeriesGamesRequest  developer(Developer developer) {
        return developer(developer.getId());
    }

    public SeriesGamesRequest  publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    public SeriesGamesRequest  publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    public SeriesGamesRequest  moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    public SeriesGamesRequest  moderator(User user) {
        return moderator(user.getId());
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
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
