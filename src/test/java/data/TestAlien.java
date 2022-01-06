package data;

import data.Alien;
import data.Position;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestAlien {
  
  @Test
  public void testConstructor(){
    Alien alien = new Alien(1,2);
    assertEquals(1,alien.getX());
    assertEquals(2,alien.getY());
  }
  
  @Test
  public void testAlienSetters() {
    Alien alien = new Alien(1,1);
    int alien_setX = 20;
    int alien_setY = 40;
    alien.setX(alien_setX);
    alien.setY(alien_setY);
    assertEquals(20,alien.getX());
    assertEquals(40,alien.getY());
  }
  
  @Test
  public void testAlienSetPosition() {
    Alien alien = new Alien(1,1);
    Position pos = new Position(20,40);
    alien.setPosition(pos);
    assertEquals(20,alien.getX());
    assertEquals(40,alien.getY());
  }
  
  @Test
  public void testAlienMoveRight(){
    Alien alien = new Alien(20, 30);
    Alien alienMoved = new Alien(21,30);
    Position pos = alien.moveRight();
    assertEquals(pos.getX(),alienMoved.getX());
  }
  
  @Test
  public void testAlienMoveLeft(){
    Alien alien = new Alien(20, 30);
    Alien alienMoved = new Alien(19,30);
    Position pos = alien.moveLeft();
    assertEquals(pos.getX(),alienMoved.getX());
  }
  
  @Test
  public void testAlienMoveDown(){
    Alien alien = new Alien(20, 30);
    Alien alienMoved = new Alien(20,29);
    Position pos = alien.moveDown();
    assertEquals(pos.getX(),alienMoved.getX());
  }
  
  @Test
  public void testAlienCloseTrue(){
    Alien alien = new Alien(1,1);
    assertTrue(alien.close());
  }
  
  @Test
  public void testAlienCloseFalse(){
    Alien alien = new Alien(40,1);
    assertFalse(alien.close());
  }
  
  @Test
  public void testCloseAlienTrue(){
    Alien alien = new Alien(99,1);
    assertTrue(alien.close(100));
  }
  
  @Test
  public void testCloseAlienFalse(){
    Alien alien = new Alien(40,1);
    assertFalse(alien.close(100));
  }
}