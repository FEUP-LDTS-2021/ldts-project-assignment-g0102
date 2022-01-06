package gui;

import java.io.IOException;

public class GameState {
  
  MainMenu a;
  MenuBoard b;
  
  public GameState(GameView gui, int width, int height){
    a = new MainMenu(gui, width, height);
    b = new MenuBoard(gui, width, height);
  }
  
  public void run() throws IOException {
    a.run();
    b.run();
  }
}
