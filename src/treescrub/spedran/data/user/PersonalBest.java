package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Resource;
import treescrub.spedran.data.run.Run;

public class PersonalBest extends Resource {
    private int place;
    private Run run;

    public PersonalBest(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        place = data.getInt("place");
        run = new Run(data.getJSONObject("run"));
    }

    public int getPlace() {
        return place;
    }

    public Run getRun() {
        return run;
    }
}
