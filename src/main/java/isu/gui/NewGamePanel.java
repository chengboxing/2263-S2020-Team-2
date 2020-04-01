package isu.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class NewGamePanel extends JPanel {

    MainFrame frame;
    public NewGamePanel(MainFrame frame) {
        this.frame = frame;

        Border innerBorder3 = BorderFactory.createTitledBorder("Number of Players");
        Border innerBorder2 = BorderFactory.createTitledBorder("Game Name");
        Border innerBorder1 = BorderFactory.createTitledBorder("Players");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);


        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(frame.getWidth()/3, frame.getHeight());
            }
        };
        JPanel leftUpperPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/2);
            }
        };
        JPanel leftLowerPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/2);
            }
        };
        JButton cancel = new JButton("Cancel");
        JButton start = new JButton("Start");

        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder2));
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder3));


        cancel.addActionListener(e -> frame.showStartPanel());
        start.addActionListener(e -> frame.showGamePanel());

        rightPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder1));

        setLayout(new BorderLayout());

        btnPanel.add(cancel, BorderLayout.WEST);
        btnPanel.add(start, BorderLayout.EAST);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);


    }

}
