package isu.engine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int ROW_COUNT = 9;
    public static final int COLUMN_COUNT = 12;
    private BoardCell[][] board;
    private static Board b;
    private String color;
    private List<BoardCell> emptyCells;
    private List<BoardCell> occupiedCells;

    public Board() {
        board = new BoardCell[ROW_COUNT][COLUMN_COUNT];
        emptyCells = new ArrayList<>();
        occupiedCells = new ArrayList<>();

        color = "white";

        for(int ri = 0; ri < ROW_COUNT; ri++){
            for(int ci = 0; ci < COLUMN_COUNT; ci++){
                board[ri][ci] = new BoardCell(ri, ci);
            }
        }
    }

    public void setColor(String clr){
    }

    public void updateColor(String clr){
        color = clr;
    }

    //parameters take in two integers getCell(1, 10)
    public BoardCell getCell(int ri, int ci){
        return board[ri][ci];
    }

    //parameters take in char for letter and integer getCell(1, A)
    public BoardCell getCell(int ci, char rChar){
        int ri = rChar - 'A';
        return board[ri][ci];
    }

    //parameters take in a String getCell(1A)
    public BoardCell getCell(String location){
        int length = location.length();
        char rChar = location.charAt(length - 1);
        int ci = Integer.parseInt(location.substring(0,length - 1));
        return getCell(rChar, ci);
    }

    public void placeTile(Tile tile){
        BoardCell cell = getCell(tile.getRowIndex(), tile.getColumnIndex());
        cell.updateColor("black");
        cell.isOccupied();
    }

    public List<BoardCell> getEmptyCells(BoardCell cell){
        for(int i = 0; i < board.length; i++){
            if(cell.getColor().equals("white")){
                emptyCells.add(cell);
            }
        }
        return emptyCells;
    }

    public List<BoardCell> getOccupiedCells(){
        Tile tile = new Tile();
        BoardCell cell = this.getCell(tile.getRowIndex(), tile.getColumnIndex());
        for(int i = 0; i < board.length; i++){
            if(cell.getColor().equals("black")){
                occupiedCells.add(cell);
            }
        }
        return occupiedCells;
    }

    public int getSize(){
        return board.length;
    }

}
