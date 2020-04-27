package isu.gui;

import isu.engine.StockSet;

import java.awt.*;

public class StockCardUI extends ComponentUI {

    private StockSet stockSet;

    public StockCardUI(int x, int y, int width, int height, StockSet stockSet) {
        super(x, y, width, height);
        this.stockSet = stockSet;
    }

    public StockSet getStockSet() {
        return stockSet;
    }

    public void setStockSet(StockSet stockSet) {
        this.stockSet = stockSet;
    }

    @Override
    public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.drawRect(x, y, width, height);
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
    }
}
