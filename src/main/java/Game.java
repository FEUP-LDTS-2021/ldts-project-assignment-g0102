import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
  private Screen screen;
  private final Ship ship = new Ship(49,40);
  
  public Game() {
    try {
      TerminalSize terminalSize = new TerminalSize(100, 50);
      DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
      Terminal terminal = terminalFactory.createTerminal();
      screen = new TerminalScreen(terminal);
      screen.setCursorPosition(null); // we don't need a cursor
      screen.startScreen(); // screens must be started
      screen.doResizeIfNecessary(); // resize screen if necessary
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void draw() throws IOException{
    screen.clear();
    ship.draw(screen);
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
    switch (key.getKeyType()){
      case ArrowLeft: moveShip(ship.moveLeft());
      case ArrowRight: moveShip(ship.moveRight());
      default: ship.Stand();
    }
  }
  
  public void moveShip(Position position) {
    ship.setPosition(position);
  }
  
  public static void main(String[] args) throws IOException {
    Game a = new Game();
    a.run();
  }
}