package isu.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class GameSaver {

    public void save(){
        GameSave save = new GameSave();
        save.setSaveID(SaveManager.getInstance().getNumSaves());
        //save.setGameEngine(???);

        SaveManager.getInstance().addSave(save);

        write(save);
    }

    public void write(GameSave save){
        ObjectMapper mapper = new ObjectMapper();
        try {
            //convert save to string
            String json = mapper.writeValueAsString(save);

            //print save to file
            PrintWriter out = new PrintWriter("save" + save.getSaveID() +".json", "UTF-8");
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
