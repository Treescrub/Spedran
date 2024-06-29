package com.github.treescrub.spedran.requests.builders.user;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

/**
 * A request builder to get the {@link User} that owns the current API key.
 *
 * @see Spedran#setApiKey(String)
 */
public class ProfileRequest extends SingleResourceRequest<User> {
    @SuppressWarnings("unused")
    public ProfileRequest() {
        super(HttpMethod.GET, "profile");
    }

    @Override
    protected Class<User> getDataClass() {
        return User.class;
    }
}
