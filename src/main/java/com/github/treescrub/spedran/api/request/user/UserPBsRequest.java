package com.github.treescrub.spedran.api.request.user;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.ResourceCollectionRequest;
import com.github.treescrub.spedran.data.user.PersonalBest;
import com.github.treescrub.spedran.data.user.User;

import java.util.Map;
import java.util.function.Function;

public class UserPBsRequest extends ResourceCollectionRequest<PersonalBest> {
    public UserPBsRequest(String id) {
        super(HttpMethod.GET, "users/{id}/personal-bests", Map.of("id", id));
    }

    public UserPBsRequest(User user) {
        this(user.getId());
    }

    public UserPBsRequest top(int topPlace) {
        setParameter("top", topPlace);
        return this;
    }

    public UserPBsRequest series(String id) {
        setParameter("series", id);
        return this;
    }

    public UserPBsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    @Override
    protected Function<JSONObject, PersonalBest> getConstructor() {
        return PersonalBest::new;
    }
}
