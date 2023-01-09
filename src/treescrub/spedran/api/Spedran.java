package treescrub.spedran.api;

import treescrub.spedran.data.*;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.user.User;
import treescrub.spedran.data.variables.Variable;
import treescrub.spedran.requests.Requests;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Spedran {
    public static CompletableFuture<Game> getGame(String id) {
        return Requests.getGame(id);
    }

    public static CompletableFuture<Run> getRun(String id) {
        return Requests.getRun(id);
    }

    public static CompletableFuture<List<Run>> getRuns(Map<String, Object> parameters) {
        return Requests.getRuns(parameters);
    }

    public static CompletableFuture<Category> getCategory(String id) {
        return Requests.getCategory(id);
    }

    public static CompletableFuture<Level> getLevel(String id) {
        return Requests.getLevel(id);
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        return Requests.getVariable(id);
    }

    public static CompletableFuture<User> getUser(String id) {
        return Requests.getUser(id);
    }

    public static CompletableFuture<Guest> getGuest(String name) {
        return Requests.getGuest(name);
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        return Requests.getGenre(id);
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        return Requests.getEngine(id);
    }

    public static CompletableFuture<Gametype> getGametype(String id) {
        return Requests.getGametype(id);
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        return Requests.getDeveloper(id);
    }

    public static CompletableFuture<Region> getRegion(String id) {
        return Requests.getRegion(id);
    }

    public static CompletableFuture<Series> getSeries(String id) {
        return Requests.getSeries(id);
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        return Requests.getPlatform(id);
    }
}
