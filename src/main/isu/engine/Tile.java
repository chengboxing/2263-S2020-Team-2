package isu.engine;

public class Tile {

    private int rowIndex;
    private int columnIndex;

    public Tile(int rowIndex, int columnIndex){
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;

    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public char getRowChar(){
        return (char)('A' + rowIndex);
    }

    public String getTileLabel(){
        return "" + (columnIndex+1) + getRowChar();
    }
}
