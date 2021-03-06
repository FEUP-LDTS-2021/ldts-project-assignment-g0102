package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameView {
  private final Screen screen;
  private final TextGraphics graphics;
  
  public GameView(int width, int height) throws IOException, FontFormatException {
    AWTTerminalFontConfiguration fontConfig = loadFontASB();
    Terminal terminal = createTerminal(width, height, fontConfig);

    screen = new TerminalScreen(terminal);
    screen.setCursorPosition(null);   // We don't need a cursor
    screen.startScreen();             // Screens must be started
    screen.doResizeIfNecessary();     // Resize screen if necessary
    graphics = screen.newTextGraphics();
  }

  public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException{
    Terminal terminal;
    TerminalSize terminalSize = new TerminalSize(width, height);
    DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    terminalFactory.setForceAWTOverSwing(true);
    terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
    terminal = terminalFactory.createTerminal();

    return terminal;
  }

  public AWTTerminalFontConfiguration loadFontASB() throws FontFormatException, IOException {
    File fontFile = new File("src/main/resources/Fonts/Finalff.ttf");
    Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(font);

    Font loadedFont = font.deriveFont(Font.PLAIN, 15);
    return AWTTerminalFontConfiguration.newInstance(loadedFont);
  }

  public Screen getScreen() {
    return screen;
  }
  
  public TextGraphics getGraphics() {
    return graphics;
  }
}
