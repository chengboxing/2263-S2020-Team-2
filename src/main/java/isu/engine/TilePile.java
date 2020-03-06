package isu.engine;

import java.util.ArrayList;
import java.util.Random;

public class TilePile {

    public static final int COLUMNS = 12;
    public static final int ROWS = 9;
    private ArrayList<Tile> tilePile;

    public TilePile(){
        tilePile = new ArrayList<>();
        for(int ci = 0; ci < COLUMNS; ci++){
            for(int ri = 0; ri < ROWS; ri++){
                tilePile.add(new Tile(ri, ci));
            }
        }

    }

    private int getRandomIndex(){
        Random random = new Random();
        int index = random.nextInt(tilePile.size() - 1);
        return index;
    }

    public Tile getRandomTile(){
        int index = getRandomIndex();
        Tile tile = tilePile.get(index);
        tilePile.remove(index);

        return tile;
    }

    public int size(){
        return tilePile.size();
    }
}

