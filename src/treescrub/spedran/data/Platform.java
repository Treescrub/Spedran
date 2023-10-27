package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 *
 */
public class Platform extends IdentifiableNamedResource {
    private int released;

    public Platform(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Platform(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        released = data.getInt("released");
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getPlatform(String)
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /**
     *
     * @return
     */
    public int getReleaseYear() {
        return released;
    }

    @Override
    public String toString() {
        return "Platform[" + id + "]{" +
                "name='" + name + '\'' +
                ", released=" + released +
                "}";
    }
}
