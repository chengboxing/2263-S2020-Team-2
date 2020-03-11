package isu.gui;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel label;
    private FormListener formListener;

    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        label = new JLabel("ACQUIRE");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
    }
}
