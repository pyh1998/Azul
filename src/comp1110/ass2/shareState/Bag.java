package comp1110.ass2.shareState;

import comp1110.ass2.Tile;

public class Bag {
    /* The maximum size of tiles that the bag can hold */
    public static final int MAX_SIZE = 100;
    /**
     * The array of tiles inside the bag.
     */
    public Tile[] tiles = new Tile[MAX_SIZE];

    public Bag () {

    }
}
