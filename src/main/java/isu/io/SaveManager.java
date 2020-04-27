package isu.io;

import java.util.List;

public class SaveManager {

    private List<GameSave> saves;

    public SaveManager(){
        loadSaves();
    }

    public List<GameSave> getSaves(){
        return saves;
    }

    public void deleteSave(int saveID){
        for (GameSave save : saves){
            if (save.getSaveID() == saveID){
                saves.remove(save);
            }
        }

        //delete file
    }

    private void loadSaves(){
        //convert json files to games saves
    }
}
