package treescrub.spedran.api.request.user;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.user.User;

import java.util.Map;

public class UserRequest extends SingleResourceRequest<User> {
    public UserRequest(String id) {
        super(HttpMethod.GET, "users/{id}", Map.of("id", id));
    }

    @Override
    protected User parse(JSONObject data) {
        return new User(data);
    }
}
