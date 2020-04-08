package isu.engine.manager;

import isu.engine.Board;
import isu.engine.GameEngine;
import isu.engine.Player;
import isu.engine.Tile;

public class GameStartManager {

    private GameEngine gameEngine;

    public GameStartManager(GameEngine gameEngine){
        this.gameEngine = gameEngine;

    }

    /**
     *
     * This method gives each player 7 tiles:
     * 6 for each players playing tiles and
     * 1 tile to pick who goes first
     *
     */
    private void setInitTiles(){
        for(Player player: gameEngine.getPlayers()){
            player.addTiles(gameEngine.getTilePile(), GameEngine.TILES_PER_PLAYER + 1);
        }
    }

    /**
     *
     * this method should identify who goes first based on
     * the tile with index 0
     *
     */
    private void setFirstPlayer(){
        TurnManager turnManager = gameEngine.getTurnManager();
        for(Player player: gameEngine.getPlayers()){
            Tile tile = player.getTile(0);
            //TODO finish this method
        }


    }



    private void placeFirstTiles(){
        Board board = gameEngine.getBoard();
        for(Player player: gameEngine.getPlayers()){
            Tile tile = player.pullTile(0);
            board.placeTile(tile);
        }
    }



    public void start(){
        setInitTiles();
        setFirstPlayer();
        placeFirstTiles();
    }


}
