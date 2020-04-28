package isu.gui.graphics;

import isu.engine.GameEngine;
import isu.engine.HotelChain;
import isu.gui.uis.StockCardUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StocksPanel extends JPanel {


    public final static int WIDTH = 40;
    public final static int HEIGHT = 60;
    public final static int Y = 25;
    public final static int X = 5;
    public final static int SPACE_RECT = 55;
    public final static int SPACE_STRING = 10;
    public final static int SPACE = 8;
    GameEngine gameEngine;
    private StockCardUI[] stockCardUIS;
    private ActionListener cardChangedListener;

    public StocksPanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        stockCardUIS = new StockCardUI[GameEngine.MAX_STOCK_PURCHASE_COUNT];
        int w;
        for (int i = 0; i < stockCardUIS.length; i++){
            w = SPACE_RECT * i;
            stockCardUIS[i] = new StockCardUI(X + w, Y, WIDTH, HEIGHT, null);
        }

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tryRemoveStock(e.getX(), e.getY());
            }
        });

    }

    public void setCardChangedListener(ActionListener cardChangedListener) {
        this.cardChangedListener = cardChangedListener;
    }

    public void addChainToCard(HotelChain chain){
        for (StockCardUI stockCardUI: stockCardUIS){
            if (stockCardUI.getStockCardChain() == null){
                stockCardUI.setStockCardChain(chain);
                if (cardChangedListener != null){
                    cardChangedListener.actionPerformed(null);
                }
                System.out.println(chain.getColor());
                break;
            }
        }
        this.repaint();
    }

    public void tryRemoveStock(int x, int y){
        for (StockCardUI stockCardUI: stockCardUIS){
            if (stockCardUI.isOverlapping(x, y)){
                stockCardUI.setStockCardChain(null);
                if (cardChangedListener != null){
                    cardChangedListener.actionPerformed(null);
                }
                break;
            }
        }
        this.repaint();
    }

    public List<HotelChain> getCartStocks(){
        List<HotelChain> chains = new ArrayList<>();
        for (StockCardUI stockCardUI: stockCardUIS){
            if (stockCardUI.getStockCardChain() != null){
                chains.add(stockCardUI.getStockCardChain());
            }
        }
        return chains;
    }

    public int getTotalStocksPrice(){
        int totalPrice = 0;
        for (StockCardUI stockCardUI: stockCardUIS){
            HotelChain chain = stockCardUI.getStockCardChain();
            if (chain != null){
                totalPrice += chain.getStockPrice();
            }
        }
        return totalPrice;
    }

    public int getRemainderPlayerMoney(){
        return gameEngine.getCurrentPlayer().getMoney() - getTotalStocksPrice();
    }

    public void disableAll(){}

    protected void paintComponent(Graphics g){
        for (int i = 0; i < stockCardUIS.length; i++){
            stockCardUIS[i].paintComponent(g);
        }

        g.setColor(Color.BLUE);
        g.setFont(getFont().deriveFont(12.0f));
        g.drawString("+", getWidth()/3 - SPACE, getHeight()/2 + SPACE_STRING);
        g.drawString("+", getWidth()/3 + getWidth()/3 - SPACE, getHeight()/2 + SPACE_STRING);
        g.drawString("=", getWidth() - SPACE_STRING, getHeight()/2 + SPACE_STRING);
    }
}
