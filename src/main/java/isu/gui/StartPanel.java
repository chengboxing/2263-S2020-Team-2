package isu.gui;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    private JLabel label;
    private StartListener startListener;

    public StartPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        label = new JLabel("ACQUIRE");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
    }
}
