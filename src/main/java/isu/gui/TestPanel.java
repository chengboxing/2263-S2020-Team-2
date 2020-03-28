package isu.gui;

import isu.engine.Board;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {
    static final int MARGIN = 10;

    protected void paintComponent(Graphics g){
        int h = this.getHeight();
        int w = this.getWidth();
        int rowCount = Board.ROW_COUNT;
        int columnCount = Board.COLUMN_COUNT;

        g.setColor(Color.BLUE);
        int yStep = (h - 2*MARGIN)/(rowCount);
        int y = MARGIN;
        int x1 = MARGIN;
        int x2 = w - MARGIN;
        for(int i = 0; i < rowCount+1; i++, y+=yStep){
            g.drawLine(x1, y, x2, y);
        }

        g.setColor(Color.BLUE);
        int xStep = (w - 2*MARGIN)/columnCount;
        int x = MARGIN;
        int y1 = MARGIN;
        int y2 = h - MARGIN;
        for(int i = 0; i < columnCount+1; i++, x+=xStep){
            g.drawLine(x, y1, x, y2);
        }







//        g.setColor(Color.BLUE);
//        g.fillRect(10, 10, 50, 50);
//        g.setColor(Color.RED);
//
//        for(int i = 0; i < 10; i++){
//            int x = (int) (Math.random() * w);
//            int y = (int) (Math.random() * h);
//            int r = (int) (Math.random() * Math.min(w, h));
//            g.drawOval(x, y, r, r);
//        }
    }
}
