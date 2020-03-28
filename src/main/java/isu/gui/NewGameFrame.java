package isu.gui;

import javax.swing.*;
import java.awt.*;

public class NewGameFrame extends JFrame {

    public  NewGameFrame(){
        super("Acquire Board Game/New Game");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new TestPanel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setVisible(true);
    }
}
