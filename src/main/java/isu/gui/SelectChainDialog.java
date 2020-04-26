package isu.gui;

import isu.engine.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EventObject;

public class SelectChainDialog extends JDialog {

    private GameEngine gameEngine;
    private JPanel chainPanel;
    private ButtonGroup btnGroup;

    public SelectChainDialog(JFrame parent, GameEngine gameEngine){

        super(parent, "Create Chain", false);
        JButton btn;
        btn = new JButton("Create Chain");
        this.gameEngine = gameEngine;
        setSize(400, 400);

        btnGroup = new ButtonGroup();
        chainPanel = new JPanel(new BorderLayout());
        chainPanel.setLayout(new GridLayout(gameEngine.getHotelChains().length + 1, 1));

        btn = new JButton("Create Chain");


        for(int i = 0; i < gameEngine.getHotelChains().length; i++){
            JRadioButton chainBtn = new JRadioButton(gameEngine.getHotelChains()[i].getName());
            chainBtn.setActionCommand(gameEngine.getHotelChains()[i].getName());
            btnGroup.add(chainBtn);
            chainPanel.add(chainBtn);
        }

        btn.addActionListener(e -> {
            String chain = btnGroup.getSelection().getActionCommand();
            System.out.println(chain);
            for(int i = 0; i < gameEngine.getHotelChains().length; i++){
                if(gameEngine.getHotelChains()[i].getName().equals(chain)){
                    gameEngine.createTileChain(gameEngine.getHotelChains()[i], gameEngine.getLastPlayedTile());
                    System.out.println("we got here");
                    setVisible(false);

                }
            }

        });
        setLayout(new BorderLayout());
        chainPanel.add(btn);
        add(chainPanel);

    }
}
