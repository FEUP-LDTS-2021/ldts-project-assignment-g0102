package gui.Stages;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import data.Alien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {
  
  private final int width, height;
  private List<Alien> aliens;
  
  public Start(int x, int y) {
    this.width = x;
    this.height = y;
    this.aliens = createAliens();
  }
  
  public void draw(TextGraphics graphics) {
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    graphics.enableModifiers(SGR.BOLD);
    graphics.enableModifiers(SGR.BLINK);
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.putString(new TerminalPosition(35,25), "Welcome to Space Invaders!!");
    graphics.putString(new TerminalPosition(38,26), "To start press Space");
    graphics.disableModifiers(SGR.BLINK);
    for(Alien alien : aliens)
      alien.draw(graphics);
  }
  
  private List<Alien> createAliens() {
    Random a = new Random();
    int x, y;
    aliens = new ArrayList<>();
    for(int i = 0; i < 50; i++){
      do{
        x = a.nextInt(100);
        y = a.nextInt(60);
      }while(x <= 61 && x >= 35 && y != 25 && y != 26);
      aliens.add(new Alien(x,y));
    }
    return aliens;
  }
}