package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

/**
 * Has information about a specific runner.
 * Only makes sense in the context of a run.
 * <br><br>
 * This class is immutable and thread-safe.
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
     * Gets whether this runner is a guest.
     *
     * @return whether this runner is a guest
     *
     * @see Guest
     * @see User
     */
    @SuppressWarnings("unused")
    public boolean isGuest() {
        return isGuest;
    }

    /**
     * Gets the {@link User} ID if this runner is a user, otherwise gets the {@link Guest}'s name.
     *
     * @return a {@code String} with the user ID or guest name
     *
     * @see Guest
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
