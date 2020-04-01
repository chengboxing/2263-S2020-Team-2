package isu.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {

    MainFrame frame;
    JPanel lp = new JPanel();
    JLabel label = new JLabel("Acquire");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel btns;
    JButton btn1 = new JButton("Start New Game");
    JButton btn2 = new JButton("Load Game");
    JButton btn3 = new JButton("Exit");


    public StartPanel(MainFrame frame){
        this.frame = frame;

        btns = new JPanel();
        panel.add(btns, BorderLayout.SOUTH);
        btns.setLayout(new GridLayout(3, 1));
        btns.add(btn1);
        btns.add(btn2);
        btns.add(btn3);

        btn1.addActionListener(e -> frame.showNewGamePanel());
        btn2.addActionListener(e -> frame.showLoadGamePanel());
        btn3.addActionListener(e -> System.exit(0));

        label.setFont(label.getFont ().deriveFont (84.0f));
        add(label, BorderLayout.CENTER);

        panel.setLayout(new GridLayout());
        panel.add(label, BorderLayout.CENTER);




        add(panel);
        setBackground(Color.WHITE);


//        JButton btn1 = new JButton("Start New Game");
//        btn1.addActionListener(e -> frame.showNewGamePanel());
//        add(btn1, BorderLayout.SOUTH);
//
//        JButton btn2 = new JButton("Load Game");
//        btn2.addActionListener(e -> frame.showLoadGamePanel());
//        add(btn2, BorderLayout.AFTER_LAST_LINE);
//
//        JButton btn3 = new JButton("Exit");
//        btn3.addActionListener(e -> System.exit(0));
//        add(btn3, BorderLayout.AFTER_LAST_LINE);





    }

}
