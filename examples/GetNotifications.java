import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.data.Link;
import com.treescrub.spedran.data.Notification;
import com.treescrub.spedran.data.NotificationStatus;
import com.treescrub.spedran.data.User;

import java.time.Instant;
import java.util.List;

class GetNotifications {
    public static void main(String[] args) {
        // Set the API key (don't worry, this isn't an actual API key)
        Spedran.setApiKey("fmum0dqfu76xirbig0sdsrwtb3");

        // Get the currently authenticated user
        User authenticatedUser = Spedran.getProfile().join();

        System.out.println("Notifications for " + authenticatedUser.getNames().getInternationalName() + ":");

        // Gets all notifications for the currently authenticated user
        List<Notification> notifications = Spedran.getNotifications().join();

        // Iterate through each notification and print info
        for(Notification notification : notifications) {
            Instant time = notification.getCreationTime();
            NotificationStatus status = notification.getStatus();
            String text = notification.getNotificationText();
            Link link = notification.getItemLink();

            System.out.println(time + " " + (status == NotificationStatus.READ ? "READ" : "UNREAD") + ": " + text + " (" + link.getURI() + ")");
        }

        // Shut down the library to allow the application to exit
        Spedran.shutDown();
    }
}
