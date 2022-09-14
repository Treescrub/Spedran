package treescrub.spedran.api;

import treescrub.spedran.data.*;
import treescrub.spedran.requests.Requests;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Spedran {
    private static final int MAX_ITEMS = 200;
    private static final int MAX_ITEMS_BULK = 1000;

    public static Game getGame(String id) {
        return new Game(Requests.getGame(id).join());
    }

    public List<Game> getGames() {
        return getGames(MAX_ITEMS);
    }

    public List<Game> getGames(boolean isBulk) {
        return getGames(isBulk ? MAX_ITEMS_BULK : MAX_ITEMS);
    }

    public List<Game> getGames(int size) {
        return getGames(size, false);
    }

    public List<Game> getGames(int size, boolean isBulk) {
        return null;
    }

    public static Run getRun(String id) {
        return new Run(Requests.getRun(id).join());
    }

    public static Category getCategory(String id) {
        return new Category(Requests.getCategory(id).join());
    }

    public List<Category> getCategories(String gameId) {
        return null;
    }

    public static Level getLevel(String id) {
        return new Level(Requests.getLevel(id).join());
    }

    public List<Level> getLevels(String gameId) {
        return null;
    }

    public static Variables getVariable(String id) {
        return new Variables(Requests.getVariable(id).join());
    }

    public User getUser(String id) {
        return getUserAsync(id).join();
    }

    public CompletableFuture<User> getUserAsync(String id) {
        return null;
    }

    public List<Run> getLeaderboards() {
        return null;
    }

    public Guest getGuest(String name) {
        return null;
    }

    public Genre getGenre(String id) {
        return null;
    }

    public Gametype getGametype(String id) {
        return null;
    }

    public Engine getEngine(String id) {
        return null;
    }

    public Developer getDeveloper(String id) {
        return null;
    }
}
