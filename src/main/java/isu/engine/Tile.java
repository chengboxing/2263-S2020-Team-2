package isu.engine;

public class Tile extends CellLocation{

    private static int rowIndex;
    private static int columnIndex;

    public Tile(int rowIndex, int columnIndex){
        super(rowIndex, columnIndex);
    }


    /*
    * This is previous code, keeping just in case.
    * */
//    public int getRowIndex() {
//        return rowIndex;
//    }
//
//    public int getColumnIndex() {
//        return columnIndex;
//    }
//
//    public char getRowChar(){
//        return (char)('A' + rowIndex);
//    }
//
//    public String getTileLabel(){
//        return "" + (columnIndex+1) + getRowChar();
//    }
}

