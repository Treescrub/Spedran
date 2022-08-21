import treescrub.spedran.data.Game;
import treescrub.spedran.requests.Requests;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Test {
    public static void main(String[] args) {
        Unirest.config().defaultBaseUrl("https://www.speedrun.com/api/v1");

        HttpResponse<JsonNode> response = Requests.getGame("9dowpe1p").join();

        Game game = new Game(response.getBody().getObject().getJSONObject("data"));

        System.out.println(game);
        System.out.println(game.getReleaseDate().get());
        System.out.println(game.getDiscordLink().orElse(null));

        Unirest.shutDown();
    }
}
