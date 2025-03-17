package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.Notification;
import com.treescrub.spedran.data.User;
import kong.unirest.HttpMethod;

/**
 * A request builder to get the {@link Notification}s of the authenticated {@link User}.
 */
public class NotificationsRequest extends ResourceCollectionRequest<Notification> {
    @SuppressWarnings("unused")
    protected NotificationsRequest() {
        super(HttpMethod.GET, "notifications");
    }

    /**
     * Creates and returns a new {@code NotificationsRequest} builder.
     *
     * @return a {@code NotificationsRequest} builder
     */
    public static NotificationsRequest create() {
        return new NotificationsRequest();
    }

    @Override
    protected Class<Notification> getDataClass() {
        return Notification.class;
    }
}
