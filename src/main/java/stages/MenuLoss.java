package stages;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import gui.GameView;
import gui.MenuLossView;

import java.io.IOException;

public class MenuLoss {
  
  MenuLossView l;
  private Screen screen;
  
  MenuLoss(GameView gui){
    this.l = new MenuLossView(gui);
    this.screen = gui.getScreen();
  }
  
  public void run() throws IOException {
    KeyStroke key;
    
    do{
      l.draw();
      key = screen.readInput();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        screen.stopScreen();
    }while(key.getKeyType() != KeyType.EOF);
  }
}
