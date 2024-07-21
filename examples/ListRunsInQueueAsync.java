import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.data.SubmissionStatus;

class ListRunsInQueueAsync {
    public static void main(String[] args) {
        String gameAbbreviation = "celeste";

        // Get the game using the abbreviation
        Spedran.getGame(gameAbbreviation).thenAcceptAsync(game -> {
            // Get a list of new runs, sorted by the submission time
            Spedran.getRuns()
                    .game(game)
                    .status(SubmissionStatus.NEW)
                    .sortBySubmissionDate()
                    .complete().thenAccept(runsInQueue -> {
                        // Print the link to each run in the game's verification queue
                        for(Run run : runsInQueue) {
                            System.out.println(run.getWeblink());
                        }

                        // Shut down the library to allow the application to exit
                        Spedran.shutDown();
                    });
        });
    }
}
