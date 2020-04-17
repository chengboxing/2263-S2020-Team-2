package isu.engine.manager;

import isu.engine.*;
import isu.util.CircularlyLinkedList;

import java.util.ArrayList;

public class MergeManager {

    private Tile t;
    private ArrayList<HotelChain> mergingChains;
    private HotelChain survivingChain;
    private GameEngine gameEngine;

    public MergeManager(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Checks if there is a merge based on the placed tile. Starts the merge process
     * if a surviving chain can be determined without the player.
     * @param t
     * @return True if there is a merge
     */
    public boolean checkMerge(Tile t){
        this.t = t;
        Board b = gameEngine.getBoard();
        BoardCell[] surroundingCells = new BoardCell[4];
        surroundingCells[0] = b.getCell(t.getRowIndex() - 1, t.getColumnIndex());
        surroundingCells[1] = b.getCell(t.getRowIndex() + 1, t.getColumnIndex());
        surroundingCells[2] = b.getCell(t.getRowIndex(), t.getColumnIndex() - 1);
        surroundingCells[3] = b.getCell(t.getRowIndex(), t.getColumnIndex() + 1);
        findMergingChains(t);

        if (mergingChains.size() == 0){
            //check to see if a chain needs to be created
            for (int i  = 0; i < 4; i++){
                if (surroundingCells[i] != null && surroundingCells[i].isOccupied() && surroundingCells[i].getTile().getChain() == null){
                    //create new chain
                }
            }
        } else if (mergingChains.size() == 1){
            //add tile to chain if it is the only chain touching the tile
            mergingChains.get(0).addTile(t);
            //add extra surrounding tiles
            for (int i  = 0; i < 4; i++){
                if (surroundingCells[i] != null && surroundingCells[i].isOccupied() && surroundingCells[i].getTile().getChain() == null){
                    mergingChains.get(0).addTile(surroundingCells[i].getTile());
                }
            }

        } else {
            findSurvivingChain(mergingChains);
            if (survivingChain != null){
                //only starts the merge if the surviving chain is found automatically
                merge();
            }

            return true;
        }

        return false;
    }

    /**
     * Combines the chains, pays the bonuses to the players, and has each player sell/trade/keep there stocks
     */
    public void merge(){

        //add tile to surviving chain
        survivingChain.addTile(t);

        for (HotelChain chain : mergingChains){
            if (chain != survivingChain){
                //add other chains' tiles to surviving chain
                survivingChain.addTiles(chain.getTiles());

                //pay bonuses
                GameEngine ge = gameEngine;
                ge.getBank().payBonus(chain, ge.getPlayers());
            }
        }

        //add extra surrounding tiles to chain
        Board b = gameEngine.getBoard();
        BoardCell[] surroundingCells = new BoardCell[4];
        surroundingCells[0] = b.getCell(t.getRowIndex() - 1, t.getColumnIndex());
        surroundingCells[1] = b.getCell(t.getRowIndex() + 1, t.getColumnIndex());
        surroundingCells[2] = b.getCell(t.getRowIndex(), t.getColumnIndex() - 1);
        surroundingCells[3] = b.getCell(t.getRowIndex(), t.getColumnIndex() + 1);
        for (int i  = 0; i < 4; i++){
            if (surroundingCells[i] != null && surroundingCells[i].isOccupied() && surroundingCells[i].getTile().getChain() == null){
                survivingChain.addTile(surroundingCells[i].getTile());
            }
        }

        //update board UI??

        //doMergeTurns

    }

    /**
     * Finds the chains touching the tile
     * @param t
     */
    private void findMergingChains(Tile t){
        HotelChain[] hotelChains = gameEngine.getHotelChains();
        mergingChains = new ArrayList<>();

        for (int i = 0; i < hotelChains.length; i++){
            //for each tile in the hotel chain, check to see if t is adjacent
            for (Tile tile : hotelChains[i].getTiles()){
                if (tile.getRowIndex() == t.getRowIndex() && tile.getColumnIndex() == t.getColumnIndex() + 1){
                    mergingChains.add(hotelChains[i]);
                } else if (tile.getRowIndex() == t.getRowIndex() && tile.getColumnIndex() == t.getColumnIndex() - 1){
                    mergingChains.add(hotelChains[i]);
                } else if (tile.getRowIndex() == t.getRowIndex() + 1 && tile.getColumnIndex() == t.getColumnIndex()){
                    mergingChains.add(hotelChains[i]);
                } else if (tile.getRowIndex() == t.getRowIndex() - 1 && tile.getColumnIndex() == t.getColumnIndex()){
                    mergingChains.add(hotelChains[i]);
                }
            }
        }
    }

    /**
     * Finds the chain that will survive the merge. If the surviving chain can't be found without the player
     * choosing, it will update the UI to show the selection for the chain.
     * @param chains
     */
    private void findSurvivingChain(ArrayList<HotelChain> chains){
        //find largest chains
        int largestSize = 0;
        for (HotelChain chain : chains){
            if (chain.size() > 0){
                largestSize = chain.size();
            }
        }

        ArrayList<HotelChain> largestChains = new ArrayList<>();
        for (HotelChain chain : chains){
            if (chain.size() == largestSize){
                largestChains.add(chain);
            }
        }

        if (largestChains.size() == 1){
            survivingChain = largestChains.get(0);
        } else {
            //if more than one, update ui to have player pick
            survivingChain = null;
        }
    }

}