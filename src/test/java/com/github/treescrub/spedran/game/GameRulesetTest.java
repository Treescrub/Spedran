package com.github.treescrub.spedran.game;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.game.GameRuleset;
import com.github.treescrub.spedran.data.run.TimingType;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesetTest {

    @Test
    void areMillisecondsShown() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertTrue(ruleset.areMillisecondsShown());
    }

    @Test
    void isVerificationRequired() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertTrue(ruleset.isVerificationRequired());
    }

    @Test
    void isVideoRequired() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertTrue(ruleset.isVideoRequired());
    }

    @Test
    void areEmulatorsAllowed() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertFalse(ruleset.areEmulatorsAllowed());
    }

    @Test
    void getRunTimes() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertTrue(ruleset.getRunTimes().contains(TimingType.REALTIME));
    }

    @Test
    void getDefaultTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertEquals(TimingType.REALTIME, ruleset.getDefaultTime());
    }
}