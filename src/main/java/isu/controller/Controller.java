package isu.controller;

import isu.engine.Board;
import isu.engine.BoardCell;
import isu.engine.Tile;

public class Controller {
    public static void main(String[] args) {
        Board b = new Board();
        BoardCell cell = new BoardCell();
        Tile tile = new Tile();

        b.placeTile(tile);

        System.out.println(!cell.isOccupied());
        System.out.println(cell.isOccupied());


        System.out.println();


        for(int i = 0; i < b.getSize()/12; i++){
            b.placeTile(tile);
        }

//        for(int j = 0; j < b.getOccupiedCells().size(); j++) {
//            System.out.println(tile.getTileLabel());
//        }

        System.out.println(b.getOccupiedCells().size());

    }
}
