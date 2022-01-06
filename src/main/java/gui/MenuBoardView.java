package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import gui.Stages.Board;

import java.io.IOException;

public class MenuBoardView {
  
  private Screen screen;
  private final TextGraphics graphics;
  private Board board;
  
  public MenuBoardView(GameView gui, Board board) {
    this.graphics = gui.getGraphics();
    this.screen = gui.getScreen();
    this.board = board;
  }
  
  public void draw() throws IOException {
    screen.clear();
    board.draw(graphics);
    screen.refresh();
  }
}
