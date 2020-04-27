package isu.gui;

import isu.engine.HotelChain;
import isu.engine.Player;
import isu.engine.Tile;
import isu.gui.graphics.BoardPanel;
import isu.gui.graphics.StocksPanel;
import isu.gui.graphics.TilePanel;
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
    private JButton chainBtn;
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

        //BUTTONS IN THE BUTTON PANEL

        backBtn = new JButton("Back");
        backBtn.addActionListener(e -> frame.showNewGamePanel());

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> frame.showStartPanel());

        actionBtn = new JButton("Apply");
        actionBtn.setPreferredSize(new Dimension(140, actionBtn.getHeight()));
        actionBtn.addActionListener(e -> {
            placeTile();
            setStockPanelEnable(true);

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

        stocksCartPanel = new StocksPanel(frame.gameEngine);
        chainBtnPanel = new JPanel();
        chainBtnPanel.setLayout(new GridLayout(4, 2));

        for(HotelChain chain: frame.gameEngine.getHotelChains()){
            chainBtn = new JButton(chain.getName());
            chainBtn.setOpaque(true);
            chainBtn.setBackground(chain.getColor());
            chainBtn.addActionListener(e -> {
                stocksCartPanel.addChainToCard(chain);
            });
            chainBtnPanel.add(chainBtn);
        }

        stockPricePanel = new JPanel();
        stockPricePanel.setLayout(new GridLayout(2, 1));

        stockBorderPanel.setLayout(new GridLayout(1, 3));

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

        stockBorderPanel.add(chainBtnPanel);
        stockBorderPanel.add(stockCartPanel);
        stockBorderPanel.add(stockPricePanel);
    }

    public void layoutMergePanel(){
        merger = new JPanel(new BorderLayout());
        sellMergePanel = new JPanel();
        keepMergePanel = new JPanel();
        tradeMergePanel = new JPanel();

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
        gameOverviewTableModel.fireTableDataChanged();
        overviewTable.revalidate();
        boardPanel.repaint();
        playerTilePanel.repaint();
        stockCartPanel.repaint();
    }

    public void addStockToCart(){

    }

    public void placeTile(){
        int tileIndex = playerTilePanel.getSelectedTileIndex();
        Tile tile = playerTilePanel.getSelectedTile();
        if(tileIndex == -1) return;
        frame.gameEngine.playTile(tileIndex);

        if (frame.gameEngine.isTileNextToTwoChains(tile)){
            mergeChains(tile);
        } else if (frame.gameEngine.isTileNextToChain(tile)){
            extendChain(tile);
        } else if (frame.gameEngine.isTileNextToTile(tile)){
            createChain(tile);
        }
        playerTilePanel.unselectAll();
        refreshData();
    }

    private void createChain(Tile tile) {
        if (frame.gameEngine.getInactiveChains().isEmpty())return;
        SelectChainDialog dialog = new SelectChainDialog(frame, frame.gameEngine);
        dialog.setVisible(true);
        HotelChain chain = dialog.getSelectedChain();
        frame.gameEngine.createTileChain(chain, tile);
    }

    private void extendChain(Tile tile) {
        final HotelChain chain = frame.gameEngine.getChainsNextToTile(tile).get(0);
        frame.gameEngine.attachTileToChain(chain, tile);
    }

    private void mergeChains(Tile tile) {
    }

    public void setComponentEnable(JComponent component, boolean enabled){
        component.setEnabled(enabled);
        for(Component c: component.getComponents()){
            if(c instanceof JComponent){
                setComponentEnable((JComponent)c, enabled);
            }
        }

    }

    public void setStockPanelEnable(boolean enabled){
        setComponentEnable(stockBorderPanel, enabled);
    }

    public void setMergePanelEnable(boolean enabled){
        setComponentEnable(mergeBorderPanel, enabled);
    }
}
