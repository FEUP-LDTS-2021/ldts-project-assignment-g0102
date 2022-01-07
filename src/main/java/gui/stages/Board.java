package gui.stages;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
  
  private int width, height;
  private Ship ship;
  private List<Wall> walls;
  private List<Alien> aliens;
  private final Alien left = new Alien(1,8);                      // transformar numa lista
  private final Alien right = new Alien(36,8);
  private boolean canAlienGoRight = true;
  private Information informations;
  private Bullet bulletS;
  private boolean shipBullet = true;
  public Bullet bulletA;
  private boolean alienBullet = true;

  public Board(int x, int y){
    width = x;
    height = y;
    ship = new Ship(49,50);
    this.walls = createWalls();
    this.aliens = createAliens();
    this.informations = new Information(0,3,1);
  }
  
  public int getWidth(){return width;}
  public int getHeight(){return height;}
  public int getShipX(){return ship.getX();}
  public boolean getMove(){return canAlienGoRight;}
  public Alien getFirstAlien(){return aliens.get(0);}
  
  public void processKey(KeyStroke key) {
    switch (key.getKeyType()) {
      case ArrowLeft-> moveShip(ship.moveLeft());
      case ArrowRight-> moveShip(ship.moveRight());
      default-> moveShip(ship.Stand());
    }
    if(shipBullet) shooting(key);
    if(!shipBullet) checkAlienCollision();
    if(alienBullet) shooting();
    if(!alienBullet) checkShipCollision();
    if(canAlienGoRight) {
      if (right.close(width)) moveAlienDown();
      moveAlienRight();
      left.setPosition(left.moveRight());
      right.setPosition(right.moveRight());
    }
    else {
      if (left.close()) moveAlienDown();
      moveAlienLeft();
      left.setPosition(left.moveLeft());
      right.setPosition(right.moveLeft());
    }
  }
  
  public void draw(TextGraphics graphics){
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    for(Wall wall : walls)
      wall.draw(graphics);
    for(Alien alien : aliens)
      alien.draw(graphics);
    ship.draw(graphics);
    informations.draw(graphics);
    if(!shipBullet) bulletS.draw(graphics,0);
    if(!alienBullet) bulletA.draw(graphics,1);
  }
  
  public void setPosition(Position position){
    ship.setPosition(position);
  }
  
  public void moveShip(Position position) {
    if(canShipMove(position))
      ship.setPosition(position);
  }
  
  public boolean canShipMove(Position position){
    if(position.getX()==width-1){
      ship.moveLeft();
      return false;
    }
    if(position.getX()==1){
      ship.moveRight();
      return false;
    }
    return true;
  }
  
  private List<Wall> createWalls() {
    List<Wall> walls = new ArrayList<>();
    for(int i = 0; i < width; i++) {
      walls.add(new Wall(i,5));
      walls.add(new Wall(i,52));
    }
    return walls;
  }
  
  private List<Alien> createAliens() {
    aliens = new ArrayList<>();
    for(int i = 0; i < 10; i += 2)
      for(int j = 1; j < 40; j += 5){
        aliens.add(new Alien(j,i+8));
      }
    return aliens;
  }
  
  public void moveAlienDown() {
    for(Alien alien : aliens) {
      alien.setPosition(alien.moveDown());
    }
    canAlienGoRight = !canAlienGoRight;
  }
  
  public void moveAlienLeft() {
    for(Alien alien : aliens)
      alien.setPosition(alien.moveLeft());
  }
  
  public void moveAlienRight() {
    for(Alien alien : aliens)
      alien.setPosition(alien.moveRight());
  }

  private void shooting() {
    Random a = new Random();
    int s = a.nextInt(aliens.size());
    bulletA = new Bullet(aliens.get(s).getX(), aliens.get(s).getY());
    alienBullet = false;
  }

  private void shooting(KeyStroke key) {
    if(key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
      bulletS = new Bullet(ship.getX(), ship.getY()-2);
      shipBullet = false;
    }
  }

  private void checkAlienCollision() {
    if(bulletS.getY() == 8) shipBullet = true;
    if (possiblePositions(aliens)) {
      informations.scoreUp();
      shipBullet = true;
    }
    bulletS.setPosition(bulletS.rise());
  }

  private void checkShipCollision() {
    if(bulletA.getY() == 51) alienBullet = true;
    if(bulletA.getX() == ship.getX() && bulletA.getY() == ship.getY()) {
      informations.liveHit();
      alienBullet = true;
    }
    bulletA.setPosition(bulletA.lower());
  }

  private boolean possiblePositions(List<Alien> aliens) {
    for(Alien alien : aliens) {
      if (alien.getPosition().equals(bulletS.getPosition())) return true;
      int a = alien.getX() - 1, b = alien.getY() - 1;
      for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
          if ((a + i) == bulletS.getX() && (b + j) == bulletS.getY()) {
            aliens.remove(alien);
            return true;
          }
    }
    return false;
  }
}
