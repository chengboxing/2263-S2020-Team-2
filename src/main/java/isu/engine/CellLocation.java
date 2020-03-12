package isu.engine;

public class CellLocation {

    private static int rowIndex;
    private static int columnIndex;

    public CellLocation(int rowIndex, int columnIndex) {
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
