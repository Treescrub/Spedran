package com.github.treescrub.spedran.data;

/**
 * The role of a user on SRC.
 * <br>
 * These roles are site wide, they are not affiliated with a specific leaderboard.
 */
public enum UserRole {
    /**
     * The default role for a normal user.
     */
    USER,
    /**
     * The user is currently banned, either temporarily or permanently.
     */
    BANNED,
    /**
     * Unknown, unsure if actually used.
     */
    TRUSTED,
    /**
     * SRC site moderator.
     */
    MODERATOR,
    /**
     * SRC site admin.
     */
    ADMIN,
    /**
     * SRC site programmer.
     */
    PROGRAMMER,
}
