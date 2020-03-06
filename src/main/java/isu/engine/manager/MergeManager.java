package isu.engine.manager;

import isu.engine.HotelChain;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

import java.util.ArrayList;

public class MergeManager {

    public static boolean startMerge(CircularlyLinkedList<Player> playerOrder, Player currentPlayer, Tile t){
        ArrayList<HotelChain> mergingChains = findMergingChains(t);

        if (mergingChains != null) {
            HotelChain survivingChain = findSurvivingChain(mergingChains);
            if (survivingChain != null){
                merge(playerOrder, currentPlayer, survivingChain);
            }

            return true;
        }

        return false;
    }

    public static void merge(CircularlyLinkedList<Player> playerOrder, Player currentPlayer, HotelChain survivingChain){

    }

    private static ArrayList<HotelChain> findMergingChains(Tile t){
        return null;
    }

    private static HotelChain findSurvivingChain(ArrayList<HotelChain> chains){
        ArrayList<HotelChain> largestChains = findLargestChains(chains);
        if (largestChains.size() == 1){
            return largestChains.get(0);
        } else {
            updateUI(largestChains);
            return null;
        }
    }

    private static ArrayList<HotelChain> findLargestChains(ArrayList<HotelChain> chains){
        return null;
    }

    private static void updateUI(ArrayList<HotelChain> chains){

    }
}
