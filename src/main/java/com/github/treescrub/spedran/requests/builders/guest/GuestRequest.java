package com.github.treescrub.spedran.requests.builders.guest;

import com.github.treescrub.spedran.data.Guest;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class GuestRequest extends SingleResourceRequest<Guest> {
    public GuestRequest(String name) {
        super(HttpMethod.GET, "guests/{name}", Map.of("name", name));
    }

    @Override
    protected Class<Guest> getDataClass() {
        return Guest.class;
    }
}
