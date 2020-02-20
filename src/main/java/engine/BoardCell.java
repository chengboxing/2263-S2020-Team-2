package java.engine;

public class BoardCell {

    private int rowIndex;
    private int columnIndex;

    public BoardCell(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
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

    public String getLocation(){
        return "" + columnIndex + getRowChar();
    }
}
