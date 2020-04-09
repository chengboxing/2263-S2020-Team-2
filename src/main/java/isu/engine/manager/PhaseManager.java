package isu.engine.manager;

import isu.engine.GameEngine;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

public class PhaseManager {
    private PhaseName currentPhase;

    public PhaseManager (){
        currentPhase = PhaseName.TILE;
    }

    public void doTilePhase(){
        currentPhase = PhaseName.TILE;
        if (GameEndManager.checkGameEnd()){
            //show end game prompt
        }

        //updateUI
    }

    public void doMergePhase(Tile t){
        currentPhase = PhaseName.MERGE;
        if (GameEngine.GAME_ENGINE.getMergeManager().checkMerge(t)){
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
            //show end game prompt
        } else {
            //show next turn button
        }
    }
}