package com.treescrub.spedran.requests.builders.series;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import com.treescrub.spedran.requests.builders.embed.LevelEmbedBuilder;
import com.treescrub.spedran.requests.builders.game.GamesRequest;
import com.treescrub.spedran.data.*;
import com.treescrub.spedran.requests.builders.run.RunStatusRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get {@link Game}s in the given {@link Series} matching the set filters.
 */
public class SeriesGamesRequest extends ResourceCollectionRequest<Game> {
    @SuppressWarnings("unused")
    protected SeriesGamesRequest(String id) {
        super(HttpMethod.GET, "series/{id}/games", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code SeriesGamesRequest} builder.
     *
     * @param series the series to get the games for
     * @return a {@code SeriesGamesRequest} builder
     */
    public static SeriesGamesRequest create(Series series) {
        checkResource(series, "series");

        return new SeriesGamesRequest(series.getId());
    }

    /**
     * Creates and returns a new {@code SeriesGamesRequest} builder.
     *
     * @param id the series to get the games for
     * @return a {@code SeriesGamesRequest} builder
     */
    public static SeriesGamesRequest create(String id) {
        checkId(id);

        return new SeriesGamesRequest(id);
    }

    /**
     * Use a fuzzy search to filter game names and abbreviations.
     *
     * @param name the {@code String} to search for
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    /**
     * Search for an exact game abbreviation.
     *
     * @param abbreviation the abbreviation to search for
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest abbreviation(String abbreviation) {
        setParameter("abbreviation", abbreviation);
        return this;
    }

    /**
     * Restricts the results to games with the given release year.
     *
     * @param year the year a game was released
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest releaseYear(int year) {
        setParameter("released", year);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Gametype}.
     *
     * @param id the gametype ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest gameType(String id) {
        setParameter("gametype", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Gametype}.
     *
     * @param gametype the gametype
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest gameType(Gametype gametype) {
        return gameType(gametype.getId());
    }

    /**
     * Restricts the results to games with the given {@link Platform}.
     *
     * @param id the platform ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest  platform(String id) {
        setParameter("platform", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Platform}.
     *
     * @param platform the platform
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Restricts the results to games with the given {@link Region}.
     *
     * @param id the region ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Region}.
     *
     * @param region the region
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Restricts the results to games with the given {@link Genre}.
     *
     * @param id the genre ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest genre(String id) {
        setParameter("genre", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Genre}.
     *
     * @param genre the genre
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest genre(Genre genre) {
        return genre(genre.getId());
    }

    /**
     * Restricts the results to games with the given {@link Engine}.
     *
     * @param id the engine ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest engine(String id) {
        setParameter("engine", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Engine}.
     *
     * @param engine the engine
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest engine(Engine engine) {
        return engine(engine.getId());
    }

    /**
     * Restricts the results to games with the given {@link Developer}.
     *
     * @param id the developer ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest developer(String id) {
        setParameter("developer", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Developer}.
     *
     * @param developer the developer
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest developer(Developer developer) {
        return developer(developer.getId());
    }

    /**
     * Restricts the results to games with the given {@link Publisher}.
     *
     * @param id the publisher ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest publisher(String id) {
        setParameter("publisher", id);
        return this;
    }

    /**
     * Restricts the results to games with the given {@link Publisher}.
     *
     * @param publisher the publisher
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest publisher(Publisher publisher) {
        return publisher(publisher.getId());
    }

    /**
     * Restricts the results to games where the given {@link User} is a moderator.
     *
     * @param id the user ID
     * @return this {@code GamesRequest} builder
     */
    public SeriesGamesRequest moderator(String id) {
        setParameter("moderator", id);
        return this;
    }

    /**
     * Restricts the results to games where the given {@link User} is a moderator.
     *
     * @param user the user
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest moderator(User user) {
        return moderator(user.getId());
    }

    public SeriesGamesRequest asBulk() {
        setParameter("max", GamesRequest.MAX_ITEMS_BULK);
        return this;
    }

    /**
     * Embed the levels for each game.
     *
     * @return this object
     *
     * @see Game#getLevels()
     */
    public SeriesGamesRequest embedLevels() {
        addEmbed("levels");
        return this;
    }

    /**
     * Embed the levels for each game and any provided embeds for the levels.
     *
     * @param builder the embed builder for the levels
     * @return this object
     *
     * @see Game#getLevels()
     */
    public SeriesGamesRequest embedLevels(LevelEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "levels");
        return this;
    }

    /**
     * Embed the categories for each game.
     *
     * @return this object
     *
     * @see Game#getCategories()
     */
    public SeriesGamesRequest embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embed the categories for each game and any provided embeds for the categories.
     *
     * @param builder the embed builder for the categories
     * @return this object
     *
     * @see Game#getCategories()
     */
    public SeriesGamesRequest embedCategories(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "categories");
        return this;
    }

    /**
     * Embed the gametypes for each game.
     *
     * @return this object
     *
     * @see Game#getGametypes()
     */
    public SeriesGamesRequest embedGametypes() {
        addEmbed("gametypes");
        return this;
    }

    /**
     * Embed the platforms for each game.
     *
     * @return this object
     *
     * @see Game#getPlatforms()
     */
    public SeriesGamesRequest embedPlatforms() {
        addEmbed("platforms");
        return this;
    }

    /**
     * Embed the regions for each game.
     *
     * @return this object
     *
     * @see Game#getRegions()
     */
    public SeriesGamesRequest embedRegions() {
        addEmbed("regions");
        return this;
    }

    /**
     * Embed the genres for each game.
     *
     * @return this object
     *
     * @see Game#getGenres()
     */
    public SeriesGamesRequest embedGenres() {
        addEmbed("genres");
        return this;
    }

    /**
     * Embed the engines for each game.
     *
     * @return this object
     *
     * @see Game#getEngines()
     */
    public SeriesGamesRequest embedEngines() {
        addEmbed("engines");
        return this;
    }

    /**
     * Embed the developers for each game.
     *
     * @return this object
     *
     * @see Game#getDevelopers()
     */
    public SeriesGamesRequest embedDevelopers() {
        addEmbed("developers");
        return this;
    }

    /**
     * Embed the publishers for each game.
     *
     * @return this object
     *
     * @see Game#getPublishers()
     */
    public SeriesGamesRequest embedPublishers() {
        addEmbed("publishers");
        return this;
    }

    /**
     * Embed the variables for each game.
     *
     * @return this object
     *
     * @see Game#getVariables()
     */
    public SeriesGamesRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the international name of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the Japanese name of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the abbreviation of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByAbbreviation() {
        setSortParameter("abbreviation");
        return this;
    }

    /**
     * Sorts the results by the release date of the games.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByReleaseDate() {
        setSortParameter("released");
        return this;
    }

    /**
     * Sorts the results by the creation date of the games on SRC.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByCreationDate() {
        setSortParameter("created");
        return this;
    }

    /**
     * Sorts the results by similarity when {@link GamesRequest#name(String)} is set.
     *
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortByNameSimilarity() {
        setSortParameter("similarity");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public SeriesGamesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Game> getDataClass() {
        return Game.class;
    }
}
