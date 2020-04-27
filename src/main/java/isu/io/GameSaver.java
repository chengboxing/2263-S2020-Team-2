package isu.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaver {

    public void save(){
        //setup gameSave

        //write(save);
    }

    public void write(GameSave save){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(save);
            //print json to file
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
