package isu.gui;

import isu.engine.GameEngine;
import isu.gui.models.PlayerTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewGamePanel extends JPanel {

    private MainFrame frame;
    private GameEngine gameEngine;
    private JSlider slider;
    private JTextField playerField;
    private JTextField gameField;
    private JTable playerTable;
    private PlayerTableModel playerTableModel;

    public NewGamePanel(MainFrame frame) {
        this.frame = frame;
        gameEngine = frame.gameEngine;

        Border innerBorder3 = BorderFactory.createTitledBorder("Number of Players");
        Border innerBorder2 = BorderFactory.createTitledBorder("Game Name");
        Border innerBorder1 = BorderFactory.createTitledBorder("Players");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);


        slider = new JSlider(0, 6);
        JLabel label = new JLabel("Player Name : ");
        JLabel gameLabel = new JLabel("Game Name : ");
        gameField = new JTextField(20);
        playerField = new JTextField(45);
        JButton addPlayerBtn = new JButton("Add Player");



        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel rightUpperPanel = new JPanel(new BorderLayout());
        JPanel rightLowerPanel = new JPanel(new BorderLayout());
        playerTableModel = new PlayerTableModel(gameEngine);
        playerTable = new JTable(playerTableModel);
        rightLowerPanel.add(new JScrollPane(playerTable), BorderLayout.CENTER);

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
        JButton cancelBtn = new JButton("Cancel");
        JButton startBtn = new JButton("Start");

        startBtn.setEnabled(false);


        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder2));
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder3));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder1));


        //setting left panels
        leftUpperPanel.setLayout(new FlowLayout());
        leftUpperPanel.add(gameLabel);
        leftUpperPanel.add(gameField);

        //Grid bag layout
        rightUpperPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.ABOVE_BASELINE;
        gc.gridheight = 25;
        rightUpperPanel.add(label, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        rightUpperPanel.add(playerField);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        rightUpperPanel.add(addPlayerBtn);

        gameField.setText("Acquire");

        //creating table for players
        rightLowerPanel.setLayout(new GridLayout(7, 1));

        //creating slider
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(0);
        slider.setMaximum(gameEngine.MAX_PLAYERS);

        //add slider to panel
        leftLowerPanel.add(slider);

        //add action listeners to buttons
        cancelBtn.addActionListener(e -> frame.showStartPanel());


        startBtn.addActionListener(e -> {
            gameEngine.initGame();
            frame.showGamePanel();
        });

        addPlayerBtn.addActionListener(e -> {
            String name = playerField.getText();
            gameEngine.addPlayer(name);
            playerField.setText("");
            playerTable.revalidate();
            slider.setValue(slider.getValue()+1);
            startBtn.setEnabled(true);
        });

//        addPlayerBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String name = playerField.getText();
//
//
//
//                GameEvent ge = new GameEvent(this, name);
//
//                System.out.println(name);
//            }
//        });


        setLayout(new BorderLayout());

        btnPanel.add(cancelBtn, BorderLayout.WEST);
        btnPanel.add(startBtn, BorderLayout.EAST);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        rightPanel.add(rightUpperPanel, BorderLayout.NORTH);
        rightPanel.add(rightLowerPanel, BorderLayout.CENTER);

        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);


    }
}
