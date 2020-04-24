package isu.gui;

import isu.engine.Player;
import isu.gui.models.GameOverviewTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel {

     MainFrame frame;
    private BoardPanel boardPanel;
    private TilePanel playerTilePanel;
    private StocksPanel stocksCartPanel;
    private JButton backBtn;
    private JButton quitBtn;
    private JTable overviewTable;
    private JPanel btnPanel;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel rightUpperPanel;
    private JPanel rightLowerPanel;
    private JPanel leftUpperPanel;
    private JPanel leftLowerPanel;
    private JPanel bottomPlayerPanel;
    private JPanel topPlayerPanel;
    private JPanel tileAndBtnPanel;
    private JPanel tileBorderPanel;
    private JPanel stockBorderPanel;
    private JPanel mergeBorderPanel;
    private JPanel walletBorderPanel;
    private JButton actionBtn;
    private JPanel chainBtnPanel;
    private JPanel stockCartPanel;
    private JPanel stockPricePanel;
    private JButton chain1Btn;
    private JButton chain2Btn;
    private JButton chain3Btn;
    private JButton chain4Btn;
    private JButton chain5Btn;
    private JButton chain6Btn;
    private JButton chain7Btn;
    private JLabel stockCostLabel;
    private JLabel stockWalletRemainderLabel;
    private JPanel merger;
    private JPanel sellMergePanel;
    private JPanel keepMergePanel;
    private JPanel tradeMergePanel;
    private JSpinner sellSpinner;
    private JSpinner keepSpinner;
    private JSpinner tradeSpinner;
    private JPanel namePanel;
    private JPanel cashTotalPanel;
    private JButton endGame;
    private JLabel currentPlayerNameLabel;
    private GameOverviewTableModel gameOverviewTableModel;
    private JLabel currentPlayerCashTotalLabel;
    private JButton switchPlayerBtn;

    public GamePanel(MainFrame frame){
        this.frame = frame;

        //spinners for the merge panel
        SpinnerModel value = new SpinnerNumberModel(0, 0, 25, 1);
        sellSpinner = new JSpinner(value);
        SpinnerModel value2 = new SpinnerNumberModel(0, 0, 25, 1);
        keepSpinner = new JSpinner(value2);
        SpinnerModel specialValue = new SpinnerNumberModel(0, 0, 24, 2);
        tradeSpinner = new JSpinner(specialValue);

        //merge panel components
        merger = new JPanel(new BorderLayout());
        sellMergePanel = new JPanel();
        keepMergePanel = new JPanel();
        tradeMergePanel = new JPanel();

        //wallet panel components
        namePanel = new JPanel();
        cashTotalPanel = new JPanel();

        mainPanel = new JPanel(new BorderLayout());
        rightUpperPanel = new JPanel(new BorderLayout());
        leftLowerPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());
        btnPanel = new JPanel(new FlowLayout());
        boardPanel = new BoardPanel(frame.gameEngine);
        playerTilePanel = new TilePanel(frame.gameEngine);
        stocksCartPanel = new StocksPanel();

        //BUTTONS IN THE BUTTON PANEL

        backBtn = new JButton("Back");
        backBtn.addActionListener(e -> frame.showNewGamePanel());

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> frame.showStartPanel());

        actionBtn = new JButton("Apply");
        actionBtn.setPreferredSize(new Dimension(140, actionBtn.getHeight()));
        actionBtn.addActionListener(e -> {
            int tileIndex = playerTilePanel.getSelectedTileIndex();
            if(tileIndex == -1) return;
            frame.gameEngine.playTile(tileIndex);
            playerTilePanel.unselectAll();
            refreshData();
        });

        switchPlayerBtn = new JButton("Switch Player");
        switchPlayerBtn.addActionListener(e -> {
            frame.gameEngine.nextTurn();
            refreshData();
        });

        endGame = new JButton("End Game");
        endGame.addActionListener(e -> frame.showStartPanel());

        //GAME OVERVIEW TABLE AND MODEL

        gameOverviewTableModel = new GameOverviewTableModel(frame.gameEngine);
        overviewTable = new JTable(gameOverviewTableModel);

        leftPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){
                return new Dimension(frame.getWidth()/2, frame.getHeight());
            }
        };

        leftUpperPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){ return new Dimension(leftPanel.getWidth(), leftPanel.getHeight()/5); }
        };
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border dataBorder = BorderFactory.createTitledBorder("Current Data");
        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, dataBorder));

        rightLowerPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){ return new Dimension(rightPanel.getWidth(), rightPanel.getHeight()/3); }
        };
        Border gameHistoryBorder = BorderFactory.createTitledBorder("Game History");
        rightLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, gameHistoryBorder));

        bottomPlayerPanel = new JPanel(new BorderLayout());
        topPlayerPanel = new JPanel(new BorderLayout(){
            public Dimension setPreferredSize(){return new Dimension(frame.getWidth(), frame.getHeight()/4);}
        });

        tileAndBtnPanel = new JPanel(new BorderLayout());

        stockBorderPanel = new JPanel(new BorderLayout());
        Border stockBorder = BorderFactory.createTitledBorder("Stocks");
        stockBorderPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, stockBorder));

        mergeBorderPanel = new JPanel(new BorderLayout());
        Border mergeBorder = BorderFactory.createTitledBorder("Merge");
        mergeBorderPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, mergeBorder));

        walletBorderPanel = new JPanel(new BorderLayout());
        Border walletBorder = BorderFactory.createTitledBorder("Info");
        walletBorderPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, walletBorder));
        walletBorderPanel.setPreferredSize(new Dimension(200, 80));

        tileBorderPanel = new JPanel(new BorderLayout());
        Border tileBorder = BorderFactory.createTitledBorder("Tiles");
        tileBorderPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, tileBorder));

        Border playerBorder = BorderFactory.createTitledBorder("Player");
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, playerBorder));


        Border boardBorder = BorderFactory.createTitledBorder("Board");
        rightUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, boardBorder));


        bottomPlayerPanel.setLayout(new GridLayout(3, 1));
        topPlayerPanel.setLayout(new BorderLayout());

        ////// ADDING ALL PANELS TO ALL INNER PANELS ///////


        //adding player tiles panel to the outer tile panel
        tileBorderPanel.add(playerTilePanel, BorderLayout.CENTER);

        //adding board to panel
        rightUpperPanel.add(boardPanel);

        rightLowerPanel.add(switchPlayerBtn, BorderLayout.CENTER);

        //adding table to panel
        leftUpperPanel.add(new JScrollPane(overviewTable));

        //sets the layout for this class panel
        setLayout(new BorderLayout());

        //add buttons to the btn panel
        btnPanel.add(backBtn);
        btnPanel.add(quitBtn);
        btnPanel.add(endGame);

        //add the left panel and right panel to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        //add upper and lower panels to the right panel
        rightPanel.add(rightUpperPanel, BorderLayout.CENTER);
        rightPanel.add(rightLowerPanel, BorderLayout.SOUTH);

        //add upper and lower left panels to the left panel
        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.CENTER);

        //adding all panels to inner player panels
        leftLowerPanel.add(bottomPlayerPanel, BorderLayout.CENTER);
        leftLowerPanel.add(topPlayerPanel, BorderLayout.NORTH);

        bottomPlayerPanel.add(tileAndBtnPanel);
        bottomPlayerPanel.add(stockBorderPanel);
        bottomPlayerPanel.add(mergeBorderPanel);

        topPlayerPanel.add(walletBorderPanel, BorderLayout.NORTH);

        tileAndBtnPanel.add(tileBorderPanel, BorderLayout.CENTER);
        tileAndBtnPanel.add(actionBtn, BorderLayout.EAST);

        //add mainPanel and toolBar to gamePanel(mainFrame)
        add(mainPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.NORTH);


        //layout of player panel components
        layoutStockPanel();
        layoutMergePanel();
        layoutWalletPanel();

    }

    public void layoutStockPanel(){

        chainBtnPanel = new JPanel();
        chainBtnPanel.setLayout(new GridLayout(4, 2));
        chain1Btn = new JButton(frame.gameEngine.getHotelChains()[0].getName());
        chain2Btn = new JButton(frame.gameEngine.getHotelChains()[1].getName());
        chain3Btn = new JButton(frame.gameEngine.getHotelChains()[2].getName());
        chain4Btn = new JButton(frame.gameEngine.getHotelChains()[3].getName());
        chain5Btn = new JButton(frame.gameEngine.getHotelChains()[4].getName());
        chain6Btn = new JButton(frame.gameEngine.getHotelChains()[5].getName());
        chain7Btn = new JButton(frame.gameEngine.getHotelChains()[6].getName());

        stockPricePanel = new JPanel();
        stockPricePanel.setLayout(new GridLayout(2, 1));

        stockBorderPanel.add(chainBtnPanel);
        stockBorderPanel.add(stockCartPanel);
        stockBorderPanel.add(stockPricePanel);


        stockBorderPanel.setLayout(new GridLayout(1, 3));

        chainBtnPanel.add(chain1Btn);
        chainBtnPanel.add(chain2Btn);
        chainBtnPanel.add(chain3Btn);
        chainBtnPanel.add(chain4Btn);
        chainBtnPanel.add(chain5Btn);
        chainBtnPanel.add(chain6Btn);
        chainBtnPanel.add(chain7Btn);


        Border outerBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);

        Border chainBorder = BorderFactory.createTitledBorder("HotelChains");
        chainBtnPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, chainBorder));

        stockCartPanel = new JPanel();
        stockCartPanel.setLayout(new BorderLayout());
        Border stocksBorder = BorderFactory.createTitledBorder("Stock Cart");
        stockCartPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, stocksBorder));

        stockCostLabel = new JLabel("$$$");
        Border costBorder = BorderFactory.createTitledBorder("Price");
        stockCostLabel.setBorder(BorderFactory.createCompoundBorder(outerBorder, costBorder));

        stockWalletRemainderLabel = new JLabel("-$$$");
        Border remainderBorder = BorderFactory.createTitledBorder("Wallet Deduction");
        stockWalletRemainderLabel.setBorder(BorderFactory.createCompoundBorder(outerBorder, remainderBorder));

        stockCartPanel.add(stocksCartPanel, BorderLayout.CENTER);
        stockPricePanel.add(stockCostLabel);
        stockPricePanel.add(stockWalletRemainderLabel);
    }

    public void layoutMergePanel(){
        mergeBorderPanel.add(merger);
        mergeBorderPanel.add(sellMergePanel);
        mergeBorderPanel.add(tradeMergePanel);
        mergeBorderPanel.add(keepMergePanel);

        mergeBorderPanel.setLayout(new GridLayout(1, 4));

        merger.setLayout(new BorderLayout());
        sellMergePanel.setLayout(new GridLayout(2, 1));
        tradeMergePanel.setLayout(new GridLayout(2, 1));
        keepMergePanel.setLayout(new GridLayout(2, 1));


        merger.setBackground(Color.YELLOW);

        Border sellBorder = BorderFactory.createTitledBorder("Sell Stock");
        Border tradeBorder = BorderFactory.createTitledBorder("Trade Stock");
        Border keepBorder = BorderFactory.createTitledBorder("Keep Stock");
        Border outerBorder = BorderFactory.createEmptyBorder(1, 1,1, 1);

        sellMergePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, sellBorder));
        sellMergePanel.add(sellSpinner);

        tradeMergePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, tradeBorder));
        tradeMergePanel.add(tradeSpinner);

        keepMergePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, keepBorder));
        keepMergePanel.add(keepSpinner);

    }

    public void layoutWalletPanel(){
        
        Border outerBorder = BorderFactory.createEmptyBorder(1, 1,1, 1);

        walletBorderPanel.add(namePanel);
        walletBorderPanel.add(cashTotalPanel);
        walletBorderPanel.setLayout(new GridLayout(1, 2));

        cashTotalPanel.setLayout(new BorderLayout());
        Border walletBorder = BorderFactory.createTitledBorder("Cash Total");
        cashTotalPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, walletBorder));

        namePanel.setLayout(new BorderLayout());
        Border nameBorder = BorderFactory.createTitledBorder("Player Name");
        namePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, nameBorder));

        currentPlayerCashTotalLabel = new JLabel();
        cashTotalPanel.add(currentPlayerCashTotalLabel);

        currentPlayerNameLabel = new JLabel();
        namePanel.add(currentPlayerNameLabel);
    }

    public void refreshData(){
        Player player = frame.gameEngine.getCurrentPlayer();
        currentPlayerNameLabel.setText(player.getName());
        currentPlayerCashTotalLabel.setText(String.format("$%d.00", player.getMoney()));
        overviewTable.revalidate();
        boardPanel.repaint();
        playerTilePanel.repaint();
    }

    public void disableStocksPanel(){
        Component[] components = chainBtnPanel.getComponents();
        Component[] components2 = stockPricePanel.getComponents();
        for(int i = 0; i < components.length; i++){
            components[i].setEnabled(false);
            chainBtnPanel.setEnabled(false);

        }
    }

    public void disableTilesPanel(){
        Component[] components = tileBorderPanel.getComponents();
        for(int i = 0; i< components.length; i++) {
            components[i].setEnabled(false);
            tileBorderPanel.setEnabled(false);
        }
    }

    public void disableMergePanel(){
        Component[] components = mergeBorderPanel.getComponents();
        for(int i = 0; i < components.length; i++) {
            components[i].setEnabled(false);
            mergeBorderPanel.setEnabled(false);
        }
    }
}
