package gui.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import gui.stages.Win;

import java.io.IOException;

public class MenuWinView {
  private final Screen screen;
  private final TextGraphics graphics;
  private Win w;
  
  public MenuWinView(GameView gui) {
    this.w = new Win();
    this.graphics = gui.getGraphics();
    this.screen = gui.getScreen();
  }
  
  public void draw() throws IOException {
    screen.clear();
    w.draw(graphics);
    screen.refresh();
  }
}
