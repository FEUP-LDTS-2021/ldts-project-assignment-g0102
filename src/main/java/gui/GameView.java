package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GameView {
  private final Screen screen;
  private final TextGraphics graphics;
  
  public GameView(int width, int height) throws IOException {
    TerminalSize terminalSize = new TerminalSize(width, height);
    DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    Terminal terminal = terminalFactory.createTerminal();
    
    screen = new TerminalScreen(terminal);
    screen.setCursorPosition(null);   // We don't need a cursor
    screen.startScreen();             // Screens must be started
    screen.doResizeIfNecessary();     // Resize screen if necessary
    graphics = screen.newTextGraphics();
  }
  
  public Screen getScreen() {
    return screen;
  }
  
  public TextGraphics getGraphics() {
    return graphics;
  }
}
