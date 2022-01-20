package stages;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import controller.Board;
import gui.GameView;
import gui.MenuBoardView;

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
      key = screen.pollInput();
      if(key == null) break;
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'l' || board.isGameOver() == 1)
        board.hit();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'w' || board.isGameOver() == 2)
        board.levelUp();
      board.processKey(key);
    }while(key.getKeyType() != KeyType.EOF);
  }
  
  public int running() throws IOException {
    a.draw();
    board.running();
    if(board.isGameOver() == 1) return 1;
    if(board.isGameOver() == 2) return 2;
    return 0;
  }
}
