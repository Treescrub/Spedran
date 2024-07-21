package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

import java.util.Objects;

/**
 * A guest runner.
 * Can be entered as a runner in a run by other users, but has no account.
 * <br><br>
 * This class is immutable and thread-safe.
 */
@SuppressWarnings("unused")
public class Guest extends Resource {
    private final String name;

    Guest(JSONObject data) {
        super(data);

        name = data.getString("name");
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all the runs that this guest participated in.
     *
     * @return a {@code RunsRequest} builder
     */
    public RunsRequest getRuns() {
        return Spedran.getRuns().guest(this);
    }

    /**
     * Gets the username for this guest.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return name.equals(guest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                "}";
    }
}
