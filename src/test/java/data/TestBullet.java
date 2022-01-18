package data;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestBullet {

    private final Bullet bullet = new Bullet(1,2);

    @Test
    public void testConstructor(){
        assertEquals(1,bullet.getX());
        assertEquals(2,bullet.getY());
    }

    @Test
    public void testLower(){
        int lower = 3;
        bullet.setPosition(bullet.lower());
        int i = bullet.getY();
        assertEquals(lower, i);
    }

    @Test
    public void testRise(){
        int rise = 1;
        bullet.setPosition(bullet.rise());
        int i = bullet.getY();
        assertEquals(rise, i);
    }

    @Test
    public void testBulletSetters(){
        Bullet bullet2 = new Bullet(1,2);

        bullet.setPosition(bullet.lower());
        bullet2.setPosition(bullet2.rise());

        assertEquals(3,bullet.getY());

        assertEquals(1,bullet2.getY());
    }

    @Test
    public void testBulletGetPosition(){
        Position pos = bullet.getPosition();

        assertEquals(pos.getX(),1);
        assertEquals(pos.getY(),2);
    }
}
