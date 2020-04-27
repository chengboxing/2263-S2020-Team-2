package isu.gui.graphics;




import isu.engine.GameEngine;
import isu.engine.Tile;
import isu.gui.uis.TileUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TilePanel extends JPanel {

    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    public static final int Y = 25;
    public static final int X0 = 25;
    public static final int SPACE = 65;
    GameEngine gameEngine;
    private TileUI[] tileUIs;

    public TilePanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        tileUIs = new TileUI[GameEngine.TILES_PER_PLAYER];
        int w;
        for(int i = 0; i < tileUIs.length; i++){
            w = SPACE * i;
            tileUIs[i] =  new TileUI(X0 + w, Y, WIDTH, HEIGHT, null);
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                trySelectTile(e.getX(), e.getY());
                System.out.println("Clicked : x = " + e.getX() + "; y = " + e.getY());
            }

        });
    }

    public Tile getSelectedTile() {
        for(TileUI tileUI: tileUIs){
            if(tileUI.isSelected()){
                return tileUI.getTile();
            }
        }
        return null;
    }

    public int getSelectedTileIndex(){
        for(int i = 0; i < tileUIs.length; i++){
            if(tileUIs[i].isSelected()){
                return i;
            }
        }
        return -1;
    }

    protected void paintComponent(Graphics g){
        for(int i = 0; i < tileUIs.length; i++){
            tileUIs[i].setTile(gameEngine.getCurrentPlayer().getTile(i));
            tileUIs[i].paintComponent(g);
        }
    }

    private void trySelectTile(int x, int y){
        TileUI selectedTile = null;
        for(TileUI tileUI: tileUIs){
            if(tileUI.isOverlapping(x, y)) {
                selectedTile = tileUI;
                break;
            }
        }
        if(selectedTile == null) return;

        unselectAll();
        selectedTile.setSelected(true);
        this.repaint();
    }

    public void unselectAll(){
        for(TileUI tileUI: tileUIs){
            tileUI.setSelected(false);
        }
    }

    public void disableAll(){
        for(TileUI tileUI: tileUIs){
            tileUI.setEnabled(false);
        }
    }

}
