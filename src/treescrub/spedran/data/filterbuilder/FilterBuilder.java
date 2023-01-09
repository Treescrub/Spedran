package treescrub.spedran.data.filterbuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class FilterBuilder {
    protected Map<String, Object> filters;

    protected FilterBuilder() {
        this.filters = new HashMap<>();
    }

    protected void setOption(String key, Object value) {
        filters.put(key, value);
    }

    public Map<String, Object> toMap() {
        return Collections.unmodifiableMap(filters);
    }
}
