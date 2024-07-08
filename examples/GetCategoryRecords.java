import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.data.Leaderboard;
import com.github.treescrub.spedran.data.LeaderboardRun;
import com.github.treescrub.spedran.data.Run;

import java.time.Duration;
import java.util.List;

class GetCategoryRecords {
    public static void main(String[] args) {
        // Category ID for Twilight Princess Any%
        String categoryId = "z275l4k0";

        // Get all top 3 records for the category
        List<Leaderboard> records = Spedran.getCategoryRecords(categoryId)
                .topPlaces(3)
                .complete()
                .join();

        // Loop through leaderboards and print info for each run
        for(Leaderboard record : records) {
            printRecords(record);
        }

        // Shut down the library to allow the application to exit
        Spedran.shutDown();
    }

    private static void printRecords(Leaderboard leaderboard) {
        for(LeaderboardRun leaderboardRun : leaderboard.getRuns()) {
            Run run = leaderboardRun.getRun();

            // Add extra line before each run
            System.out.println();

            // Convert the place number to a human friendly string and print
            System.out.println(placeToString(leaderboardRun.getPlace()));
            // Print the link to the run
            System.out.println(run.getWeblink());
            // Get the time for the run
            Duration runTime = run.getRunTimes().getPrimaryTime();
            // And print the formatted time
            System.out.println("Run time: " + runTime.toHours() + "h " + runTime.toMinutesPart() + "m " + runTime.toSecondsPart() + "s");
            // If the date of the run is set, print it
            if(run.getDateRan().isPresent()) {
                System.out.println("Date ran: " + run.getDateRan().get());
            }
        }
    }

    private static String placeToString(int place) {
        switch(place) {
            case 1: return "1st";
            case 2: return "2nd";
            case 3: return "3rd";
            default: return place + "th";
        }
    }
}
