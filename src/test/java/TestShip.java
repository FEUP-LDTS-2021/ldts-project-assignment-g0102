import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestShip {
    @Test
    public void TestShipConstructor() {
        Ship ship = new Ship(1,2);
        Assertions.assertEquals(1,ship.getX());
        Assertions.assertEquals(2,ship.getY());
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
        Assertions.assertEquals(20,ship.getX());
        Assertions.assertEquals(40,ship.getY());
    }

    @Test
    public void TestShipMoveLeft() {
        //given
        Ship ship = new Ship(20, 30);
        Ship shipMoved = new Ship(19,30);
        //when
        Position pos = ship.moveLeft();
        //then
        Assertions.assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipMoveRight() {
        //given
        Ship ship = new Ship(20, 30);
        Ship shipMoved = new Ship(21,30);
        //when
        Position pos = ship.moveRight();
        //then
        Assertions.assertEquals(pos.getX(),shipMoved.getX());
    }

    @Test
    public void TestShipStand() {
        //given
        Ship ship = new Ship(20,30);
        // when
        Position pos = ship.Stand();
        //then
        Assertions.assertEquals(ship.getX(),pos.getX());
        Assertions.assertEquals(ship.getY(),pos.getY());
    }

    @Test
    public void TestShipSetPosition()  {
        //given
        Ship ship = new Ship(10,10);
        Position pos = new Position(20,20);
        //when
        ship.setPosition(pos);
        //then
        Assertions.assertEquals(pos.getX(),ship.getX());
        Assertions.assertEquals(pos.getY(),ship.getY());
    }
}
