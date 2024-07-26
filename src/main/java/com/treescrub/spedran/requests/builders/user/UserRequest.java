package com.treescrub.spedran.requests.builders.user;

import com.treescrub.spedran.data.User;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link User}.
 */
public class UserRequest extends SingleResourceRequest<User> {
    @SuppressWarnings("unused")
    public UserRequest(String id) {
        super(HttpMethod.GET, "users/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public UserRequest(User user) {
        this(user.getId());
    }

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
