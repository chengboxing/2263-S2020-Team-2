package isu.engine;

public class CellLocation {

    private int rowIndex;
    private int columnIndex;

    public CellLocation(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex  = columnIndex;
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

    public String getLabel(){
        return "" + (columnIndex+1) + getRowChar();
    }

}
