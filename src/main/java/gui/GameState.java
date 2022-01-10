package gui;

import gui.viewers.GameView;

import java.io.IOException;

public class GameState {
  
  MainMenu start;
  MenuBoard board;
  MenuLoss loss;
  MenuWin win;
  int i;
  public GameState(GameView gui, int width, int height){
    start = new MainMenu(gui);
    board = new MenuBoard(gui, width, height);
    loss = new MenuLoss(gui);
    win = new MenuWin(gui);
  }
  
  public void run() throws IOException {
    start.run();
    i = board.run();
    if(i==1) loss.run();
    else win.run();
  }
}