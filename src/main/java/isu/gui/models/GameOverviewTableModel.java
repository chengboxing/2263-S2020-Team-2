package isu.gui.models;

import isu.engine.Bank;
import isu.engine.GameEngine;
import isu.engine.HotelChain;
import isu.engine.Player;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class GameOverviewTableModel extends AbstractTableModel {

    private GameEngine gameEngine;
    private String[] columnNames;
    private String[] features = {"Stock", "ChainSize", "StockPrice"};

    public GameOverviewTableModel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        HotelChain[] chains = gameEngine.getHotelChains();
        columnNames = new String[chains.length + 1];
        columnNames[0] = "";
        for (int i = 0; i < chains.length; i++) {
            columnNames[i+1] = chains[i].getName();
        }
    }

    @Override
    public int getRowCount() {
        return gameEngine.getPlayers().size() + features.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0) {
            return String.class;
        }
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HotelChain[] chains = gameEngine.getHotelChains();
        final List<Player> players = gameEngine.getPlayers();
        Bank bank = gameEngine.getBank();
        if(rowIndex < players.size()){
            //DO PLAYERS
            Player player = players.get(rowIndex);
            if(columnIndex == 0){
                return player.getName();
            }else{
                HotelChain chain = chains[columnIndex-1];
                return player.getStocks(chain);
            }
        }else {
            //DO FEATURES
            int featureIndex = rowIndex - players.size();
            if(columnIndex == 0){
                return features[featureIndex];
            }else {
                HotelChain chain = chains[columnIndex-1];
                if(featureIndex == 0){
                    return bank.getStockCount(chain);
                }
                else if(featureIndex == 1){
                    return chain.size();
                }
                else if(featureIndex == 2){
                    return chain.getStockPrice();
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        return;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        return;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        return;
    }
}

