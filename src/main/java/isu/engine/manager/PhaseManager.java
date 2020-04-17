package isu.engine.manager;

import isu.engine.GameEngine;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

public class PhaseManager {
    private PhaseName currentPhase;
    private GameEngine gameEngine;

    public PhaseManager(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        currentPhase = PhaseName.TILE;
    }

    public void doTilePhase(){
        currentPhase = PhaseName.TILE;
    }

    public void doMergePhase(Tile t){
        currentPhase = PhaseName.MERGE;
        if (gameEngine.getMergeManager().checkMerge(t)){
            doPurchasePhase();
        }
    }

    public void doPurchasePhase(){
        currentPhase = PhaseName.PURCHASE;
    }



    public void doEndPhase(){
        currentPhase = PhaseName.END;
    }
}