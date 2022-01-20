package controller;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import data.Alien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {
  
  private List<Alien> aliens;
  
  public Start() {
    this.aliens = createAliens();
  }
  
  public void draw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.enableModifiers(SGR.BLINK);
    graphics.putString(new TerminalPosition(35,25), "Welcome to Space Invaders!!");
    graphics.putString(new TerminalPosition(24,26), "Please press Space to help us get rid of all the aliens");
    graphics.disableModifiers(SGR.BLINK);
    for(Alien alien : aliens)
      alien.draw(graphics);
  }
  
  private List<Alien> createAliens() {
    Random a = new Random();
    int x, y;
    aliens = new ArrayList<>();
    while(aliens.size() != 30){
      x = a.nextInt(99);
      y = a.nextInt(60);
      if(overlap(x,y))
        continue;
      aliens.add(new Alien(x,y));
    }
    return aliens;
  }
  
  private boolean overlap(int x, int y) {
    if(x < 2 || x > 22 && x < 80 && y > 23 && y < 28)
      return true;
    for(Alien alien : aliens)
      if(x == alien.getX() || x == alien.getX()-1 || y == alien.getY()-1 || y == alien.getY())
        return true;
    return false;
  }
}