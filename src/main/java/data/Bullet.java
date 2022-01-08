package data;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet {
     private Position position;

    public Bullet(int x, int y){ position = new Position(x,y); }

    public int getX() {return position.getX(); }
    public int getY() { return position.getY(); }

    public Position lower() { return new Position(position.getX(), position.getY()+1); }
    public Position rise() { return new Position(position.getX(), position.getY()-1); }

    public void setPosition(Position position) { this.position = position; }
    public Position getPosition() { return this.position; }

    public void draw(TextGraphics graphics, int a) {
        graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
        graphics.enableModifiers(SGR.BOLD);
        if(a == 0) {
          graphics.putString(new TerminalPosition(position.getX(), position.getY()), "^");
          graphics.putString(new TerminalPosition(position.getX(), position.getY() + 1), "|");
        }
        else {
          graphics.putString(new TerminalPosition(position.getX(), position.getY()), "|");
          graphics.putString(new TerminalPosition(position.getX(), position.getY() + 1), "Y");
        }
    }
}
