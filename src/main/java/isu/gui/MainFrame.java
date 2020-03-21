package isu.gui;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

//    private JTextArea textArea;
    private StartPanel startPanel;


    public MainFrame(){
        super("Acquire Board Game");

        setLayout(new BorderLayout());

//        textArea = new JTextArea();
        startPanel = new StartPanel();
        addComponents(super.getContentPane());

        JButton btn1 = (JButton) super.getContentPane().getComponent(0);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.super.dispose();
                new NewGameFrame();
            }
        });

        JButton btn3 = (JButton) super.getContentPane().getComponent(2);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit this application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        super.pack();
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

    }


    public static void addComponents(Container panel) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addBtn("Start New Game", panel);
        addBtn("Load Game", panel);
        addBtn("Exit",panel);


    }

    private static void addBtn(String text, Container container) {
        JButton btn = new JButton(text);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(btn);
    }


}
