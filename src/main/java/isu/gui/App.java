package isu.gui;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        //for multi threading Swing applications
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });


    }
}
