package isu.gui;

import java.util.EventObject;

public class GameEvent extends EventObject {

    private String name;

    public GameEvent(Object source) {
        super(source);
    }

    public GameEvent(Object source, String name){
        super(source);
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
