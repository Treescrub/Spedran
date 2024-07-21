package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.requests.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import com.treescrub.spedran.data.*;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all derived {@link Game}s (romhacks) for a given {@code Game}.
 */
public class GameRomhacksRequest extends ResourceCollectionRequest<Game> {
    @SuppressWarnings("unused")
    public GameRomhacksRequest(String id) {
        super(HttpMethod.GET, "games/{id}/derived-games", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GameRomhacksRequest(Game game) {
        this(game.getId());
    }

    /**
     * Sets the value to search across names and abbreviations. Uses a fuzzy search.
     *
     * @param name search query
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    /**
     * Sets the abbreviation to filter for.
     *
     * @param abbreviation the game abbreviation to search for
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    /**
     * Sets the release year to filter for.
     *
     * @param year release year
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    /**
     * Sets the gametype to filter for.
     *
     * @param id the gametype ID
     * @return this object
     */
    public GameRomhacksRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    /**
     * Sets the gametype to filter for.
     *
     * @param gametype the gametype
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    /**
     * Sets the platform to filter for.
     *
     * @param id the platform ID
     * @return this object
     */
    public GameRomhacksRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    /**
     * Sets the platform to filter for.
     *
     * @param platform the platform
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Sets the region to filter for.
     *
     * @param id the region ID
     * @return this object
     */
    public GameRomhacksRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    /**
     * Sets the region to filter for.
     *
     * @param region the region
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Sets the genre to filter for.
     *
     * @param id the genre id
     * @return this object
     */
    public GameRomhacksRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    /**
     * Sets the genre to filter for.
     *
     * @param genre the genre
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest genre(Genre genre) {
        return genre(genre.getId());
    }

    /**
     * Sets the engine to filter for.
     *
     * @param id the engine ID
     * @return this object
     */
    public GameRomhacksRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    /**
     * Sets the engine to filter for.
     *
     * @param engine the engine
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest engine(Engine engine) {
        return engine(engine.getId());
    }

    /**
     * Sets the developer to filter for.
     *
     * @param id the developer ID
     * @return this object
     */
    public GameRomhacksRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    /**
     * Sets the developer to filter for.
     *
     * @param developer the developer
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest developer(Developer developer) {
        return developer(developer.getId());
    }

    /**
     * Sets the publisher to filter for.
     *
     * @param id the publisher ID
     * @return this object
     */
    public GameRomhacksRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    /**
     * Sets the publisher to filter for.
     *
     * @param publisher the publisher
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    /**
     * Sets the moderator to filter for.
     *
     * @param id the user ID
     * @return this object
     */
    public GameRomhacksRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    /**
     * Sets the moderator to filter for.
     *
     * @param user the user
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest moderator(User user) {
        return moderator(user.getId());
    }

    /**
     * Sorts the returned games by the international name.
     *
     * @return this object
     * @see Game#getNames()
     * @see Names#getInternationalName()
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    /**
     * Sorts the returned games by the japanese name.
     *
     * @return this object
     * @see Game#getNames()
     * @see Names#getJapaneseName()
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    /**
     * Sorts the returned games by the abbreviation.
     *
     * @return this object
     * @see Game#getAbbreviation()
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    /**
     * Sorts the returned games by the release date.
     *
     * @return this object
     * @see Game#getReleaseDate()
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    /**
     * Sorts the returned games by the creation time.
     *
     * @return this object
     * @see Game#getCreationTime()
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    /**
     * Sorts the returned games by name similarity.
     * <p>
     * Only works when searching by name. Will always error if not searching by name.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    /**
     * Sets the direction to sort the returned games.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameRomhacksRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
