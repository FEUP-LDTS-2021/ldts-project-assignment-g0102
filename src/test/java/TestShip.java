import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestShip {
    @Test
    public void TestShipConstructor() {
        Ship ship = new Ship(1,2);
        assertEquals(1,ship.getX());
        assertEquals(2,ship.getY());
    }

    @Test
    public void TestShipSetters() {
        //given
        Ship ship = new Ship(1,1);
        int shipsetX = 20;
        int shipsetY = 40;
        //when
        ship.setX(shipsetX);
        ship.setY(shipsetY);
        //then
        assertEquals(20,ship.getX());
        assertEquals(40,ship.getY());
    }
    //nao sei como fazer este teste
    @Test
    public void TestShipMoveLeft() {
        //given
        Ship ship = new Ship(20, 30);
        Ship shipMoved = new Ship(19,30);
        //when
        Position pos = ship.moveLeft();
        //then
        assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipMoveRight() {
        //given
        Ship ship = new Ship(20, 30);
        Ship shipMoved = new Ship(21,30);
        //when
        Position pos = ship.moveRight();
        //then
        assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipStand() {
        //given
        Ship ship = new Ship(20, 30);
        Ship shipMoved = new Ship(20,30);
        //when
        Position pos = shipMoved.Stand();
        //then
        assertEquals(pos.getX(),shipMoved.getX());
        assertEquals(pos.getY(),shipMoved.getY());
    }
}
