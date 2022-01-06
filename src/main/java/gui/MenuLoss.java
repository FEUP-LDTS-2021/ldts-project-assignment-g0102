package gui;

import gui.viewers.GameView;
import gui.viewers.MenuLossView;

public class MenuLoss {
  
  MenuLossView l;
  
  MenuLoss(GameView gui, int width, int height){
    l = new MenuLossView(gui);
  }
}
