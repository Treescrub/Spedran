package com.github.treescrub.spedran.requests.user;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.user.User;

import java.util.Map;

public class UserRequest extends SingleResourceRequest<User> {
    public UserRequest(String id) {
        super(HttpMethod.GET, "users/{id}", Map.of("id", id));
    }

    public UserRequest(User user) {
        this(user.getId());
    }

    @Override
    protected User parse(JSONObject data) {
        return new User(data);
    }
}
