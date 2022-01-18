package data;

import data.Position;
import data.Wall;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestWall {

    private final Wall wall = new Wall(100,50);

    @Test
    public void TestWallConstructor() {
        assertEquals(100,wall.getPosition().getX());
        assertEquals(50,wall.getPosition().getY());
    }

    @Test
    public void TestWallGetPosition() {
        Position pos = wall.getPosition();
        assertEquals(wall.getPosition().getX(),pos.getX());
        assertEquals(wall.getPosition().getY(),pos.getY());
    }
}
