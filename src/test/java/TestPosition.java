import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestPosition {
    @Test
    public void testPositionConstructor() {
        Position pos = new Position(10,-8);
        assertEquals(10,pos.getX());
        assertEquals(-8,pos.getY());
    }

    @Test
    public void testGetX() {
        //given
        Position pos = new Position(1,2);
        //when
        int result = 1;
        int a = pos.getX();
        //then
        assertEquals(result,a);
    }

    @Test
    public void testGetY() {
        //given
        Position pos = new Position(1,2);
        //when
        int result = 2;
        int a = pos.getY();
        //then
        assertEquals(result,a);
    }

    @Test
    public void testSetX() {
        //given
        Position pos = new Position(1,2);
        int tosetX = 2;
        //when
        pos.setX(tosetX);
        int result = pos.getX();
        //then
        assertEquals(result,tosetX);
    }

    @Test
    public void testSetY() {
        //given
        Position pos = new Position(1,1);
        int tosetY = 2;
        //when
        pos.setY(tosetY);
        int result = pos.getY();
        //then
        assertEquals(result,tosetY);
    }
}
