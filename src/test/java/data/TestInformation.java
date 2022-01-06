package data;

import data.Information;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestInformation {
    @Test
    public void testInformationConstructor(){
        Information info = new Information(0,3, 1);
        assertEquals(0,info.getScore());
        assertEquals(3,info.getLives());
        assertEquals(1,info.getLevel());
    }

    @Test
    public void testGetLives() {
        Information info = new Information(0,3,1);
        int lives = info.getLives();
        assertEquals(3,lives);
    }

    @Test
    public void testGetScore() {
        Information info = new Information(0,3,1);
        int score = info.getScore();
        assertEquals(0,score);
    }

    @Test
    public void testGetLevel() {
        Information info = new Information(0,3,1);
        int level = info.getLevel();
        assertEquals(1,level);
    }

    @Test
    public void testLevelUp(){
        Information info = new Information(0,3, 1);
        int level_up = 2;
        info.levelUp();
        int i = info.getLevel();
        assertEquals(level_up, i);
    }

    @Test
    public void testScoreUp(){
        Information info = new Information(0,3, 1);
        int score_up = 100;
        info.scoreUp();
        int i = info.getScore();
        assertEquals(score_up, i);
    }

    @Test
    public void testLiveHit(){
        Information info = new Information(0,3, 1);
        int live_hit = 2;
        info.liveHit();
        int i = info.getLives();
        assertEquals(live_hit, i);
    }
}
