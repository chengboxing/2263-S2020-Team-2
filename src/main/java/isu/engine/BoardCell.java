package isu.engine;

public class BoardCell extends CellLocation{

    private static int rowIndex;
    private static int columnIndex;

    public BoardCell(int rowIndex, int columnIndex) {
        super(rowIndex, columnIndex);
    }
}
