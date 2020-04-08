package isu.gui;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    MainFrame frame;



    public StartPanel(MainFrame frame){
        this.frame = frame;

        JPanel labelPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("Acquire");
        JButton btn1 = new JButton("Start New Game");
        JButton btn2 = new JButton("Load Game");
        JButton btn3 = new JButton("Exit");

        btn1.addActionListener(e -> frame.showNewGamePanel());
        btn2.addActionListener(e -> frame.showLoadGamePanel());
        btn3.addActionListener(e -> System.exit(0));

        label.setFont(label.getFont ().deriveFont (108.0f));



        setLayout(new BorderLayout());

        labelPanel.add(label);
        labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);

        add(labelPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


    }

}
