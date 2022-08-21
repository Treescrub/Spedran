package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Names {
    private String international;
    private String japanese;
    private String twitch;

    public Names(JSONObject data) {
        international = data.getString("international");
        japanese = data.optString("japanese", null);
        twitch = data.optString("twitch", null);
    }

    public String getInternationalName() {
        return international;
    }

    public Optional<String> getJapaneseName() {
        return Optional.ofNullable(japanese);
    }

    public Optional<String> getTwitchName() {
        return Optional.ofNullable(twitch);
    }
}
