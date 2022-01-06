package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import gui.stages.Board;
import gui.viewers.GameView;
import gui.viewers.MenuBoardView;

import java.io.IOException;

public class MenuBoard {
  
  private Board board;
  private Screen screen;
  private final MenuBoardView a;
  
  public MenuBoard(GameView gui, int width, int height) {
    this.board = new Board(width,height);
    this.screen = gui.getScreen();
    this.a = new MenuBoardView(gui, board);
  }
  
  public void run() throws IOException {
    KeyStroke key;
    do {
      a.draw();
      key = screen.readInput();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        screen.stopScreen();
      board.processKey(key);
    }while(key.getKeyType() != KeyType.EOF);
  }
}
