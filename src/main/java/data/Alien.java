package data;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Alien {
  private Position position;
  
  public Alien(int x, int y){ position = new Position(x,y);}
  
  public int getX() {
    return position.getX();
  }
  public int getY() {
    return position.getY();
  }
  public void setX(int x) {
    position.setX(x);
  }
  public void setY(int y) {
    position.setY(y);
  }
  
  public void draw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(position.getX()-1, position.getY()-1), "/\\");
    graphics.putString(new TerminalPosition(position.getX()-1, position.getY()), "\\/");
  }
  
  public Position moveLeft() {
    return new Position(position.getX()-1, position.getY());
  }
  
  public Position moveRight() { return new Position(position.getX()+1, position.getY()); }
  
  public Position moveDown() { return new Position(position.getX(), position.getY()+1); }
  
  public void setPosition(Position position) {
    this.position = position;
  }
  public Position getPosition() { return this.position; }
  
  public boolean close() {
    return position.getX() - 2 <= 0;
  }
  
  public boolean close(int width) {
    return position.getX() + 2 >= width;
  }
}