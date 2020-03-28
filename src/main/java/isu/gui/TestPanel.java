package isu.gui;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {

    protected void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(10, 10, 50, 50);
    }
}
