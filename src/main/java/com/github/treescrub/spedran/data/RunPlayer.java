package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

/**
 * Has information about a specific runner.
 * Only makes sense in the context of a run.
 */
public class RunPlayer extends Link {
    private final String id;
    private final boolean isGuest;

    RunPlayer(JSONObject data) {
        super(data);

        if(!data.isNull("id")) {
            id = data.getString("id");
            isGuest = false;
        } else {
            id = data.getString("name");
            isGuest = true;
        }
    }

    /**
     * Returns {@code true} if this runner is a guest, otherwise {@code false} if this runner is a user.
     *
     * @return whether this runner is a guest
     *
     * @see com.github.treescrub.spedran.data.Guest
     * @see User
     */
    public boolean isGuest() {
        return isGuest;
    }

    /**
     * If this runner is a guest, returns their username. Otherwise, if this runner is a user, returns their user ID.
     *
     * @return a {@code String} with the user ID or guest name
     *
     * @see com.github.treescrub.spedran.data.Guest
     * @see User
     * @see Spedran#getUser(String)
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RunPlayer[" + id + "]";
    }
}