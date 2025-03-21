package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Guest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Guest}.
 */
public class GuestRequest extends SingleResourceRequest<Guest> {
    @SuppressWarnings("unused")
    protected GuestRequest(String name) {
        super(HttpMethod.GET, "guests/{name}", Map.of("name", name));
    }

    /**
     * Creates and returns a new {@code GuestRequest} builder.
     *
     * @param name the name of the guest to get
     * @return a {@code GuestRequest} builder
     */
    public static GuestRequest create(String name) {
        if(name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if(name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }

        return new GuestRequest(name);
    }

    @Override
    protected Class<Guest> getDataClass() {
        return Guest.class;
    }
}
