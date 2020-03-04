package isu.engine.manager;

import isu.engine.Player;
import isu.structures.CircularlyLinkedList;

public class TurnManager {
    private CircularlyLinkedList<Player> playerOrder;
    private Player currentPlayer;


    public TurnManager(CircularlyLinkedList<Player> playerOrder) {
        this.playerOrder = playerOrder;
        this.currentPlayer = playerOrder.getFirst();
    }

    public TurnManager(CircularlyLinkedList<Player> playerOrder, Player currentPlayer) {
        this.playerOrder = playerOrder;

        setCurrentPlayer(currentPlayer);

        this.currentPlayer = currentPlayer;
    }

    public Player nextTurn(){
        currentPlayer = playerOrder.rotate();
        updateUI(currentPlayer);

        return currentPlayer;
    }

    private void updateUI(Player p){
        //show player info
    }

    public CircularlyLinkedList<Player> getPlayerOrder(){
        return playerOrder;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player p){
        while (playerOrder.getFirst() != p){
            currentPlayer = playerOrder.rotate();
        }
    }
}
