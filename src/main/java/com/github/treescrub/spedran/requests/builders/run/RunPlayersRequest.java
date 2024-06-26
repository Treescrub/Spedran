package com.github.treescrub.spedran.requests.builders.run;

import com.github.treescrub.spedran.requests.InvalidBuilderStateException;
import com.github.treescrub.spedran.requests.ModifyResourceRequest;
import com.github.treescrub.spedran.data.Guest;
import com.github.treescrub.spedran.data.Run;
import com.github.treescrub.spedran.data.User;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A builder to set the players that participated in a {@link Run}.
 * <br>
 * Players will maintain the order that they were added.
 * <br>
 * Duplicate users/guests will be ignored.
 */
public class RunPlayersRequest extends ModifyResourceRequest<Run> {
    private final Map<String, String> runPlayers;

    public RunPlayersRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/players", Map.of("id", id));

        runPlayers = new LinkedHashMap<>();
    }

    public RunPlayersRequest(Run run) {
        this(run.getId());
    }

    /**
     * Adds a {@link User} to the players that will be set on the {@link Run}.
     *
     * @param user the user to add to the list of players
     * @return this builder object
     */
    public RunPlayersRequest addUser(User user) {
        return addUser(user.getId());
    }

    /**
     * Adds a {@link User} to the players that will be set on the {@link Run}.
     *
     * @param userId the ID of the user to add to the list of players
     * @return this builder object
     */
    public RunPlayersRequest addUser(String userId) {
        runPlayers.put(userId, "user");

        return this;
    }

    /**
     * Adds a {@link Guest} to the players that will be set on the {@link Run}.
     *
     * @param guest the guest to add to the list of players
     * @return this builder object
     */
    public RunPlayersRequest addGuest(Guest guest) {
        return addGuest(guest.getName());
    }

    /**
     * Adds a {@link Guest} to the players that will be set on the {@link Run}.
     *
     * @param guestName the name of the guest to add to the list of players
     * @return this builder object
     */
    public RunPlayersRequest addGuest(String guestName) {
        runPlayers.put(guestName, "guest");

        return this;
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    @Override
    protected JSONElement buildBody() throws InvalidBuilderStateException {
        if(runPlayers.isEmpty()) {
            throw new InvalidBuilderStateException("At least one player must be set");
        }
        if(runPlayers.size() > 20) {
            throw new InvalidBuilderStateException("Exceeded max number of players (20)");
        }

        JSONArray playersNode = new JSONArray();
        for(Map.Entry<String, String> entry : runPlayers.entrySet()) {
            JSONObject playerNode = new JSONObject();

            String id = entry.getKey();
            String type = entry.getValue();

            playerNode.put("rel", type);

            String idKeyName;
            if(type.equals("user")) {
                idKeyName = "id";
            } else {
                idKeyName = "name";
            }

            playerNode.put(idKeyName, id);
            playersNode.put(playerNode);
        }

        JSONObject rootNode = new JSONObject();
        rootNode.put("players", playersNode);

        return rootNode;
    }
}
