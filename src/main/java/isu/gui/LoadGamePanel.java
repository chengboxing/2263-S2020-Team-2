package isu.gui;

import javax.swing.*;
import java.awt.*;

public class LoadGamePanel extends JPanel {
    MainFrame frame;
    public LoadGamePanel(MainFrame frame){
        this.frame = frame;

        JPanel buttonPanel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton cancel = new JButton("Cancel");
        JButton load = new JButton("Load");
        JScrollPane scrollPane = new JScrollPane(new JTable());



        setLayout(new BorderLayout());




    }
}
