package com.treescrub.spedran.requests.builders.user;

import com.treescrub.spedran.data.User;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

/**
 * A request builder to get all {@link User}s matching the set filters.
 */
public class UsersRequest extends ResourceCollectionRequest<User> {
    @SuppressWarnings("unused")
    public UsersRequest() {
        super(HttpMethod.GET, "users");
    }

    /**
     * Searches for a single {@link User} with the given name.
     * <br>
     * Search is case-insensitive and must match exactly with an existing user.
     *
     * @param name the name to search for
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest lookup(String name) {
        setParameter("lookup", name);
        return this;
    }

    /**
     * Searches for {@link User}s with a name that contains the given string.
     * <br>
     * Search is case-insensitive.
     *
     * @param name the substring to search for, must be at least 3 characters long
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    /**
     * Searches for a single {@link User} with the given Twitch username.
     * <br>
     * Search is case-insensitive and must match exactly with a linked Twitch account name.
     *
     * @param twitch the Twitch username
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest twitch(String twitch) {
        setParameter("twitch", twitch);
        return this;
    }

    /**
     * Searches for a single {@link User} with the given Hitbox username.
     * <br>
     * Search is case-insensitive and must match exactly with a linked Hitbox account name.
     *
     * @param hitbox the Hitbox username
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest hitbox(String hitbox) {
        setParameter("hitbox", hitbox);
        return this;
    }

    /**
     * Searches for a single {@link User} with the given Twitter handle.
     * <br>
     * Search is case-insensitive and must match exactly with a linked Twitch account name.
     *
     * @param twitter the Twitter handle
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest twitter(String twitter) {
        setParameter("twitter", twitter);
        return this;
    }

    /**
     * Searches for a single {@link User} with the given SpeedRunsLive username.
     * <br>
     * Search is case-insensitive and must match exactly with a linked SpeedRunsLive account name.
     *
     * @param speedrunsLive the SpeedRunsLive username
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest speedrunsLive(String speedrunsLive) {
        setParameter("speedrunslive", speedrunsLive);
        return this;
    }

    /**
     * Sorts the results alphanumerically by the international name of the users.
     *
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the Japanese name of the users.
     *
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    /**
     * Sorts the results by the user's signup time.
     *
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest sortBySignupDate() {
        setSortParameter("signup");
        return this;
    }

    /**
     * Sorts the results by the user's role on SRC.
     * <br><br>
     * The order is determined by privilege/access level, not alphanumerically.
     *
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest sortByRole() {
        setSortParameter("role");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public UsersRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    // TODO: not setting any query parameters will return a 400 (bad request), CompletableFuture.failedFuture

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
