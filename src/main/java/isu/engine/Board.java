package isu.engine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int ROW_COUNT = 9;
    public static final int COLUMN_COUNT = 12;
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

    //parameters take in char for letter and integer getCell(A, 1)
    public BoardCell getCell(char rChar, int ci){
        int ri = rChar - 'A';
        return cells[ri][ci];
    }

    //parameters take in a String getCell(A1)
    public BoardCell getCell(String location){
        int length = location.length();
        char rChar = location.charAt(length - 1);
        int ci = Integer.parseInt(location.substring(0,length - 1));
        return getCell(rChar, ci);
    }

    public void placeTile(Tile tile){
        BoardCell cell = getCell(tile.getRowIndex(), tile.getColumnIndex());
        cell.setTile(tile);
    }

    public List<BoardCell> getEmptyCells(){
        List<BoardCell> emptyCells = new ArrayList<>();
        for(int ri = 0; ri < ROW_COUNT; ri++){
            for(int ci = 0; ci < COLUMN_COUNT; ci++){
                BoardCell cell = cells[ri][ci];
                if(!cell.isOccupied()){
                    emptyCells.add(cell);
                }
            }
        }
        return emptyCells;
    }

    public List<BoardCell> getOccupiedCells(){
        List<BoardCell> occupiedCells = new ArrayList<>();
        for(int ri = 0; ri < ROW_COUNT; ri++){
            for(int ci = 0; ci < COLUMN_COUNT; ci++){
                BoardCell cell = cells[ri][ci];
                if(cell.isOccupied()){
                    occupiedCells.add(cell);
                }
            }
        }
        return occupiedCells;
    }

}
