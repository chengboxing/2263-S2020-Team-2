package isu.engine.manager;

import isu.engine.Player;
import isu.structures.CircularlyLinkedList;

public class TurnManager {
    private CircularlyLinkedList<Player> playerOrder;
    private Player currentPlayer;


    public TurnManager(CircularlyLinkedList<Player> playerOrder, Player currentPlayer) {
        this.playerOrder = playerOrder;
        this.currentPlayer = currentPlayer;
    }


    public Player nextTurn(){
        currentPlayer = playerOrder.rotate();
        updateUI(currentPlayer);

        return currentPlayer;
    }

    private void updateUI(Player p){

    }
}
