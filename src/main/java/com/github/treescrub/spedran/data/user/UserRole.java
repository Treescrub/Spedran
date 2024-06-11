package com.github.treescrub.spedran.data.user;

/**
 * The role of a user on SRC.
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
