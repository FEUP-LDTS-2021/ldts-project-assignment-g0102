package data;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestAlien {

  private final Alien alien1 = new Alien(1,2);
  private final Alien alien2 = new Alien(20,30);

  @Test
  public void testConstructor(){
    assertEquals(1,alien1.getX());
    assertEquals(2,alien1.getY());
  }
  
  @Test
  public void testAlienSetters() {
    int alien_setX = 20;
    int alien_setY = 40;
    alien1.setX(alien_setX);
    alien1.setY(alien_setY);
    assertEquals(20,alien1.getX());
    assertEquals(40,alien1.getY());
  }
  
  @Test
  public void testAlienSetPosition() {
    Position pos = new Position(20,40);
    alien1.setPosition(pos);
    assertEquals(20,alien1.getX());
    assertEquals(40,alien1.getY());
  }

  @Test
  public void testAlienGetPosition(){
    alien1.getPosition();

    assertEquals(1,alien1.getX());
    assertEquals(2, alien1.getY());
  }
  
  @Test
  public void testAlienMoveRight(){
    Alien alienMoved = new Alien(21,30);
    Position pos = alien2.moveRight();
    assertEquals(pos.getX(),alienMoved.getX());
  }
  
  @Test
  public void testAlienMoveLeft(){
    Alien alienMoved = new Alien(19,30);
    Position pos = alien2.moveLeft();
    assertEquals(pos.getX(),alienMoved.getX());
  }
  
  @Test
  public void testAlienMoveDown(){
    Alien alienMoved = new Alien(20,29);
    Position pos = alien2.moveDown();
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