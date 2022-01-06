import gui.GameState;
import gui.GameView;

import java.io.IOException;

public class Game {

  public static void main(String[] args) throws IOException {
    GameView gui = new GameView(100,60);
    GameState a = new GameState(gui,100,60);
    a.run();
  }
}