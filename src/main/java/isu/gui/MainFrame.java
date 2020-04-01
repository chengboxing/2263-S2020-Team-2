package isu.gui;

import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {


    Container container;
    CardLayout cardLayout;

    StartPanel startPanel;
    GamePanel gamePanel;
    NewGamePanel newGamePanel;
    LoadGamePanel loadGamePanel;


    public MainFrame(){

        startPanel = new StartPanel(this);
        newGamePanel = new NewGamePanel(this);
        loadGamePanel = new LoadGamePanel(this);
        gamePanel = new GamePanel(this);

        cardLayout = new CardLayout();
        container = getContentPane();
        container.setLayout(cardLayout);

        container.add(startPanel, "start");
        container.add(newGamePanel, "new");
        container.add(loadGamePanel, "load");
        container.add(gamePanel, "game");

        cardLayout.show(container, "start");
    }

    public void showStartPanel(){
        cardLayout.show(container, "start");
    }

    public void showNewGamePanel() {
        cardLayout.show(container, "new");
    }

    public void showLoadGamePanel(){
        cardLayout.show(container, "load");
    }

    public void showGamePanel(){
        cardLayout.show(container, "game");
    }

}