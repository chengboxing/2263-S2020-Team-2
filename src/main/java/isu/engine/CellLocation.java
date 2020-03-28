package isu.engine;

public class CellLocation {

    public static  int rowIndex;
    public static int columnIndex;

    public CellLocation() {
        int rowI = this.getRowIndex();
        int columnI = this.getColumnIndex();

        rowIndex = rowI;
        columnIndex = columnI;
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
