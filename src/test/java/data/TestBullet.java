package data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBullet {
    @Test
    public void testBulletConstructor(){
        Bullet bullet = new Bullet(1,2);
        assertEquals(1,bullet.getX());
        assertEquals(2,bullet.getY());
    }

    @Test
    public void testLower(){
        Bullet bullet = new Bullet(1,2);
        int lower = 3;
        bullet.setPosition(bullet.lower());
        int i = bullet.getY();
        assertEquals(lower, i);
    }

    @Test
    public void testRise(){
        Bullet bullet = new Bullet(1,2);
        int rise = 1;
        bullet.setPosition(bullet.rise());
        int i = bullet.getY();
        assertEquals(rise, i);
    }

    @Test
    public void testBulletSetters(){
        Bullet bullet1 = new Bullet(1,2);
        Bullet bullet2 = new Bullet(1,2);

        bullet1.setPosition(bullet1.lower());
        bullet2.setPosition(bullet2.rise());

        assertEquals(3,bullet1.getY());

        assertEquals(1,bullet2.getY());
    }

    @Test
    public void testBulletGetPosition(){
        Bullet bullet = new Bullet(1,2);
        Position pos = bullet.getPosition();

        assertEquals(pos.getX(),1);
        assertEquals(pos.getY(),2);
    }
}
