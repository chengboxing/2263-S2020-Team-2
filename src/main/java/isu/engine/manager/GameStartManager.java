package isu.engine.manager;

import isu.engine.Board;
import isu.engine.GameEngine;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.CircularlyLinkedList;

import java.util.List;
import java.util.Random;

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
     * Sets the order of the players
     */
    public TurnManager createPlayerOrder(List<Player> players){
        CircularlyLinkedList<Player> playerOrder = new CircularlyLinkedList<>();

        Random rand = new Random();
        int n = rand.nextInt(players.size());
        for (int i = 0; i < players.size(); i++) {
            playerOrder.addLast(players.get((n + i) % players.size()));
        }

        return new TurnManager(playerOrder);
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
        placeFirstTiles();
    }

}
