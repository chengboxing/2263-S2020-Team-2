package isu.engine.manager;

import isu.engine.*;
import isu.util.CircularlyLinkedList;

import java.util.ArrayList;

public class MergeManager {

    private Tile t;
    private ArrayList<HotelChain> mergingChains;
    private HotelChain survivingChain;

    private static MergeManager instance = new MergeManager();

    private MergeManager(){}

    public static MergeManager getInstance() {
        return instance;
    }

    /**
     * Checks if there is a merge based on the placed tile. Starts the merge process
     * if a surviving chain can be determined without the player.
     * @param t
     * @return True if there is a merge
     */
    public boolean checkMerge(Tile t){
        this.t = t;
        findMergingChains(t);

        if (mergingChains.size() == 1){
            //add tile to chain if it is the only chain touching the tile
            mergingChains.get(0).addTile(t);
        } else if (mergingChains.size() != 0) {
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
                GameEngine ge = GameEngine.GAME_ENGINE;
                ge.getBank().payBonus(chain, ge.getPlayers());
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
        HotelChain[] hotelChains = GameEngine.GAME_ENGINE.getHotelChains();
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
            showSurvivingChainSelection(largestChains);
        }
    }

    /**
     * Updates the UI to show the panel for selecting the surviving chain
     * @param chains
     */
    private void showSurvivingChainSelection(ArrayList<HotelChain> chains){

    }
}