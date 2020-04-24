package isu.gui;

import isu.engine.Player;
import isu.engine.Tile;
import isu.gui.models.GameOverviewTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel {

    public static final Color BROWN = new Color(153, 102, 0);
    public static final Color PURPLE = new Color(102, 0, 153);

     MainFrame frame;
    private BoardPanel boardPanel;
    private TilePanel playerTilePanel;
    private StocksPanel stocksPanel;
    private JButton back;
    private JButton quit;
    private JTable overviewTable;
    private JPanel toolbar;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel rightUpperPanel;
    private JPanel rightLowerPanel;
    private JPanel leftUpperPanel;
    private JPanel leftLowerPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel topTopPanel;
    private JPanel tilePanel;
    private JPanel stockPanel;
    private JPanel mergePanel;
    private JPanel walletPanel;
    private JButton actionBtn;
    private JPanel chains;
    private JPanel stocks;
    private JPanel price;
    private JButton c1;
    private JButton c2;
    private JButton c3;
    private JButton c4;
    private JButton c5;
    private JButton c6;
    private JButton c7;
    private JLabel cost;
    private JLabel remainder;
    private JPanel merger;
    private JPanel sell;
    private JPanel keep;
    private JPanel trade;
    private JSpinner sellSpinner;
    private JSpinner keepSpinner;
    private JSpinner tradeSpinner;
    private JPanel namePanel;
    private JPanel cashTotalPanel;
    private JPanel netWorth;
    private JButton endGame;
    private JLabel currentPlayerNameLabel;
    private GameOverviewTableModel gameOverviewTableModel;
    private JLabel currentPlayerCashTotalLabel;
    private JButton switchPlayerBtn;


    public GamePanel(MainFrame frame){
        this.frame = frame;

        SpinnerModel value = new SpinnerNumberModel(0, 0, 25, 1);
        SpinnerModel value2 = new SpinnerNumberModel(0, 0, 25, 1);
        SpinnerModel specialValue = new SpinnerNumberModel(0, 0, 24, 2);

        merger = new JPanel(new BorderLayout());
        sell = new JPanel();
        keep = new JPanel();
        trade = new JPanel();
        namePanel = new JPanel();
        cashTotalPanel = new JPanel();
        netWorth = new JPanel();
        sellSpinner = new JSpinner(value);
        keepSpinner = new JSpinner(value2);
        tradeSpinner = new JSpinner(specialValue);
        mainPanel = new JPanel(new BorderLayout());
        rightUpperPanel = new JPanel(new BorderLayout());
        leftLowerPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());
        toolbar = new JPanel(new FlowLayout());
        boardPanel = new BoardPanel(frame.gameEngine);
        playerTilePanel = new TilePanel(frame.gameEngine);
        stocksPanel = new StocksPanel();
        back = new JButton("Back");
        quit = new JButton("Quit");
        actionBtn = new JButton("Apply");
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
        rightLowerPanel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize(){ return new Dimension(rightPanel.getWidth(), rightPanel.getHeight()/3); }
        };
        topPanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout(){
            public Dimension setPreferredSize(){return new Dimension(frame.getWidth(), frame.getHeight()/4);}
        });
        topTopPanel = new JPanel(new BorderLayout());
        stockPanel = new JPanel(new BorderLayout());
        mergePanel = new JPanel(new BorderLayout());
        walletPanel = new JPanel(new BorderLayout());
        tilePanel = new JPanel(new BorderLayout());
        chains = new JPanel();
        stocks = new JPanel();
        price = new JPanel();
        c1 = new JButton("Tower");
        c2 = new JButton("Luxor");
        c3 = new JButton("American");
        c4 = new JButton("WorldWide");
        c5 = new JButton("Festival");
        c6 = new JButton("Imperial");
        c7 = new JButton("Continental");
        cost = new JLabel("$$$");
        remainder = new JLabel("-$$$");




        //creating borders for all panels
        Border gameHistoryBorder = BorderFactory.createTitledBorder("Game History");
        Border boardBorder = BorderFactory.createTitledBorder("Board");
        Border playerBorder = BorderFactory.createTitledBorder("Player");
        Border dataBorder = BorderFactory.createTitledBorder("Current Data");
        Border tileBorder = BorderFactory.createTitledBorder("Tiles");
        Border stockBorder = BorderFactory.createTitledBorder("Stocks");
        Border mergeBorder = BorderFactory.createTitledBorder("Merge");
        Border walletBorder = BorderFactory.createTitledBorder("Wallet");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        //applying borders to all panels
        rightLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, gameHistoryBorder));
        rightUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, boardBorder));
        leftUpperPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, dataBorder));
        leftLowerPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, playerBorder));
        stockPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, stockBorder));
        mergePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, mergeBorder));
        walletPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, walletBorder));
        tilePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, tileBorder));
        walletPanel.setPreferredSize(new Dimension(200, 80));
        actionBtn.setPreferredSize(new Dimension(140, actionBtn.getHeight()));


        //actionListeners added to the buttons
        back.addActionListener(e -> frame.showNewGamePanel());
        quit.addActionListener(e -> frame.showStartPanel());
        endGame.addActionListener(e -> frame.showStartPanel());

        //adding board to panel
        rightUpperPanel.add(boardPanel);

        rightLowerPanel.add(switchPlayerBtn, BorderLayout.CENTER);

        //adding table to panel
        leftUpperPanel.add(new JScrollPane(overviewTable));

        topPanel.setLayout(new GridLayout(3, 1));

        bottomPanel.setLayout(new BorderLayout());


        tilePanel.add(playerTilePanel, BorderLayout.CENTER);


        //sets the layout for this class panel
        setLayout(new BorderLayout());

        //add buttons to the toolbar
        toolbar.add(back);
        toolbar.add(quit);
        toolbar.add(endGame);

        //add the left panel and right panel to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        //add upper and lower panels to the right panel
        rightPanel.add(rightUpperPanel, BorderLayout.CENTER);
        rightPanel.add(rightLowerPanel, BorderLayout.SOUTH);

        //add upper and lower left panels to the left panel
        leftPanel.add(leftUpperPanel, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.CENTER);

        leftLowerPanel.add(topPanel, BorderLayout.CENTER);
        leftLowerPanel.add(bottomPanel, BorderLayout.SOUTH);

        topPanel.add(topTopPanel);
        topPanel.add(stockPanel);
        topPanel.add(mergePanel);

        bottomPanel.add(walletPanel, BorderLayout.SOUTH);

        topTopPanel.add(tilePanel, BorderLayout.CENTER);
        topTopPanel.add(actionBtn, BorderLayout.EAST);

        //add mainPanel and toolBar to gamePanel(mainFrame)
        add(mainPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);


        layoutStockPanel();
        layoutMergePanel();
        layoutWalletPanel();

    }

    public void layoutStockPanel(){

        stockPanel.add(chains);
        stockPanel.add(stocks);
        stockPanel.add(price);

        stockPanel.setLayout(new GridLayout(1, 3));

        chains.setLayout(new GridLayout(4, 2));
        stocks.setLayout(new BorderLayout());
        price.setLayout(new GridLayout(2, 1));

        chains.add(c1);
        chains.add(c2);
        chains.add(c3);
        chains.add(c4);
        chains.add(c5);
        chains.add(c6);
        chains.add(c7);

        stocks.add(stocksPanel, BorderLayout.CENTER);

        Border chainBorder = BorderFactory.createTitledBorder("HotelChains");
        Border stocksBorder = BorderFactory.createTitledBorder("Stock Cart");
        Border costBorder = BorderFactory.createTitledBorder("Price");
        Border remainderBorder = BorderFactory.createTitledBorder("Wallet Deduction");
        Border outerBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);

        chains.setBorder(BorderFactory.createCompoundBorder(outerBorder, chainBorder));
        stocks.setBorder(BorderFactory.createCompoundBorder(outerBorder, stocksBorder));
        cost.setBorder(BorderFactory.createCompoundBorder(outerBorder, costBorder));
        remainder.setBorder(BorderFactory.createCompoundBorder(outerBorder, remainderBorder));
        price.add(cost);
        price.add(remainder);
    }

    public void layoutMergePanel(){
        mergePanel.add(merger);
        mergePanel.add(sell);
        mergePanel.add(trade);
        mergePanel.add(keep);

        mergePanel.setLayout(new GridLayout(1, 4));

        merger.setLayout(new BorderLayout());
        sell.setLayout(new GridLayout(2, 1));
        trade.setLayout(new GridLayout(2, 1));
        keep.setLayout(new GridLayout(2, 1));


        merger.setBackground(Color.YELLOW);

        Border sellBorder = BorderFactory.createTitledBorder("Sell Stock");
        Border tradeBorder = BorderFactory.createTitledBorder("Trade Stock");
        Border keepBorder = BorderFactory.createTitledBorder("Keep Stock");
        Border outerBorder = BorderFactory.createEmptyBorder(1, 1,1, 1);



        sell.setBorder(BorderFactory.createCompoundBorder(outerBorder, sellBorder));
        sell.add(sellSpinner);

        trade.setBorder(BorderFactory.createCompoundBorder(outerBorder, tradeBorder));
        trade.add(tradeSpinner);

        keep.setBorder(BorderFactory.createCompoundBorder(outerBorder, keepBorder));
        keep.add(keepSpinner);

    }

    public void layoutWalletPanel(){
        walletPanel.add(namePanel);
        walletPanel.add(cashTotalPanel);
        walletPanel.add(netWorth);

        walletPanel.setLayout(new GridLayout(1, 3));

        namePanel.setLayout(new BorderLayout());
        cashTotalPanel.setLayout(new BorderLayout());
        netWorth.setLayout(new BorderLayout());

        Border nameBorder = BorderFactory.createTitledBorder("Player Info");
        Border walletBorder = BorderFactory.createTitledBorder("Cash Total");
        Border netBorder = BorderFactory.createTitledBorder("Net-Worth Total ");
        Border outerBorder = BorderFactory.createEmptyBorder(1, 1,1, 1);

        namePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, nameBorder));
        cashTotalPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, walletBorder));
        netWorth.setBorder(BorderFactory.createCompoundBorder(outerBorder, netBorder));

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
}
