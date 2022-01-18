package stages;

import com.googlecode.lanterna.input.KeyStroke;
import data.Alien;
import data.Bullet;
import data.Position;
import data.Ship;
import gui.stages.Board;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void testHit(){
        board.hit();
        assertEquals(2,board.infoGetLives());
    }

    @Test
    public void testUp(){
        board.up();
        assertEquals(2,board.infoGetLevel());
    }

    @Test
    public void testShootingFire(){
        board.shooting();
        List<Bullet> bulletA = new ArrayList<>();
        bulletA.add(new Bullet(1,51));
        assertEquals(51,bulletA.get(0).getY());
    }

    @Test
    public void testIsGameOverLevel(){
        for(int i=0; i<5; i++){
            board.levelUp();
        }
        assertEquals(2, board.isGameOver());
    }

    @Test
    public void testIsGameOverLives(){
        for(int i=0; i<3; i++){
            board.hit();
        }
        assertEquals(1, board.isGameOver());
    }

}
