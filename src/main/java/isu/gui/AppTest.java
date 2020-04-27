package isu.gui;

import isu.engine.GameEngine;

public class AppTest {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        MainFrame mainFrame = new MainFrame();
        SelectChainDialog selectChainDialog = new SelectChainDialog(mainFrame, gameEngine);
        selectChainDialog.setVisible(true);
        System.out.println(selectChainDialog.getSelectedChain().getName());
        System.out.println("!!!");
    }
}
