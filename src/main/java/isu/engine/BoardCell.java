package isu.engine;

public class BoardCell extends CellLocation{

    private Tile tile;



    public BoardCell(int rowIndex, int columnIndex) {
        super(rowIndex, columnIndex);
        tile = null;
    }


    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        if(tile == null){
            throw new IllegalArgumentException("tile is null");
        }
        if(getRowIndex() != tile.getRowIndex() || getColumnIndex()!= tile.getColumnIndex()){
            throw new IllegalArgumentException("location does not match");
        }
        this.tile = tile;
    }

    public boolean isOccupied(){
        return tile != null;
    }
}
