package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;


public class Bag {
    /**
     * Field MAX_SIZE: The maximum size of tiles that the bag can hold
     * Field tiles: The array of tiles inside the bag.
     * Field isempty: judge if the Bag is empty.
     */
    public static final int MAX_SIZE = 100;
    public Tile[] tiles;
    public boolean isempty;

    /**
     * Constructor of Bag
     * Initialize the boolean isempty in Bag
     * Initialize the tiles in Bag
     *
     */
    public Bag () {
        isempty = false;
        tiles = new Tile[MAX_SIZE];
    }

    /**
     *Get field the tile array of Bag
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Add tiles to Factory from Bag
     * Update the array of tiles
     *
     * @param factory_number the number of factory in the game
     * @return the array of tiles need to add to Factory
     */
    public Tile[] addtoFactory(int factory_number){
        //TODO FIX the function of addtoFactory
        return null;
    }

    /**
     * Add tiles to Factory from Bag
     * Update the array of tiles in Bag
     *
     * @return the array of tiles from Discard
     */
    public Tile[] getTilesfromDiscard(){
        //TODO FIX the function of getTilesfromDiscard
        return null;
    }
}
