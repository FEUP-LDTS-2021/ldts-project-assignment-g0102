package data;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import data.Position;

public class Wall {
    private Position position;

    public Wall(int x, int y) {
        position = new Position(x,y);
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('#')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),"º");
    }

    public Position getPosition() {
        return position;
    }
}

