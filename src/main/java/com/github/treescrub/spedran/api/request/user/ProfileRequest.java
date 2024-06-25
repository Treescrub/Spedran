package com.github.treescrub.spedran.api.request.user;

import com.github.treescrub.spedran.api.request.SingleResourceRequest;
import com.github.treescrub.spedran.data.user.User;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;

public class ProfileRequest extends SingleResourceRequest<User> {
    public ProfileRequest() {
        super(HttpMethod.GET, "profile");
    }

    @Override
    protected User parse(JSONObject data) {
        return new User(data.getJSONObject("data"));
    }
}
