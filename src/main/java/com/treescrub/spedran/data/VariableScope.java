package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * The scope that a {@link Variable} should apply or be visible in.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class VariableScope {
    /**
     * The type of scope that a variable has.
     */
    public enum ScopeType {
        /**
         * Applies to every run in the game.
         */
        GLOBAL,
        /**
         * Applies only to runs that don't have levels.
         */
        FULL_GAME,
        /**
         * Applies to runs that do have levels.
         */
        ALL_LEVELS,
        /**
         * Applies only to one specific level.
         */
        SINGLE_LEVEL
    }

    private final ScopeType type;
    private final String level;

    VariableScope(JSONObject data) {
        type = parseType(data.getString("type"));
        level = data.optString("level", null);
    }

    private ScopeType parseType(String type) {
        if("global".equals(type))
            return ScopeType.GLOBAL;
        if("full-game".equals(type))
            return ScopeType.FULL_GAME;
        if("all-levels".equals(type))
            return ScopeType.ALL_LEVELS;
        if("single-level".equals(type))
            return ScopeType.SINGLE_LEVEL;

        return null;
    }

    /**
     * Gets the {@link ScopeType} for the variable.
     *
     * @return a {@code ScopeType}
     */
    public ScopeType getType() {
        return type;
    }

    /**
     * Gets the associated level ID if the scope type is {@link ScopeType#SINGLE_LEVEL}.
     *
     * @return an {@link Optional} with the level ID if the scope is limited to a single level
     *
     * @see Level
     * @see Spedran#getLevel(String)
     */
    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    @Override
    public String toString() {
        return "VariableScope{" +
                "type=" + type +
                ", level='" + level + '\'' +
                '}';
    }
}
