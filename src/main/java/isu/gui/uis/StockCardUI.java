package isu.gui.uis;

import isu.engine.HotelChain;
import isu.engine.StockSet;
import isu.gui.uis.ComponentUI;

import java.awt.*;

public class StockCardUI extends ComponentUI {

    private HotelChain chain;

    public StockCardUI(int x, int y, int width, int height, HotelChain chain) {
        super(x, y, width, height);
        this.chain = chain;
    }

    public HotelChain getStockCardChain() {
        return chain;
    }

    public void setStockCardChain(HotelChain chain) {
        this.chain = chain;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(chain == null ? Color.WHITE : chain.getColor());
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
    }
}
