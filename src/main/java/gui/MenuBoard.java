package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import gui.Stages.Board;

import java.io.IOException;

public class MenuBoard {
  
  private Board board;
  private final TextGraphics graphics;
  private Screen screen;
  private final MenuBoardView a;
  
  public MenuBoard(GameView gui, int width, int height) {
    this.board = new Board(width,height);
    this.graphics = gui.getGraphics();
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
