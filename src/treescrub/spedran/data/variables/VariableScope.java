package treescrub.spedran.data.variables;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 *
 */
public class VariableScope {
    public enum ScopeType {
        GLOBAL,
        FULL_GAME,
        ALL_LEVELS,
        SINGLE_LEVEL
    }

    private ScopeType type;
    private String level;

    public VariableScope(JSONObject data) {
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
     *
     * @return
     */
    public ScopeType getType() {
        return type;
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getLevel(String)
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
