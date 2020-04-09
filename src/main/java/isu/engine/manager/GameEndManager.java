package isu.engine.manager;

import isu.engine.GameEngine;
import isu.engine.Player;

public class GameEndManager {

    public static boolean checkGameEnd(){
        boolean end = true;

        for (int i = 0; i < GameEngine.GAME_ENGINE.getHotelChains().length; i++){
            if (GameEngine.GAME_ENGINE.getHotelChains()[i].getTiles().size() < 11){
                end = false;
            }
            if (GameEngine.GAME_ENGINE.getHotelChains()[i].getTiles().size() == 41){
                return true;
            }
        }

        return end;
    }

    public static Player endGame(){
        //pay bonuses and sell stocks

        return getWinner();
    }

    private static Player getWinner(){

        return null;
    }
}
