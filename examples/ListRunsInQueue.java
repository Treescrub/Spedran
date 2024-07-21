import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.data.SubmissionStatus;

import java.util.List;

class ListRunsInQueue {
    public static void main(String[] args) {
        String gameAbbreviation = "celeste";

        // Get the game using the abbreviation
        Game game = Spedran.getGame(gameAbbreviation).join();

        // Get a list of new runs, sorted by the submission time
        List<Run> runsInQueue = Spedran.getRuns()
                .game(game)
                .status(SubmissionStatus.NEW)
                .sortBySubmissionDate()
                .complete()
                .join();

        // Print the link to each run in the game's verification queue
        for(Run run : runsInQueue) {
            System.out.println(run.getWeblink());
        }

        // Shut down the library to allow the application to exit
        Spedran.shutDown();
    }
}
