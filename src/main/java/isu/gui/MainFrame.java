package isu.gui;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;

public class MainFrame extends JFrame {

//    private JTextArea textArea;
    JFrame frame = new JFrame();


    public MainFrame(){
        super("Acquire Board Game");

        setLayout(new BorderLayout());

//        textArea = new JTextArea();
        addComponents(super.getContentPane());

        super.pack();
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
