package isu.engine;

public class Tile extends CellLocation{

    private static final String DEFAULT_COLOR = "black";

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

    public String getColor(){
        return chain != null ? chain.getColor() : DEFAULT_COLOR;
    }


}

