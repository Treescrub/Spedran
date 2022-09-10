import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import treescrub.spedran.api.Spedran;
import treescrub.spedran.data.Game;
import treescrub.spedran.requests.Requests;

public class Test {
    public static void main(String[] args) {
        Unirest.config().defaultBaseUrl("https://www.speedrun.com/api/v1");

        HttpResponse<JsonNode> response = Requests.getGame("9dowpe1p").join();

        Game game = new Game(response.getBody().getObject().getJSONObject("data"));

        System.out.println(game);
        System.out.println(game.getReleaseDate().get());
        System.out.println(game.getDiscordLink().orElse(null));

        response = Unirest.get("/{resource}/{id}")
                .routeParam("resource", "runs")
                .routeParam("id", "yvrk7voz")
                .queryString("embed", "gam")
                .asJsonAsync().join();

        System.out.println(response.getBody().getObject().getJSONObject("data").get("game") instanceof String);

        System.out.println(Spedran.getLevel("5d77z5dy").getWeblink());

        Unirest.shutDown();
    }
}
