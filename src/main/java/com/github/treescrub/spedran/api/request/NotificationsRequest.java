package com.github.treescrub.spedran.api.request;

import com.github.treescrub.spedran.data.notification.Notification;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;

import java.util.function.Function;

public class NotificationsRequest extends ResourceCollectionRequest<Notification> {
    public NotificationsRequest() {
        super(HttpMethod.GET, "notifications");
    }

    @Override
    protected Function<JSONObject, Notification> getConstructor() {
        return Notification::new;
    }
}
