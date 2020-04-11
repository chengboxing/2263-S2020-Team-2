package isu.engine.manager;

import isu.engine.GameEngine;
import isu.engine.HotelChain;
import isu.engine.Player;

import java.util.Comparator;

public class GameEndManager {

    private GameEngine gameEngine;

    public GameEndManager(GameEngine gameEngine){
        this.gameEngine = gameEngine;

    }

    public void endGame(){
        //TODO
        //pay bonuses and sell stocks
    }

    public Player getWinner(){
        return gameEngine.getPlayers().stream()
                .max(Comparator.comparing(player -> player.getMoney()))
                .get();
    }

    public boolean isGameReadyToFinish(){
        boolean end = true;
        HotelChain[] chains = gameEngine.getHotelChains();

        for (int i = 0; i < chains.length; i++){
            HotelChain chain = chains[i];
            if (chain.isActive() && chain.size() < GameEngine.SAFE_CHAIN_SIZE){
                end = false;
            }
            if (chain.size() >= GameEngine.MAX_CHAIN_SIZE){
                return true;
            }
        }

        return end;
    }
}
