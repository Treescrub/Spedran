package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.data.Guest;
import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Platform;
import com.treescrub.spedran.data.Region;
import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.data.RunSystem;
import com.treescrub.spedran.data.SubmissionStatus;
import com.treescrub.spedran.data.User;
import com.treescrub.spedran.requests.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link Run}s matching the set filters.
 */
public class RunsRequest extends ResourceCollectionRequest<Run> {
    @SuppressWarnings("unused")
    public RunsRequest() {
        super(HttpMethod.GET, "runs");
    }

    /**
     * Restricts the results to runs that the given {@link User} has participated in.
     *
     * @param id the user ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest user(String id) {
        setParameter("user", id);
        return this;
    }

    /**
     * Restricts the results to runs that the given {@link User} has participated in.
     *
     * @param user the user
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest user(User user) {
        return user(user.getId());
    }

    /**
     * Restricts the results to runs that the given {@link Guest} has participated in.
     *
     * @param name the guest's name
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest guest(String name) {
        setParameter("guest", name);
        return this;
    }

    /**
     * Restricts the results to runs that the given {@link Guest} has participated in.
     *
     * @param guest the guest
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest guest(Guest guest) {
        return guest(guest.getName());
    }

    /**
     * Restricts the results to runs that the given {@link User} has rejected or verified.
     *
     * @param id the ID of the verifier
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest verifier(String id) {
        setParameter("examiner", id);
        return this;
    }

    /**
     * Restricts the results to runs that the given {@link User} has rejected or verified.
     *
     * @param user the verifier
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest verifier(User user) {
        return verifier(user.getId());
    }

    /**
     * Restricts the results to runs in the given {@link Game}.
     *
     * @param id the game ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    /**
     * Restricts the results to runs in the given {@link Game}.
     *
     * @param game the game
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest game(Game game) {
        return game(game.getId());
    }

    /**
     * Restricts the results to runs played on the given {@link Level}.
     *
     * @param id the level ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest level(String id) {
        setParameter("level", id);
        return this;
    }

    /**
     * Restricts the results to runs played on the given {@link Level}.
     *
     * @param level the level
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest level(Level level) {
        return level(level.getId());
    }

    /**
     * Restricts the results to runs played in the given {@link Category}.
     *
     * @param id the category ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest category(String id) {
        setParameter("category", id);
        return this;
    }

    /**
     * Restricts the results to runs played in the given {@link Category}.
     *
     * @param category the category
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest category(Category category) {
        return category(category.getId());
    }

    /**
     * Restricts the results to runs played on the given {@link Platform}.
     *
     * @param id the platform ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    /**
     * Restricts the results to runs played on the given {@link Platform}.
     *
     * @param platform the platform
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Restricts the results to runs played on the given {@link Region}.
     *
     * @param id the region ID
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    /**
     * Restricts the results to runs played on the given {@link Region}.
     *
     * @param region the region
     * @return this {@code RunsRequest} builder
     */
    public RunsRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Restricts the results to runs that are on emulators, or runs that are not on an emulator.
     *
     * @param isEmulated restrict based on emulator used
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest emulated(boolean isEmulated) {
        setParameter("emulated", isEmulated);
        return this;
    }

    /**
     * Restricts the results to runs with the provided {@link SubmissionStatus}.
     *
     * @param submissionStatus the verification status to filter for
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest status(SubmissionStatus submissionStatus) {
        setParameter("status", submissionStatus.name().toLowerCase());
        return this;
    }

    /**
     * Sorts the results by the creation time of {@link Game}s.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByGame() {
        setSortParameter("game");
        return this;
    }

    /**
     * Sorts the results by the creation time of {@link Category}s.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByCategory() {
        setSortParameter("category");
        return this;
    }

    /**
     * Sorts the results by the creation time of {@link Level}s.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByLevel() {
        setSortParameter("level");
        return this;
    }

    /**
     * Sorts the results by the creation time of {@link Platform}s.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByPlatform() {
        setSortParameter("platform");
        return this;
    }

    /**
     * Sorts the results by the creation time of {@link Region}s.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByRegion() {
        setSortParameter("region");
        return this;
    }

    /**
     * Sorts the results by the {@link RunSystem#isEmulated()} boolean flag.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByEmulation() {
        setSortParameter("emulated");
        return this;
    }

    /**
     * Sorts the results by the date of the run.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByDate() {
        setSortParameter("date");
        return this;
    }

    /**
     * Sorts the results by the submission time of the run.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortBySubmissionDate() {
        setSortParameter("submitted");
        return this;
    }

    /**
     * Sorts the results by the verification status.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByVerificationStatus() {
        setSortParameter("status");
        return this;
    }

    /**
     * Sorts the results by the time that the run was rejected or verified.
     *
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortByVerificationDate() {
        setSortParameter("verify-date");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }
}
