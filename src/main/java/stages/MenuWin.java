package stages;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import gui.GameView;
import gui.MenuWinView;

import java.io.IOException;

public class MenuWin {
    MenuWinView w;
    private Screen screen;
    
    MenuWin(GameView gui){
      this.w = new MenuWinView(gui);
      this.screen = gui.getScreen();
    }
  
  public void run() throws IOException {
    KeyStroke key;
    
    do{
      w.draw();
      key = screen.readInput();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q' || key.getKeyType() == KeyType.Character && key.getCharacter() == ' ')
        screen.stopScreen();
    }while(key.getKeyType() != KeyType.EOF);
  }
}
