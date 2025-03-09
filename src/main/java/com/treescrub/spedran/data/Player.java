package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Represents a player in a run.
 * Either a {@link User} or a {@link Guest}.
 */
public class Player {
    private final EmbeddableResource<User> user;
    private final Guest guest;

    Player(JSONObject data) {
        if(data.getString("rel").equals("user")) {
            if(data.has("uri")) {
                this.user = new EmbeddableResource<>(data.getString("id"));
            } else {
                this.user = new EmbeddableResource<>(new User(data));
            }
            this.guest = null;
        } else {
            this.user = null;
            this.guest = new Guest(data);
        }
    }

    /**
     * Gets whether this player is a user.
     *
     * @return whether this player is a user
     *
     * @see User
     */
    public boolean isUser() {
        return user != null;
    }

    /**
     * Gets whether this player is a guest.
     *
     * @return whether this player is a guest
     *
     * @see Guest
     */
    public boolean isGuest() {
        return guest != null;
    }

    /**
     * Gets the player as a user if this player is actually a user.
     *
     * @return an {@link Optional} with the user as an {@link EmbeddableResource}
     */
    public Optional<EmbeddableResource<User>> getUser() {
        return Optional.ofNullable(user);
    }

    /**
     * Gets the player as a guest if this player is actually a guest.
     *
     * @return an {@link Optional} with the guest player
     */
    public Optional<Guest> getGuest() {
        return Optional.ofNullable(guest);
    }

    @Override
    public String toString() {
        if(isGuest()) {
            return "Player(guest)[" + guest.getName() + "]";
        } else if(isUser()) {
            return "Player(user)[" + user.getId() + "]";
        }

        return "Player(unknown)[]";
    }
}
