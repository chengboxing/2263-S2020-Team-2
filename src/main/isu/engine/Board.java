package isu.engine;

public class Board {

    private static final int ROW_COUNT = 9;
    private static final int COLUMN_COUNT = 12;
    private BoardCell[][] cells;

    public Board() {
        cells = new BoardCell[ROW_COUNT][COLUMN_COUNT];

        for(int ri = 0; ri < ROW_COUNT; ri++){
            for(int ci = 0; ci < COLUMN_COUNT; ci++){
                cells[ri][ci] = new BoardCell(ri, ci);
            }
        }
    }

    //parameters take in two integers getCell(1, 10)
    public BoardCell getCell(int ri, int ci){
        return cells[ri][ci];
    }

    //parameters take in char for letter and integer getCell(1, A)
    public BoardCell getCell(int ci, char rChar){
        int ri = rChar - 'A';
        return cells[ri][ci];
    }

    //parameters take in a String getCell(1A)
    public BoardCell getCell(String location){
        int length = location.length();
        char rChar = location.charAt(length - 1);
        int ci = Integer.parseInt(location.substring(0,length - 1));
        return getCell(rChar, ci);
    }


}
