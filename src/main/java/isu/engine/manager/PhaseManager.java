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

    public PhaseName getCurrentPhase(){
        if(currentPhase.equals(PhaseName.MERGE))return PhaseName.MERGE;
        if(currentPhase.equals(PhaseName.PURCHASE)) return PhaseName.PURCHASE;
        if(currentPhase.equals(PhaseName.END)) return PhaseName.END;
        else return PhaseName.TILE;
    }
}