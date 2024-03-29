package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Names;

import java.util.Objects;

/**
 * Provides region code and name info.
 */
public class LocationInfo {
    private String code;
    private Names names;

    public LocationInfo(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        code = data.getString("code");
        names = new Names(data.getJSONObject("names"));
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return
     */
    public Names getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationInfo that = (LocationInfo) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "code='" + code + '\'' +
                ", names=" + names +
                '}';
    }
}
