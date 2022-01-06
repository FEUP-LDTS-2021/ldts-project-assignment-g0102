package gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MainMenu {
  
  private final Screen screen;
  private final MainMenuView v;
  
  MainMenu(GameView gui, int width, int height){
    v = new MainMenuView(gui, width, height);
    this.screen = gui.getScreen();
  }
  
  public boolean processKey() throws IOException {
    v.draw();
    KeyStroke key = screen.readInput();
    
    switch (key.getKeyType()) {
      case EOF:
        screen.stopScreen();
      case Character:
        if(key.getCharacter() == 'q')
          screen.stopScreen();
        if(key.getCharacter() == ' ')
          return true;
      default: return false;
    }
    
  }
}
