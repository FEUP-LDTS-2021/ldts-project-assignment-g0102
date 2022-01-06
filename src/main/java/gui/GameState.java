package gui;

import gui.viewers.GameView;

import java.io.IOException;

public class GameState {
  
  MainMenu start;
  MenuBoard board;
  MenuLoss loss;
  
  public GameState(GameView gui, int width, int height){
    start = new MainMenu(gui);
    board = new MenuBoard(gui, width, height);
    loss = new MenuLoss(gui, width, height);
  }
  
  public void run() throws IOException {
    start.run();
    board.run();
    //loss.run();
  }
}
