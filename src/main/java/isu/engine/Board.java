package isu.engine;

import java.util.*;

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
        if (ri >= 0 && ri < ROW_COUNT && ci >= 0 && ci < COLUMN_COUNT) {
            return cells[ri][ci];
        }

        return null;
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

    public List<Tile> getNeighboringTiles(Tile tile){
        List<Tile> tiles = new ArrayList<>();

        int ri = tile.getRowIndex();
        int ci = tile.getColumnIndex();

        tryAddTile(tiles, ri+1, ci);
        tryAddTile(tiles, ri-1, ci);
        tryAddTile(tiles, ri, ci+1);
        tryAddTile(tiles, ri, ci-1);

        return tiles;
    }

    private void tryAddTile(List<Tile> tiles, int ri, int ci){
        if(ri < 0 || ri >= ROW_COUNT) return;
        if(ci < 0 || ci >= COLUMN_COUNT) return;

        Tile tile = cells[ri][ci].getTile();
        if(tile != null){
            tiles.add(tile);
        }
    }

    public List<HotelChain> getNeighboringChains(Tile tile){
        Set<HotelChain> chains = new HashSet<>();

        for(Tile t: getNeighboringTiles(tile)){
            if(t.getChain() != null){
                chains.add(t.getChain());
            }
        }

        return new ArrayList<HotelChain>(chains);
    }

    public boolean canPlayTile(Tile tile){
        int safeChainCount = 0;
        for(HotelChain c: getNeighboringChains(tile)){
            if(c.isChainSafe()){
                safeChainCount++;
            }
        }
        return safeChainCount < 2;
    }

}
