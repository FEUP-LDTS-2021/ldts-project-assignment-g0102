package stages;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import gui.GameView;
import gui.MainMenuView;

import java.io.IOException;

public class MainMenu {
  
  private final Screen screen;
  private final MainMenuView v;
  
  MainMenu(GameView gui){
    v = new MainMenuView(gui);
    this.screen = gui.getScreen();
  }
  
  public void run() throws IOException {
    KeyStroke key;
    
    do{
      v.draw();
      key = screen.readInput();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        screen.stopScreen();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == ' ')
        break;
    }while(key.getKeyType() != KeyType.EOF);
  }
}
