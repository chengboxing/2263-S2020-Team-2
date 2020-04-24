package isu.gui;




import isu.engine.GameEngine;
import isu.engine.Tile;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {

    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    public static final int Y = 25;
    public static final int X0 = 25;
    public static final int SPACE = 65;
    GameEngine gameEngine;

    public TilePanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    protected void paintComponent(Graphics g){
        int w;
        for(int i = 0; i < GameEngine.TILES_PER_PLAYER; i++){
            Tile tile = gameEngine.getCurrentPlayer().getTile(i);
            w = SPACE * i;
            g.setColor(Color.BLACK);
            g.drawRect(X0 + w, Y, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.fillRect(X0 + w, Y, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.drawString(tile.getLabel(), X0 + w, Y + (HEIGHT/2));
        }
    }


}
