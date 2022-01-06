package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import gui.colors.Start;

import java.io.IOException;

public class MainMenuView {
  
  private Screen screen;
  private final TextGraphics graphics;
  private final int width;
  private final int height;
  private Start a;
  
  public MainMenuView(GameView gui, int width, int height) {
    this.graphics = gui.getGraphics();
    this.screen = gui.getScreen();
    this.width = width;
    this.height = height;
    this.a = new Start(width,height);
  }
  
  public void draw() throws IOException {
    screen.clear();
    a.draw(graphics);
    screen.refresh();
  }
  
}
