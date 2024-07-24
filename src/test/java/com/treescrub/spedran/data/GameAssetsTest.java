package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameAssetsTest {
    @Test
    void getLogo() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/theme/68q122rp/logo?v=c717a0c", gameAssets.getLogo().getURI());
    }

    @Test
    void getTinyCover() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/game/9dowpe1p/cover?v=7b4712e", gameAssets.getTinyCover().getURI());
    }

    @Test
    void getSmallCover() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/game/9dowpe1p/cover?v=7b4712e", gameAssets.getSmallCover().getURI());
    }

    @Test
    void getMediumCover() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/game/9dowpe1p/cover?v=7b4712e", gameAssets.getMediumCover().getURI());
    }

    @Test
    void getLargeCover() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/game/9dowpe1p/cover?v=7b4712e", gameAssets.getLargeCover().getURI());
    }

    @Test
    void getIcon() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/theme/68q122rp/favicon?v=ad6f2ef", gameAssets.getIcon().getURI());
    }

    @Test
    void getFirstTrophy() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/theme/68q122rp/1st?v=0e9d8ee", gameAssets.getFirstTrophy().getURI());
    }

    @Test
    void getSecondTrophy() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/theme/68q122rp/2nd?v=aa0f425", gameAssets.getSecondTrophy().getURI());
    }

    @Test
    void getThirdTrophy() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertEquals("https://www.speedrun.com/static/theme/68q122rp/3rd?v=38513e4", gameAssets.getThirdTrophy().getURI());
    }

    @Test
    void getFourthTrophy() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertTrue(gameAssets.getFourthTrophy().isEmpty());
    }

    @Test
    void getBackground() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertTrue(gameAssets.getBackground().isPresent());
        assertEquals("https://www.speedrun.com/static/theme/68q122rp/background?v=e461fae", gameAssets.getBackground().get().getURI());
    }

    @Test
    void getForeground() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/gameassets");
        GameAssets gameAssets = new GameAssets(json);

        assertTrue(gameAssets.getForeground().isEmpty());
    }
}