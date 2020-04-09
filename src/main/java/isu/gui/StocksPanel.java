package isu.gui;

import javax.swing.*;
import java.awt.*;

public class StocksPanel extends JPanel {

    protected void paintComponent(Graphics g){

        for(int i = 0; i < 3; i++){
            g.setColor(Color.WHITE);
            int w = 55 * i;
            g.drawRect(w + 5, 25, 40, 60);
            g.fillRect(w + 5, 25, 40, 60);
            g.setColor(Color.BLACK);
            g.setFont(getFont().deriveFont(8.0f));
            g.drawString("Add", w+11, 40);
            g.drawString("Stock", w+10, 50);
            g.drawString("Here", w+11, 60);
        }
        g.setColor(Color.BLUE);

        g.setFont(getFont().deriveFont(12.0f));
        g.drawString("+", getWidth()/3 - 8, getHeight()/2 + 10);
        g.drawString("+", getWidth()/3 + getWidth()/3 - 8, getHeight()/2 + 10);
        g.drawString("=", getWidth()-10, getHeight()/2 + 10);
    }
}
