package com.github.treescrub.spedran.requests.builders.user;

import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

public class UsersRequest extends ResourceCollectionRequest<User> {
    public UsersRequest() {
        super(HttpMethod.GET, "users");
    }

    public UsersRequest lookup(String name) {
        setParameter("lookup", name);
        return this;
    }

    public UsersRequest name(String name) {
        setParameter("name", name);
        return this;
    }

    public UsersRequest twitch(String twitch) {
        setParameter("twitch", twitch);
        return this;
    }

    public UsersRequest hitbox(String hitbox) {
        setParameter("hitbox", hitbox);
        return this;
    }

    public UsersRequest twitter(String twitter) {
        setParameter("twitter", twitter);
        return this;
    }

    public UsersRequest speedrunsLive(String speedrunsLive) {
        setParameter("speedrunslive", speedrunsLive);
        return this;
    }

    public UsersRequest sortByInternationalName() {
        setSortParameter("name.int");
        return this;
    }

    public UsersRequest sortByJapaneseName() {
        setSortParameter("name.jap");
        return this;
    }

    public UsersRequest sortBySignupDate() {
        setSortParameter("signup");
        return this;
    }

    public UsersRequest sortByRole() {
        setSortParameter("role");
        return this;
    }

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
