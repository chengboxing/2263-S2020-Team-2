package isu.gui;

import isu.engine.Board;
import isu.engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel{

    protected void paintComponent(Graphics g){
        int columnCount = Board.COLUMN_COUNT;
        int rowCount = Board.ROW_COUNT;
        int w;
        int h;

        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                String label = GameEngine.GAME_ENGINE.getBoard().getCell(i, j).getLabel();
                w = 45 * i;
                h = 45 * j;
                g.setColor(Color.BLACK);
                g.drawRect(h + 10, w + 10, 40, 40);
                g.setColor(Color.WHITE);
                g.fillRect(h + 10, w + 10, 40, 40);
                g.setColor(Color.BLACK);
                g.drawString(label, h+20, w+30);
            }
        }
    }
}
