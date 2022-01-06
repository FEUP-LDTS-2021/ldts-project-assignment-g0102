package data;

import data.Position;
import data.Wall;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestWall {
    @Test
    public void TestWallConstructor() {
        Wall wall= new Wall(100,50);
        assertEquals(100,wall.getPosition().getX());
        assertEquals(50,wall.getPosition().getY());
    }

    @Test
    public void TestWallGetPosition() {
        Wall wall = new Wall(10,20);
        Position pos = wall.getPosition();
        assertEquals(wall.getPosition().getX(),pos.getX());
        assertEquals(wall.getPosition().getY(),pos.getY());
    }
}
