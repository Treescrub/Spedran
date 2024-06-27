package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.*;
import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Game}s matching the set filters.
 */
public class GamesRequest extends ResourceCollectionRequest<Game> {
    public static final int MAX_ITEMS_BULK = 1000;

    public GamesRequest() {
        super(HttpMethod.GET, "games");
    }

    /**
     * Use a fuzzy search to filter game names and abbreviations.
     *
     * @param name the {@code String} to search for
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    /**
     * Search for an exact game abbreviation.
     *
     * @param abbreviation the abbreviation to search for
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    /**
     * Restricts the results to games with the given release year.
     *
     * @param year the year a game was released
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Gametype}.
     *
     * @param id the gametype ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Gametype}.
     *
     * @param gametype the gametype
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    /**
     * Restricts the results to games with the given {@link Platform}.
     *
     * @param id the platform ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Platform}.
     *
     * @param platform the platform
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Restricts the results to games with the given {@link Region}.
     *
     * @param id the region ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Region}.
     *
     * @param region the region
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Restricts the results to games with the given {@link Genre}.
     *
     * @param id the genre ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Genre}.
     *
     * @param genre the genre
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest genre(Genre genre) {
        return genre(genre.getId());
    }

    /**
     * Restricts the results to games with the given {@link Engine}.
     *
     * @param id the engine ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Engine}.
     *
     * @param engine the engine
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest engine(Engine engine) {
        return engine(engine.getId());
    }

    /**
     * Restricts the results to games with the given {@link Developer}.
     *
     * @param id the developer ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Developer}.
     *
     * @param developer the developer
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest developer(Developer developer) {
        return developer(developer.getId());
    }

    /**
     * Restricts the results to games with the given {@link Publisher}.
     *
     * @param id the publisher ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Publisher}.
     *
     * @param publisher the publisher
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    /**
     * Restricts the results to games where the given {@link User} is a moderator.
     *
     * @param id the user ID
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    /**
     * Restricts the results to games where the given {@link User} is a moderator.
     *
     * @param user the user
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest moderator(User user) {
        return moderator(user.getId());
    }

    public GamesRequest asBulk() {
        setParameter("max", MAX_ITEMS_BULK);
        return this;
    }

    /**
     * Sorts the results alphanumerically by the international name of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the Japanese name of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the abbreviation of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    /**
     * Sorts the results by the release date of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    /**
     * Sorts the results by the creation date of the games on SRC.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    /**
     * Sorts the results by similarity when {@link GamesRequest#name(String)} is set.
     *
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code GamesRequest} builder
     */
    public GamesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
