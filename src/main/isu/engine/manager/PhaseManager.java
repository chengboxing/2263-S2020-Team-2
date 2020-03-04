package isu.engine.manager;

import isu.engine.Player;
import isu.engine.Tile;
import isu.structures.CircularlyLinkedList;

public class PhaseManager {
    private PhaseName currentPhase;
    private TurnManager turnManager;
    private MergeManager mergeManager;

    public PhaseManager (CircularlyLinkedList<Player> playerOrder){
        currentPhase = PhaseName.TILE;
        turnManager = new TurnManager(playerOrder);
        mergeManager = new MergeManager(playerOrder);
    }

    public void doTilePhase(){
        currentPhase = PhaseName.TILE;
        //updateUI
    }

    public void doMergePhase(Tile t){
        currentPhase = PhaseName.MERGE;
        if (mergeManager.checkMerge(t)){
            mergeManager.merge(turnManager.getCurrentPlayer());

        } else {
            doPurchasePhase();
        }

    }

    public void doPurchasePhase(){
        currentPhase = PhaseName.PURCHASE;
        //udateUI
    }

    public void doEndPhase(){
        currentPhase = PhaseName.END;

        turnManager.nextTurn();
        doTilePhase();
    }
}
