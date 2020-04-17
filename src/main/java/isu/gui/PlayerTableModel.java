package isu.gui;

import isu.engine.GameEngine;
import isu.engine.Player;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class PlayerTableModel extends AbstractTableModel {

    private GameEngine gameEngine;

    private String[] columnNames = {"Players"};

    public PlayerTableModel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public int getRowCount() {
        return gameEngine.getPlayers().size();
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
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return gameEngine.getPlayers().get(rowIndex).getName();
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
