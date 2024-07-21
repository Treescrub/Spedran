package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
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
        assertThrows(UnsupportedOperationException.class, () -> ruleset.getRunTimes().clear());
    }

    @Test
    void getDefaultTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameruleset");
        GameRuleset ruleset = new GameRuleset(json);

        assertEquals(TimingType.REALTIME, ruleset.getDefaultTime());
    }
}