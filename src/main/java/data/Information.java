package data;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Information {
  private int score;
  private int lives;
  private int level;
  private int Shipbullet;
  private int Alienbullet;

  public Information(int score, int lives, int level, int Shipbullet, int Alienbullet) {
    this.score = score;
    this.lives = lives;
    this.level = level;
    this.Shipbullet = Shipbullet;
    this.Alienbullet = Alienbullet;
  }

  public int getLives() {
    return lives;
  }

  public int getScore() { return score;}

  public int getLevel() { return level;}
  
  public int getShipBullet() { return Shipbullet;}
  
  public int getAlienbullet() { return Alienbullet;}

  public void levelUp(){ level++ ; Shipbullet++ ; Alienbullet += 2; }

  public void scoreUp(){
    score += 100;
  }
  
  public void liveHit() { lives--;}
  
  public void oneUp() {lives++;}


  public void draw(TextGraphics graphics) {
    scoreDraw(graphics);
    livesDraw(graphics);
    levelDraw(graphics);
    bulletDraw(graphics);
  }

  public void scoreDraw(TextGraphics graphics){
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(1,1), "Score:");
    graphics.putString(new TerminalPosition(8,1), Integer.toString(score));
  }

  public void livesDraw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(1,55), "Lives:");
    for(int i = 0; i < lives * 2; i += 2) {
      graphics.putString(new TerminalPosition((8 + i),55), "ª");
    }
  }

  public void levelDraw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(80,1), "Level:");
    graphics.putString(new TerminalPosition(87,1), Integer.toString(level));
  }
  
  public void bulletDraw(TextGraphics graphics) {
    graphics.setForegroundColor(TextColor.Factory.fromString("WHITE"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(65,55), "Number of Bullets:");
    for(int i = 0; i < Shipbullet * 2; i += 2) {
      graphics.putString(new TerminalPosition((84 + i),55), "û");
    }
  }
}
