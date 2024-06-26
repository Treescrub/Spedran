package com.github.treescrub.spedran.requests.builders.user;

import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

public class ProfileRequest extends SingleResourceRequest<User> {
    public ProfileRequest() {
        super(HttpMethod.GET, "profile");
    }

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
