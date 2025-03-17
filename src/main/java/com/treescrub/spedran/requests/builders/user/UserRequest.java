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
    protected UserRequest(String id) {
        super(HttpMethod.GET, "users/{id}", Map.of("id", id));
    }

    public static UserRequest create(User user) {
        checkResource(user, "user");

        return new UserRequest(user.getId());
    }

    public static UserRequest create(String id) {
        checkId(id);

        return new UserRequest(id);
    }

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
