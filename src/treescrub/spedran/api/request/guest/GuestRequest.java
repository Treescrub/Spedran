package treescrub.spedran.api.request.guest;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Guest;

import java.util.Map;

public class GuestRequest extends SingleResourceRequest<Guest> {
    public GuestRequest(String name) {
        super(HttpMethod.GET, "guests/{name}", Map.of("name", name));
    }

    @Override
    protected Guest parse(JSONObject data) {
        return new Guest(data);
    }
}
