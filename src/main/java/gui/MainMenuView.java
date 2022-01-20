package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import controller.Start;

import java.io.IOException;

public class MainMenuView {
  
  private final Screen screen;
  private final TextGraphics graphics;
  private final Start a;
  
  public MainMenuView(GameView gui) {
    this.graphics = gui.getGraphics();
    this.screen = gui.getScreen();
    this.a = new Start();
  }
  
  public void draw() throws IOException {
    screen.clear();
    a.draw(graphics);
    screen.refresh();
  }
  
}
