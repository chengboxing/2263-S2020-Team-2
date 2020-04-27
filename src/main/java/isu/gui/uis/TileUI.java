package isu.gui.uis;

import isu.engine.Tile;
import isu.gui.uis.ComponentUI;

import java.awt.*;

public class TileUI extends ComponentUI {

    private Tile tile;

    public TileUI(int x, int y, int width, int height, Tile tile) {
        super(x, y, width, height);
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setColor(isSelected() ? Color.LIGHT_GRAY : Color.WHITE);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawString(tile.getLabel(), x + width/4, y + height/2);

    }
}
