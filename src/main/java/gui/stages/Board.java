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
  private Alien left;
  private Alien right;
  private boolean canAlienGoRight = true;
  private Information informations;
  private List<Bullet> bulletS = new ArrayList<>();
  public List<Bullet> bulletA = new ArrayList<>();
  
  public Board(int x, int y){
    width = x;
    height = y;
    ship = new Ship(49,50);
    this.walls = createWalls();
    this.aliens = createAliens();
    this.informations = new Information(0,3,1,1,5);
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
    if(bulletS.size() < informations.getShipBullet()) shooting(key);
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
    if(bulletS.size() > 0)
      for(Bullet s : bulletS)
        s.draw(graphics,0);
    if(bulletA.size() > 0)
      for(Bullet b : bulletA)
        b.draw(graphics,1);
  }
  
  public void running(){
    if(bulletS.size() > 0) checkAlienCollision();
    if(bulletA.size() < informations.getAlienbullet()) shooting();
    if(bulletA.size() > 0) checkShipCollision();
    if(canAlienGoRight) {
      if (right.close(width)) moveAlienDown();
      moveAlienRight();
    }
    else {
      if (left.close()) moveAlienDown();
      moveAlienLeft();
    }
    if(aliens.size() == 0 && informations.getLevel() != 5) levelUp();
    if(aliens.size() == 0 && informations.getLevel() == 5) informations.levelUp();
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
    left = new Alien(1,16);
    right = new Alien(36,16);
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
    left.setPosition(left.moveLeft());
    right.setPosition(right.moveLeft());
    for(Alien alien : aliens)
      alien.setPosition(alien.moveLeft());
  }
  
  public void moveAlienRight() {
    left.setPosition(left.moveRight());
    right.setPosition(right.moveRight());
    for(Alien alien : aliens)
      alien.setPosition(alien.moveRight());
  }

  private void shooting() {
    Random a = new Random();
    int s = a.nextInt(aliens.size());
    bulletA.add(new Bullet(aliens.get(s).getX(), aliens.get(s).getY()));
  }

  private void shooting(KeyStroke key) {
    if(key.getKeyType() == KeyType.Character && key.getCharacter() == ' ')
      bulletS.add(new Bullet(ship.getX(), ship.getY()-2));
  }

  private void checkAlienCollision() {
    for(Bullet s : bulletS) {
      if (s.getY() == 8) {
        bulletS.remove(s);
        break;
      }
      if (possiblePositions(aliens)) {
        informations.scoreUp();
        bulletS.remove(s);
        break;
      }
      s.setPosition(s.rise());
    }
  }

  private void checkShipCollision() {
    for(Bullet b : bulletA) {
      if (b.getY() == 51) {
        bulletA.remove(b);
        break;
      }
      if (b.getX() == ship.getX() && b.getY() == ship.getY()) {
        informations.liveHit();
        bulletA.remove(b);
        break;
      }
      b.setPosition(b.lower());
    }
  }

  private boolean possiblePositions(List<Alien> aliens) {
    for(Bullet s : bulletS) {
      for (Alien alien : aliens) {
        if (alien.getPosition().equals(s.getPosition())) return true;
        int a = alien.getX() - 1, b = alien.getY() - 1;
        for (int i = 0; i < 3; i++)
          for (int j = 0; j < 3; j++)
            if ((a + i) == s.getX() && (b + j) == s.getY()) {
              aliens.remove(alien);
              return true;
            }
      }
    }
    return false;
  }
  
  public int isGameOver() {
    if(informations.getLevel() == 6) return 2;
    if(informations.getLives() == 0) return 1;
    if (right.getY() == (ship.getY()-5)) return 1;
    return 0;
  }
  
  public void hit(){
    informations.liveHit();
  }
  
  public void up(){
    informations.levelUp();
  }
  
  private void levelUp() {
    informations.levelUp();
    createAliens();
  }
}
