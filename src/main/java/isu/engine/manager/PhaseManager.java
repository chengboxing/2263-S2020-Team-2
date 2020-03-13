package isu.engine.manager;

import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

public class PhaseManager {
    private PhaseName currentPhase;
    private TurnManager turnManager;

    public PhaseManager (CircularlyLinkedList<Player> playerOrder){
        currentPhase = PhaseName.TILE;
        turnManager = new TurnManager(playerOrder);
    }

    public void doTilePhase(){
        currentPhase = PhaseName.TILE;
        //updateUI
    }

    public void doMergePhase(Tile t){
        currentPhase = PhaseName.MERGE;
        if (!MergeManager.getInstance().checkMerge(turnManager, t)){
            doPurchasePhase();
        }
    }

    public void doPurchasePhase(){
        currentPhase = PhaseName.PURCHASE;
        //updateUI
    }

    public void doEndPhase(){
        currentPhase = PhaseName.END;
        if (GameEndManager.checkGameEnd()){
            GameEndManager.endGame();
        } else {
            turnManager.nextTurn();
            doTilePhase();
        }
    }
}