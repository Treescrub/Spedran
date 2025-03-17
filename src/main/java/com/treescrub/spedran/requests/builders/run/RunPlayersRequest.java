package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.requests.InvalidBuilderStateException;
import com.treescrub.spedran.ModifyResourceRequest;
import com.treescrub.spedran.data.Guest;
import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.data.User;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A request builder to set the players that participated in a {@link Run}.
 * <br>
 * Players will maintain the order that they were added.
 * <br>
 * Duplicate users/guests will be ignored.
 */
public class RunPlayersRequest extends ModifyResourceRequest<Run> {
    private final Map<String, String> runPlayers;

    @SuppressWarnings("unused")
    protected RunPlayersRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/players", Map.of("id", id));

        runPlayers = new LinkedHashMap<>();
    }

    /**
     * Creates and returns a new {@code RunPlayersRequest} builder.
     *
     * @param run the run to edit the players of
     * @return a {@code RunPlayersRequest} builder
     */
    public static RunPlayersRequest create(Run run) {
        checkResource(run, "run");

        return new RunPlayersRequest(run.getId());
    }

    /**
     * Creates and returns a new {@code RunPlayersRequest} builder.
     *
     * @param id the run to edit the players of
     * @return a {@code RunPlayersRequest} builder
     */
    public static RunPlayersRequest create(String id) {
        checkId(id);

        return new RunPlayersRequest(id);
    }

    /**
     * Adds a {@link User} to the players that will be set on the {@link Run}.
     *
     * @param user the user to add to the list of players
     * @return this builder object
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
