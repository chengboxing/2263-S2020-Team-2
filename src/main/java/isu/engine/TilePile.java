package isu.engine;

import java.util.ArrayList;
import java.util.Random;

public class TilePile {

    private ArrayList<Tile> tilePile;

    public TilePile(){
        tilePile = new ArrayList<>();

        for(int ci = 0; ci < Board.ROW_COUNT; ci++){
            for(int ri = 0; ri < Board.COLUMN_COUNT; ri++){
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

