package isu.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel {

     MainFrame frame;
    private BoardPanel boardPanel;
    private PlayerPanel playerPanel;
    private JButton back;
    private JButton quit;
    private JTable table;
    private JPanel toolbar;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel rightUpperPanel;
    private JPanel rightLowerPanel;
    private JPanel leftUpperPanel;
    private JPanel leftLowerPanel;



    public GamePanel(MainFrame frame){
        this.frame = frame;

        //jTable data info
        String data[][]={ {"Player1", "0", "0", "0", "0", "0", "0", "0"},
                {"Player2", "0", "0", "0", "0", "0", "0", "0"},
                {"Stock", "25", "25", "25", "25", "25", "25", "25"},
                {"ChainSize", "0", "0", "0", "0", "0", "0", "0"},
                {"Stock$", "0", "0", "0", "0", "0", "0", "0"}};
        String column[]={"  ","Chain1","Chain2", "Chain3", "Chain4", "Chain5", "Chain6", "Chain7"};

        //initializing
        mainPanel = new JPanel(new BorderLayout());
        rightUpperPanel = new JPanel(new BorderLayout());
        leftLowerPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());
        toolbar = new JPanel(new BorderLayout());
        boardPanel = new BoardPanel();
        playerPanel = new PlayerPanel();
        back = new JButton("Back");
        quit = new JButton("Quit");
        table = new JTable(data, column);
        leftPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(frame.getWidth()/2, frame.getHeight());
            }
        };
        leftUpperPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){ return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/3); }
        };
        rightLowerPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){ return new Dimension(rightPanel.getWidth(), rightPanel.getHeight()/3); }
        };


        //creating borders for all panels
        Border gameHistoryBorder = BorderFactory.createTitledBorder("Game History");
        Border boardBorder = BorderFactory.createTitledBorder("Board");
        Border playerBorder = BorderFactory.createTitledBorder("Player");
        Border dataBorder = BorderFactory.createTitledBorder("Current Data");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        //applying borders to all panels
        rightLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, gameHistoryBorder));
        rightUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, boardBorder));
        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, dataBorder));
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, playerBorder));

        //actionListeners added to the buttons
        back.addActionListener(e -> frame.showNewGamePanel());
        quit.addActionListener(e -> frame.showStartPanel());

        //adding board to panel
        rightUpperPanel.add(boardPanel);

        //adding table to panel
        leftUpperPanel.add(new JScrollPane(table));

        //adding player panel to left lower panel
        leftLowerPanel.add(playerPanel);

        /////// GridBagLayout for left lower panel ///////////
        leftLowerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        //sets the layout for this class panel
        setLayout(new BorderLayout());

        //add buttons to the toolbar
        toolbar.add(back, BorderLayout.WEST);
        toolbar.add(quit);

        //add the left panel and right panel to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        //add upper and lower panels to the right panel
        rightPanel.add(rightUpperPanel, BorderLayout.CENTER);
        rightPanel.add(rightLowerPanel, BorderLayout.SOUTH);

        //add upper and lower left panels to the left panel
        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.CENTER);

        //add mainPanel and toolBar to gamePanel(mainFrame)
        add(mainPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);



    }

}
