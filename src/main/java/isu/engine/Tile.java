package isu.engine;

public class Tile extends CellLocation{

    private String color;

    public Tile(){
        super();

        color = "black";
    }

    public String getColor(){
        return color;
    }


}

