import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestBoard {
    @Test
    public void testBoardConstructor(){
        Board board = new Board(100,50);
        assertEquals(100, board.getWidth());
        assertEquals(50, board.getHeight());
    }

    @Test
    public void testProcessKey(){
        
    }

    @Test
    public void testMoveShip(){
        Board board = new Board(100,50);
        Ship ship = new Ship(49, 40);
        Position pos = new Position(50, 40);
        board.moveShip(pos);
        assertEquals(pos.getX(), ship.getX());
    }

    @Test
    public void testCanShipMoveRight(){
        Board board = new Board(100,50);
        Position pos = new Position(99, 40);
        assertEquals(false, board.canShipMove(pos));
    }

    @Test
    public void testCanShipMoveLeft(){
        Board board = new Board(100,50);
        Position pos = new Position(1, 40);
        assertEquals(false, board.canShipMove(pos));
    }

    @Test
    public void testCanShipMoveTrue(){
        Board board = new Board(100,50);
        Position pos = new Position(49, 40);
        assertEquals(true, board.canShipMove(pos));
    }
}
