package com.github.treescrub.spedran.requests.builders.user;

import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link User}.
 */
public class UserRequest extends SingleResourceRequest<User> {
    public UserRequest(String id) {
        super(HttpMethod.GET, "users/{id}", Map.of("id", id));
    }

    public UserRequest(User user) {
        this(user.getId());
    }

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
