package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Guest;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Guest}.
 */
public class GuestRequest extends SingleResourceRequest<Guest> {
    @SuppressWarnings("unused")
    public GuestRequest(String name) {
        super(HttpMethod.GET, "guests/{name}", Map.of("name", name));
    }

    @Override
    protected Class<Guest> getDataClass() {
        return Guest.class;
    }
}
