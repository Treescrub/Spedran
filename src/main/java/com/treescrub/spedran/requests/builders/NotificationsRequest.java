package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Notification;
import com.treescrub.spedran.data.User;
import com.treescrub.spedran.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

/**
 * A request builder to get the {@link Notification}s of the authenticated {@link User}.
 */
public class NotificationsRequest extends ResourceCollectionRequest<Notification> {
    @SuppressWarnings("unused")
    public NotificationsRequest() {
        super(HttpMethod.GET, "notifications");
    }

    @Override
    protected Class<Notification> getDataClass() {
        return Notification.class;
    }
}
