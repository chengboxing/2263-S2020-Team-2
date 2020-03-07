package isu.engine.manager;

import isu.engine.HotelChain;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

import java.util.ArrayList;

public class MergeManager {

    /**
     * Checks if there is a merge based on the placed tile. Starts the merge process
     * if a surviving chain can be determined without the player.
     * @param turnManager
     * @param t
     * @return True if there is a merge
     */
    public static boolean checkMerge(TurnManager turnManager, Tile t){
        ArrayList<HotelChain> mergingChains = findMergingChains(t);
        if (mergingChains.size() == 1){
            //add tile to chain
        } else if (mergingChains.size() != 0) {

            HotelChain survivingChain = findSurvivingChain(mergingChains);
            if (survivingChain != null){

                merge(turnManager, survivingChain, mergingChains);
            }

            return true;
        }

        return false;
    }

    /**
     * Combines the chains, pays the bonuses to the players, and has each player sell/trade/keep there stocks
     * @param turnManager
     * @param survivingChain
     * @param mergingChains
     */
    public static void merge(TurnManager turnManager, HotelChain survivingChain, ArrayList<HotelChain> mergingChains){
        //merge chains
        //pay bonuses
        //doMergeTurns
    }

    /**
     * Finds the chains touching the tile
     * @param t
     * @return ArrayList of the chains touching the tile
     */
    private static ArrayList<HotelChain> findMergingChains(Tile t){
        HotelChain[] hotelChains = HotelChain.getHotelChains();
        ArrayList<HotelChain> mergingChains = new ArrayList<>();

        for (int i = 0; i < hotelChains.length; i++){
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

        return mergingChains;
    }

    /**
     * Finds the chain that will survive the merge. If the surviving chain can't be found without the player
     * choosing, it will update the UI to show the selection for the chain.
     * @param chains
     * @return The surviving chain if it can be found without the player, null if it can't
     */
    private static HotelChain findSurvivingChain(ArrayList<HotelChain> chains){
        ArrayList<HotelChain> largestChains = findLargestChains(chains);
        if (largestChains.size() == 1){
            return largestChains.get(0);
        } else {
            showSurvivingChainSelection(largestChains);
            return null;
        }
    }


    /**
     * Finds the largest chain(s) of the ones it is given
     * @param chains
     * @return ArrayList of the largest chains
     */
    private static ArrayList<HotelChain> findLargestChains(ArrayList<HotelChain> chains){

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
        return largestChains;
    }

    /**
     * Updates the UI to show the panel for selecting the surviving chain
     * @param chains
     */
    private static void showSurvivingChainSelection(ArrayList<HotelChain> chains){

    }
}
