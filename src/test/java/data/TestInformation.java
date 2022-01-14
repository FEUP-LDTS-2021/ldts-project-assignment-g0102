package data;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestInformation {
    
    private final Information info = new Information(0,3,1,1,5);
    
    @Test
    public void testInformationConstructor(){
        assertEquals(0,info.getScore());
        assertEquals(3,info.getLives());
        assertEquals(1,info.getLevel());
        assertEquals(1,info.getShipBullet());
        assertEquals(5,info.getAlienbullet());
    }

    @Test
    public void testGetLives() {
        int lives = info.getLives();
        assertEquals(3,lives);
    }

    @Test
    public void testGetScore() {
        int score = info.getScore();
        assertEquals(0,score);
    }

    @Test
    public void testGetLevel() {
        int level = info.getLevel();
        assertEquals(1,level);
    }
    
    @Test
    public void testGetBullet() {
        int bullet = info.getShipBullet();
        assertEquals(1,bullet);
    }
    
    @Test
    public void testLevelUp(){
        assertEquals(1, info.getLevel());
        assertEquals(1, info.getShipBullet());
        assertEquals(5, info.getAlienbullet());
        info.levelUp();
        assertEquals(2, info.getLevel());
        assertEquals(2, info.getShipBullet());
        assertEquals(7, info.getAlienbullet());
    }

    @Test
    public void testScoreUp(){
        assertEquals(0,info.getScore());
        info.scoreUp();
        assertEquals(100,info.getScore());
    }
    
    @Test
    public void testLiveHit(){
        assertEquals(3,info.getLives());
        info.liveHit();
        assertEquals(2,info.getLives());
    }
}
