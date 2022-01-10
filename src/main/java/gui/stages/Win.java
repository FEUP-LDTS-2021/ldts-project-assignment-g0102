package gui.stages;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Win {
  
  public Win(){};
  
  public void draw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(31, 12), "Thanks for helping save planet Earth");
    graphics.putString(new TerminalPosition(33, 13), "For your trouble here is a medal");
  }
}
