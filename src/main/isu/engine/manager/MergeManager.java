package isu.engine.manager;

import isu.engine.Player;
import isu.engine.Tile;
import isu.structures.CircularlyLinkedList;

public class MergeManager {
    private TurnManager mergeTurnManager;

    public MergeManager(CircularlyLinkedList<Player> playerOrder){
        mergeTurnManager = new TurnManager(playerOrder);
    }

    public boolean checkMerge(Tile t){

        return false;
    }

    public void merge(){

    }
}
