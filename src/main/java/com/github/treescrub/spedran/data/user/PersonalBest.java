package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.Resource;
import com.github.treescrub.spedran.data.run.Run;

/**
 *
 */
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

    /**
     *
     * @return
     */
    public int getPlace() {
        return place;
    }

    /**
     *
     * @return
     */
    public Run getRun() {
        return run;
    }
}
