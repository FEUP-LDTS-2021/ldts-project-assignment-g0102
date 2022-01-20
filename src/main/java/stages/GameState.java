package stages;

import gui.GameView;

import java.io.IOException;

public class GameState {
  
  MainMenu start;
  MenuBoard board;
  MenuLoss loss;
  MenuWin win;
  int fps;
  int i = 0;
  
  public GameState(GameView gui, int width, int height, int fps){
    start = new MainMenu(gui);
    board = new MenuBoard(gui, width, height);
    loss = new MenuLoss(gui);
    win = new MenuWin(gui);
    this.fps = fps;
  }
  
  public void run() throws IOException {
    start.run();
    int frameTime = 1000 / this.fps;
    while (i == 0){
      long startTime = System.currentTimeMillis();
    
      i = board.running();
      board.run();
    
      long elapsedTime = System.currentTimeMillis() - startTime;
      long sleepTime = frameTime - elapsedTime;
    
      if (sleepTime > 0) try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
      
      }
    }
    if(i==1) loss.run();
    else win.run();
  }
}