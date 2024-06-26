package com.github.treescrub.spedran.requests.builders.user;

import com.github.treescrub.spedran.data.LeaderboardRun;
import com.github.treescrub.spedran.data.User;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class UserPBsRequest extends ResourceCollectionRequest<LeaderboardRun> {
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
    protected Class<LeaderboardRun> getDataClass() {
        return LeaderboardRun.class;
    }
}
