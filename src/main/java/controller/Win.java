package controller;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Win {
  
  public Win(){};
  
  public void draw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(31, 12), "Thanks for helping save planet Earth");
    graphics.putString(new TerminalPosition(33, 13), "For your trouble here is a medal");

    try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/medalha.txt"))) {
      String line;
      int i=14;
      
      while ((line = br.readLine()) != null) {
        graphics.putString(new TerminalPosition(40, i++), line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
