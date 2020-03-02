package isu.engine.manager;

import isu.engine.Player;
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

    public void doMergePhase(){
        currentPhase = PhaseName.MERGE;
        mergeManager.merge();
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
