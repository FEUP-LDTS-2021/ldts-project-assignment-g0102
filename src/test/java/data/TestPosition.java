package data;

import data.Position;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestPosition {

    private final Position pos = new Position(1,2);

    @Test
    public void testPositionConstructor() {
        assertEquals(1,pos.getX());
        assertEquals(2,pos.getY());
    }

    @Test
    public void testGetX() {
        int result = 1;
        int a = pos.getX();
        assertEquals(result,a);
    }

    @Test
    public void testGetY() {
        int result = 2;
        int a = pos.getY();
        assertEquals(result,a);
    }

    @Test
    public void testSetX() {
        int tosetX = 2;
        pos.setX(tosetX);
        int result = pos.getX();
        assertEquals(result,tosetX);
    }

    @Test
    public void testSetY() {
        int tosetY = 2;
        pos.setY(tosetY);
        int result = pos.getY();
        assertEquals(result,tosetY);
    }
}
