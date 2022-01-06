import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import data.Board;
import data.Position;
import gui.GameState;
import gui.GameView;

import java.io.IOException;

public class Game {
  private Screen screen;
  private Board board;
  
  public Game() {
    try {
      TerminalSize terminalSize = new TerminalSize(100, 60);
      DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
      Terminal terminal = terminalFactory.createTerminal();
      board = new Board(100,60);
      screen = new TerminalScreen(terminal);
      TextGraphics graphics = screen.newTextGraphics();
      screen.setCursorPosition(null); // we don't need a cursor
      screen.startScreen(); // screens must be started
      screen.doResizeIfNecessary(); // resize screen if necessary
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void draw() throws IOException{
    screen.clear();
    board.draw(screen.newTextGraphics());
    screen.refresh();
  }
  
  public void run() throws IOException{
    KeyStroke key;
    do {
      draw();
      key = screen.readInput();
      if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        screen.stopScreen();
      processKey(key);
    }while(key.getKeyType() != KeyType.EOF);
  
    screen.stopScreen();
  }
  
  public void processKey(KeyStroke key) {
    board.processKey(key);
  }
  
  public void moveShip(Position position) {
    board.setPosition(position);
  }
  
  public static void main(String[] args) throws IOException {
    GameView gui = new GameView(100,60);
    GameState a = new GameState(gui,100,60);
    a.run();
  }
}