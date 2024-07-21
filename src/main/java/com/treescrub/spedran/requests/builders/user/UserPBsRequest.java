package com.treescrub.spedran.requests.builders.user;

import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.LeaderboardRun;
import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.data.Series;
import com.treescrub.spedran.data.User;
import com.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the personal best {@link Run}s of a {@link User}.
 */
public class UserPBsRequest extends ResourceCollectionRequest<LeaderboardRun> {
    @SuppressWarnings("unused")
    public UserPBsRequest(String id) {
        super(HttpMethod.GET, "users/{id}/personal-bests", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public UserPBsRequest(User user) {
        this(user.getId());
    }

    /**
     * Sets the minimum placement to restrict the results to.
     *
     * @param topPlace the top place to filter PBs by
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest top(int topPlace) {
        setParameter("top", topPlace);
        return this;
    }

    /**
     * Restricts the results to the given {@link Series}.
     *
     * @param id the series ID
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest series(String id) {
        setParameter("series", id);
        return this;
    }

    /**
     * Restricts the results to the given {@link Game}.
     *
     * @param id the game ID
     * @return this {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    @Override
    protected Class<LeaderboardRun> getDataClass() {
        return LeaderboardRun.class;
    }
}
