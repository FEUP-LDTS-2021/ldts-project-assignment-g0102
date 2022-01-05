import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Board {
  
  private int width, height;
  private Ship ship;
  private List<Alien> aliens;
  private boolean canAlienGoRight = true;
  
  Board(int x, int y){
    width = x;
    height = y;
    ship = new Ship(49,40);
    this.aliens = createAliens();
  }

  public int getWidth(){return width;}
  public int getHeight(){return height;}
  public int getShipX(){
    return ship.getX();
  }
  public boolean getMove(){return canAlienGoRight;}
  public Alien getFirstAlien(){return aliens.get(0);}
  
  public void processKey(KeyStroke key) {
    switch (key.getKeyType()) {
      case ArrowLeft-> moveShip(ship.moveLeft());
      case ArrowRight-> moveShip(ship.moveRight());
      default-> moveShip(ship.Stand());
    }
    if(canAlienGoRight) {
      for (Alien alien : aliens)
        if (alien.close(width)) moveAlienDown();
      moveAlienRight();
    }
    else {
      for (Alien alien : aliens)
        if (alien.close()) moveAlienDown();
      moveAlienLeft();
    }
  }
  
  public void draw(TextGraphics graphics){
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    ship.draw(graphics);
    for(Alien alien : aliens)
      alien.draw(graphics);
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
}
