package gui.stages;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import data.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
  
  private int width, height;
  private Ship ship;
  private List<Wall> walls;
  private List<Alien> aliens;
  private final Alien left = new Alien(1,16);
  private final Alien right = new Alien(36,16);
  private boolean canAlienGoRight = true;
  private Information informations;
  
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
  
  public int isGameOver() {
    if(informations.getLevel() == 6) return 2;
    if(informations.getLives() == 0) return 1;
    if (right.getY() == (ship.getY()-5)) return 1;
    return 0;
  }
}
