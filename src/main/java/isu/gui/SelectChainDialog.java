package isu.gui;

import isu.engine.GameEngine;
import isu.engine.HotelChain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

public class SelectChainDialog extends JDialog {

    private GameEngine gameEngine;
    private JPanel chainPanel;
    private ButtonGroup btnGroup;
    private JButton createBtn;
    private HotelChain selectedChain;

    public SelectChainDialog(JFrame parent, GameEngine gameEngine){

        super(parent, "Create Chain", true);
        this.gameEngine = gameEngine;
        setSize(400, 400);
        setLocationRelativeTo(parent);

        btnGroup = new ButtonGroup();
        chainPanel = new JPanel(new BorderLayout());
        chainPanel.setLayout(new GridLayout(gameEngine.getHotelChains().length + 1, 1));

        createBtn = new JButton("Create Chain");
        createBtn.setEnabled(false);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createBtn.setEnabled(true);
                updateSelectedChain();
            }
        };
        for (HotelChain chain: gameEngine.getInactiveChains()){
            JRadioButton chainBtn = new JRadioButton("(" + chain.getCategory().name() + ") " + chain.getName());
            chainBtn.setBackground(chain.getColor());
            chainBtn.addActionListener(listener);
            chainBtn.setActionCommand(chain.getName());
            btnGroup.add(chainBtn);
            chainPanel.add(chainBtn);
        }

        createBtn.addActionListener(e -> {
            setVisible(false);
        });
        setLayout(new BorderLayout());
        chainPanel.add(createBtn);
        add(chainPanel);

    }

    public HotelChain getSelectedChain() {
        return selectedChain;
    }

    private void updateSelectedChain(){
        List<HotelChain> chains = gameEngine.getInactiveChains();
        String chainName = btnGroup.getSelection().getActionCommand();

        selectedChain = null;
        for (HotelChain chain: chains){
            if (chain.getName().equals(chainName)) {
                selectedChain = chain;
            }
        }
    }
}
