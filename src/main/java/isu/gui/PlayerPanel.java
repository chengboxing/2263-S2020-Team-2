package isu.gui;




import isu.engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    protected void paintComponent(Graphics g){
        int w;
        for(int i = 0; i < GameEngine.TILES_PER_PLAYER; i++){
            w = 65 * i;
            g.setColor(Color.BLACK);
            g.drawRect(25 + w, 25, 40, 40);
            g.setColor(Color.WHITE);
            g.fillRect(25 + w, 25, 40, 40);
        }
    }
}
