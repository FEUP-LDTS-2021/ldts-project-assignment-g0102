package data;

import com.googlecode.lanterna.input.KeyStroke;
import gui.stages.Board;
import org.junit.jupiter.api.Test;

import static com.googlecode.lanterna.input.KeyType.*;
import static org.junit.Assert.*;

public class TestBoard {

    private final Board board = new Board(100,50);
    private final Alien alien = board.getFirstAlien();

    @Test
    public void testBoardConstructor(){
        assertEquals(100, board.getWidth());
        assertEquals(50, board.getHeight());
    }
    
    @Test
    public void testProcessKeyLeft(){
        KeyStroke key = new KeyStroke(ArrowLeft);
        board.processKey(key);
        Position pos = new Position(48,50);
        assertEquals(pos.getX(), board.getShipX());
    }
    
    @Test
    public void testProcessKeyRight(){
        KeyStroke key = new KeyStroke(ArrowRight);
        board.processKey(key);
        Position pos = new Position(50,50);
        assertEquals(pos.getX(), board.getShipX());
    }
    
    @Test
    public void testProcessKeyRandom(){
        KeyStroke key = new KeyStroke(ArrowUp);
        board.processKey(key);
        Position pos = new Position(49,50);
        assertEquals(pos.getX(), board.getShipX());
    }
    
    @Test
    public void testSetPosition(){
        assertEquals(49,board.getShipX());
        Position pos = new Position(1,1);
        board.setPosition(pos);
        assertEquals(1,board.getShipX());
    }
    
    @Test
    public void testMoveShip(){
        Position pos = new Position(50, 40);
        board.moveShip(pos);
        assertEquals(pos.getX(), board.getShipX());
    }
    
    @Test
    public void testCanShipMoveRight(){
        Position pos = new Position(99, 40);
        assertFalse(board.canShipMove(pos));
    }
    
    @Test
    public void testCanShipMoveLeft(){
        Position pos = new Position(1, 40);
        assertFalse(board.canShipMove(pos));
    }
    
    @Test
    public void testCanShipMoveTrue(){
        Position pos = new Position(49, 40);
        assertTrue(board.canShipMove(pos));
    }
    
    @Test
    public void testMoveAlienDown() {
        assertTrue(board.getMove());
        board.moveAlienDown();
        assertFalse(board.getMove());
        board.moveAlienDown();
        assertTrue(board.getMove());
    }
    
    @Test
    public void testMoveAlienRight() {
        assertEquals(1, alien.getX());
        board.moveAlienRight();
        assertEquals(2, board.getFirstAlien().getX());
    }
    
    @Test
    public void testMoveAlienRightFar() {
        assertEquals(1, alien.getX());
        for(int i=0;i<10;i++)
            board.moveAlienRight();
        assertEquals(11, board.getFirstAlien().getX());
    }
    
    @Test
    public void testMoveAlienLeft() {
        assertEquals(1, alien.getX());
        board.moveAlienLeft();
        assertEquals(0, board.getFirstAlien().getX());
    }
    
    @Test
    public void testMoveAlienLeftFar() {
        assertEquals(1, alien.getX());
        for(int i=0;i<20;i++)
            board.moveAlienRight();
        for(int i=0;i<10;i++)
            board.moveAlienLeft();
        assertEquals(11, board.getFirstAlien().getX());
    }

    @Test
    public void testShooting(){

    }

    @Test
    public void testShootingPrees(){

    }

    @Test
    public void testCheckAlienCollision(){

    }

    @Test
    public void testCheckShipCollision(){

    }

    @Test
    public void testPossiblePositions(){

    }

    @Test
    public void testIsGameOver(){

    }

    @Test
    public void testHit(){

    }

    @Test
    public void testUp(){

    }

    @Test
    public void testLevelUp(){

    }
}
