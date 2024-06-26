package com.github.treescrub.spedran.requests.builders.guest;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Guest;

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
