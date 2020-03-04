package isu;

import isu.engine.TilePile;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());
        arrayList.remove(2);
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());


        TilePile tilePile = new TilePile();
        for(int i = 0; i < tilePile.size(); i++){
            System.out.println(tilePile.getRandomTile().getTileLabel());
        }
    }
}
