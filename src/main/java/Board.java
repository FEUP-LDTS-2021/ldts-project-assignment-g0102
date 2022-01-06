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
  private List<Wall> walls;
  private Information informations;

  Board(int x, int y){
    width = x;
    height = y;
    ship = new Ship(49,50);
    this.walls = createWalls();
    this.informations = new Information(0,3,1);
  }

  public int getWidth(){return width;}
  public int getHeight(){return height;}

  public void processKey(KeyStroke key) {
    switch (key.getKeyType()) {
      case ArrowLeft -> moveShip(ship.moveLeft());
      case ArrowRight -> moveShip(ship.moveRight());
      default -> moveShip(ship.Stand());
    }
  }

  public void draw(TextGraphics graphics){
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    for(Wall wall : walls)
      wall.draw(graphics);
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

  public int getShipX(){
    return ship.getX();
  }

  private List<Wall> createWalls() {
    List<Wall> walls = new ArrayList<>();
    for(int i = 0; i < width; i++) {
      walls.add(new Wall(i,5));
      walls.add(new Wall(i,52));
    }
    return walls;
  }
}
