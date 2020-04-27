package isu.io;

import java.util.List;

public class SaveManager {

    private static SaveManager instance = new SaveManager();
    private List<GameSave> saves;

    private SaveManager(){
        loadSaves();
    }

    public static SaveManager getInstance(){
        return instance;
    }

    public List<GameSave> getSaves(){
        return saves;
    }

    public int getNumSaves(){
        return saves.size();
    }

    public void addSave(GameSave save){
        saves.add(save);
    }

    public void deleteSave(int saveID){
        for (GameSave save : saves){
            if (save.getSaveID() == saveID){
                saves.remove(save);
            }
        }

        //delete file
    }

    //needs to happen on startup
    private void loadSaves(){
        //convert json files to games saves
    }
}
