import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Board {
  
  private int width, height;
  private Ship ship;
  
  Board(int x, int y){
    width = x;
    height = y;
    ship = new Ship(49,40);
  }

  public int getWidth(){return width;}

  public int getHeight(){return height;}

  
  public void processKey(KeyStroke key) {
    switch (key.getKeyType()) {
      case ArrowLeft-> moveShip(ship.moveLeft());
      case ArrowRight-> moveShip(ship.moveRight());
      default-> moveShip(ship.Stand());
    }
  }
  
  public void draw(TextGraphics graphics){
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    ship.draw(graphics);
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
  
  public int getX(){
    return ship.getX();
  }
  
  public int getY() {
    return ship.getY();
  }
}
