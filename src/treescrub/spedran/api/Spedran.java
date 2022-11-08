package treescrub.spedran.api;

import treescrub.spedran.data.*;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.user.User;
import treescrub.spedran.data.variables.Variable;
import treescrub.spedran.requests.Requests;

import java.util.concurrent.CompletableFuture;

public class Spedran {
    public static CompletableFuture<Game> getGame(String id) {
        return Requests.getGame(id).thenCompose(data -> CompletableFuture.completedFuture(new Game(data)));
    }

    public static CompletableFuture<Run> getRun(String id) {
        return Requests.getRun(id).thenCompose(data -> CompletableFuture.completedFuture(new Run(data)));
    }

    public static CompletableFuture<Category> getCategory(String id) {
        return Requests.getCategory(id).thenCompose(data -> CompletableFuture.completedFuture(new Category(data)));
    }

    public static CompletableFuture<Level> getLevel(String id) {
        return Requests.getLevel(id).thenCompose(data -> CompletableFuture.completedFuture(new Level(data)));
    }

    public static CompletableFuture<Variable> getVariable(String id) {
        return Requests.getVariable(id).thenCompose(data -> CompletableFuture.completedFuture(new Variable(data)));
    }

    public static CompletableFuture<User> getUser(String id) {
        return Requests.getUser(id).thenCompose(data -> CompletableFuture.completedFuture(new User(data)));
    }

    public static CompletableFuture<Guest> getGuest(String name) {
        return Requests.getGuest(name).thenCompose(data -> CompletableFuture.completedFuture(new Guest(data)));
    }

    public static CompletableFuture<Genre> getGenre(String id) {
        return Requests.getGenre(id).thenCompose(data -> CompletableFuture.completedFuture(new Genre(data)));
    }

    public static CompletableFuture<Engine> getEngine(String id) {
        return Requests.getEngine(id).thenCompose(data -> CompletableFuture.completedFuture(new Engine(data)));
    }

    public static CompletableFuture<Gametype> getGametype(String id) {
        return Requests.getGametype(id).thenCompose(data -> CompletableFuture.completedFuture(new Gametype(data)));
    }

    public static CompletableFuture<Developer> getDeveloper(String id) {
        return Requests.getDeveloper(id).thenCompose(data -> CompletableFuture.completedFuture(new Developer(data)));
    }

    public static CompletableFuture<Region> getRegion(String id) {
        return Requests.getRegion(id).thenCompose(data -> CompletableFuture.completedFuture(new Region(data)));
    }

    public static CompletableFuture<Series> getSeries(String id) {
        return Requests.getSeries(id).thenCompose(data -> CompletableFuture.completedFuture(new Series(data)));
    }

    public static CompletableFuture<Platform> getPlatform(String id) {
        return Requests.getPlatform(id).thenCompose(data -> CompletableFuture.completedFuture(new Platform(data)));
    }
}
