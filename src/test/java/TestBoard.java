import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Test;
import com.googlecode.lanterna.input.KeyType;


import java.security.Key;

import static com.googlecode.lanterna.input.KeyType.*;
import static org.junit.Assert.*;

public class TestBoard {
    @Test
    public void testBoardConstructor(){
        Board board = new Board(100,50);
        assertEquals(100, board.getWidth());
        assertEquals(50, board.getHeight());
    }

    @Test
    public void testProcessKeyLeft(){
        KeyStroke key = new KeyStroke(ArrowLeft);
        Board board = new Board(100,50);
        board.processKey(key);
        Position pos = new Position(48,50);
        assertEquals(pos.getX(), board.getShipX());
    }

    @Test
    public void testProcessKeyRight(){
        KeyStroke key = new KeyStroke(ArrowRight);
        Board board = new Board(100,50);
        board.processKey(key);
        Position pos = new Position(50,50);
        assertEquals(pos.getX(), board.getShipX());
    }
    
    @Test
    public void testProcessKeyRandom(){
        KeyStroke key = new KeyStroke(ArrowUp);
        Board board = new Board(100,50);
        board.processKey(key);
        Position pos = new Position(49,50);
        assertEquals(pos.getX(), board.getShipX());
    }

    @Test
    public void testMoveShip(){
        Board board = new Board(100,50);
        Ship ship = new Ship(49, 40);
        Position pos = new Position(50, 40);
        board.moveShip(pos);
        assertEquals(pos.getX(), board.getShipX());
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
    
    @Test
    public void testMoveAlienDown() {
        Board board = new Board(100,50);
        assertTrue(board.getMove());
        board.moveAlienDown();
        assertFalse(board.getMove());
        board.moveAlienDown();
        assertTrue(board.getMove());
    }
}
