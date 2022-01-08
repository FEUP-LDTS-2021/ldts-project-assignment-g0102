package gui.stages;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Loss {
  
  public Loss(){};
  
  public void draw(TextGraphics graphics) {
    graphics.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(27, 25), "OH NO THE ALIENS ARE COMING CLOSER TO EARTH!!");
    graphics.putString(new TerminalPosition(30, 26), "GATHER YOUR STRENGTH AND LETS TRY AGAIN");
  }
}
