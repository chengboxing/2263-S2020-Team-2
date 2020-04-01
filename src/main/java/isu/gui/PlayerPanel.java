package isu.gui;

import isu.engine.Board;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private JPanel main;
    private JPanel tilePanel;
    private JPanel stockPanel;
    private JPanel mergePanel;
    private JPanel wallet;
    private JButton actionBtn;


    public PlayerPanel(){
        main = new JPanel(new BorderLayout());
        tilePanel = new JPanel(new BorderLayout());
        stockPanel = new JPanel();
        mergePanel = new JPanel();
        wallet = new JPanel();
        actionBtn = new JButton("Apply");

        add(main, BorderLayout.NORTH);
        main.add(actionBtn, BorderLayout.EAST);
        main.add(tilePanel, BorderLayout.CENTER);


        setLayout(new BorderLayout());

    }
}
