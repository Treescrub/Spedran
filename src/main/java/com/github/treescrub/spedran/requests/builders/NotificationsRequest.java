package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Notification;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

public class NotificationsRequest extends ResourceCollectionRequest<Notification> {
    public NotificationsRequest() {
        super(HttpMethod.GET, "notifications");
    }

    @Override
    protected Class<Notification> getDataClass() {
        return Notification.class;
    }
}