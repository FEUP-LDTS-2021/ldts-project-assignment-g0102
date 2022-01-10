package gui;

import gui.viewers.GameView;

import java.io.IOException;

public class GameState {
  
  MainMenu start;
  MenuBoard board;
  MenuLoss loss;
  MenuWin win;
  
  public GameState(GameView gui, int width, int height){
    start = new MainMenu(gui);
    board = new MenuBoard(gui, width, height);
    loss = new MenuLoss(gui);
    win = new MenuWin(gui);
  }
  
  public void run() throws IOException {
    start.run();
    board.run();
    loss.run();
    win.run();
  }
}
