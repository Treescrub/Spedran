package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

/**
 *
 */
public class Developer extends IdentifiableNamedResource {

    public Developer(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Developer(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getDeveloper(String)
     */
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Developer[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
