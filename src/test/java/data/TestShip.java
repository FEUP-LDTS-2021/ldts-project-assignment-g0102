package data;

import data.Position;
import data.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestShip {

    private final Ship ship = new Ship(1,2);

    @Test
    public void TestShipConstructor() {
        assertEquals(1,ship.getX());
        assertEquals(2,ship.getY());
    }

    @Test
    public void TestShipSetters() {
        int shipsetX = 20;
        int shipsetY = 40;
        ship.setX(shipsetX);
        ship.setY(shipsetY);
        assertEquals(20,ship.getX());
        assertEquals(40,ship.getY());
    }

    @Test
    public void TestShipMoveLeft() {
        Ship shipMoved = new Ship(0,2);
        Position pos = ship.moveLeft();
        assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipMoveRight() {
        Ship shipMoved = new Ship(2,2);
        Position pos = ship.moveRight();
        assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipStand() {
        Ship shipMoved = new Ship(1,2);
        Position pos = shipMoved.Stand();
        assertEquals(pos.getX(),shipMoved.getX());
        assertEquals(pos.getY(),shipMoved.getY());
    }
}
