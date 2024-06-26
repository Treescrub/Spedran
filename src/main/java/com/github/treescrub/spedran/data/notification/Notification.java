package com.github.treescrub.spedran.data.notification;

import com.github.treescrub.spedran.data.IdentifiableResource;
import com.github.treescrub.spedran.data.Link;
import kong.unirest.json.JSONObject;

import java.time.Instant;

public class Notification extends IdentifiableResource {
    private final Instant creationTime;
    private final NotificationStatus status;
    private final String notificationText;
    private final Link itemLink;

    public Notification(JSONObject data) {
        super(data);

        creationTime = Instant.parse(data.getString("created"));
        status = NotificationStatus.valueOf(data.getString("status").toUpperCase());
        notificationText = data.getString("text");
        itemLink = new Link(data.getJSONObject("item"));
    }

    /**
     * Gets the {@link Instant} that the notification was created.
     *
     * @return an {@code Instant} with the time of notification creation
     */
    public Instant getCreationTime() {
        return creationTime;
    }

    /**
     * Gets the current {@link NotificationStatus} of the notification.
     *
     * @return a {@code NotificationStatus}
     */
    public NotificationStatus getStatus() {
        return status;
    }

    /**
     * Gets the text of the notification.
     *
     * @return a {@code String} with the text
     */
    public String getNotificationText() {
        return notificationText;
    }

    /**
     * Gets a {@link Link} with the type of notification and URL of the relevant page.
     * <br><br>
     * {@link Link#getRelation()} will be one of:
     * <ul>
     *    <li>{@code "post"} - Forum post created, a user liked a forum post, or a user commented on a run</li>
     *    <li>{@code "run"} - New run for verification, a run status changed, or a user beat WR</li>
     *    <li>{@code "game"} - Game request approved or denied</li>
     *    <li>{@code "guide"} - Guide posted or updated</li>
     *    <li>{@code "thread"} - Created new forum thread</li>
     *    <li>An empty {@code Optional} - News post created (possibly other scenarios)</li>
     * </ul>
     *
     * @return a {@code Link} for the relevant page
     */
    public Link getItemLink() {
        return itemLink;
    }
}