package treescrub.spedran.api;

import treescrub.spedran.data.*;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.user.User;
import treescrub.spedran.requests.Requests;

public class Spedran {
    private static final int MAX_ITEMS = 200;
    private static final int MAX_ITEMS_BULK = 1000;

    public static Game getGame(String id) {
        return new Game(Requests.getGame(id).join());
    }

    public static Run getRun(String id) {
        return new Run(Requests.getRun(id).join());
    }

    public static Category getCategory(String id) {
        return new Category(Requests.getCategory(id).join());
    }

    public static Level getLevel(String id) {
        return new Level(Requests.getLevel(id).join());
    }

    public static Variables getVariable(String id) {
        return new Variables(Requests.getVariable(id).join());
    }

    public static User getUser(String id) {
        return new User(Requests.getUser(id).join());
    }

    public static Guest getGuest(String name) {
        return new Guest(Requests.getGuest(name).join());
    }

    public static Genre getGenre(String id) {
        return new Genre(Requests.getGenre(id).join());
    }

    public static Engine getEngine(String id) {
        return new Engine(Requests.getEngine(id).join());
    }

    public static Gametype getGametype(String id) {
        return new Gametype(Requests.getGametype(id).join());
    }

    public static Developer getDeveloper(String id) {
        return new Developer(Requests.getDeveloper(id).join());
    }

    public static Region getRegion(String id) {
        return new Region(Requests.getRegion(id).join());
    }

    public static Series getSeries(String id) {
        return new Series(Requests.getSeries(id).join());
    }

    public static Platform getPlatform(String id) {
        return new Platform(Requests.getPlatform(id).join());
    }
}
