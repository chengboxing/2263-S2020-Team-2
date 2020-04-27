package isu.gui.graphics;

import isu.engine.Board;
import isu.engine.BoardCell;
import isu.engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel{
    private GameEngine gameEngine;

    public BoardPanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    protected void paintComponent(Graphics g){
        int columnCount = Board.COLUMN_COUNT;
        int rowCount = Board.ROW_COUNT;
        int w;
        int h;

        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                BoardCell cell = gameEngine.getBoard().getCell(i, j);
                w = 45 * i;
                h = 45 * j;
                g.setColor(Color.BLACK);
                g.drawRect(h + 10, w + 10, 40, 40);
                if(cell.isOccupied()){
                    g.setColor(cell.getTile().getColor());
                }else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(h + 10, w + 10, 40, 40);
                g.setColor(Color.BLACK);
                g.drawString(cell.getLabel(), h+20, w+30);
            }
        }
    }
}
