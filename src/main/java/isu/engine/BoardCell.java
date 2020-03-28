package isu.engine;

public class BoardCell extends CellLocation{

    private Tile tile;
    private String color;

    public BoardCell(){
        super();
    }

    public BoardCell(int rowIndex, int columnIndex) {
        super();
        tile = new Tile();
        color = "black";
    }

    public void setColor(String clr){
        color = clr;
    }

    public String getColor(){
        return color;
    }

    public void updateColor(String clr){
        color = clr;
    }

    public boolean isOccupied(){
        return true;
    }

//    public void setOccupation(int rowIndex, int columnIndex){
//        if(!color.equals("white")){
//            boolean occupied = isOccupied();
//        }
//    }





}
