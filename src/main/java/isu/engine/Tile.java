package isu.engine;

import java.awt.*;

public class Tile extends CellLocation{

    private static final Color DEFAULT_COLOR = Color.GRAY;

    private HotelChain chain;


    public Tile(int rowIndex, int columnIndex){
        super(rowIndex, columnIndex);

        chain = null;
    }

    public HotelChain getChain() {
        return chain;
    }

    public void setChain(HotelChain chain) {
        this.chain = chain;
    }

    public Color getColor(){
        return chain != null ? chain.getColor() : DEFAULT_COLOR;
    }


}

