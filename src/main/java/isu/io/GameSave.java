package isu.io;

import isu.engine.GameEngine;

public class GameSave {

    private int saveID;
    private GameEngine gameEngine;

    public GameSave(){}

    public GameSave(int saveID, GameEngine gameEngine){
        this.saveID = saveID;
        this.gameEngine = gameEngine;
    }

    public int getSaveID() {
        return saveID;
    }

    public void setSaveID(int saveID) {
        this.saveID = saveID;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
