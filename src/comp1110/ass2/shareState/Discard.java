package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;

public class Discard {

    /**
     *Field number: the number of tiles of the Discard
     *Field tiles: the array of tiles in Discard
     */
    private int number;
    public Tile[] tiles;

    /**
     * Constructor of Discard
     * Initialize the tiles number of Discard
     * Initialize the tiles in Discard
     *
     */
    public Discard() {
        this.number = 0;
        this.tiles = new Tile[number];
    }

    /**
     *Get private field number of Discard
     *
     */
    public int getNumber() {
        return number;
    }
    /**
     *Get field the tile array of Discard
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Add tiles to Discard from Storage and Floor
     * Update the array of tiles
     *
     * @param tiles the array of tiles from other places
     */
    public void addTiles(Tile[] tiles){
        this.number += tiles.length;
        //TODO FIX the function of addTiles
    }
    /**
     * Move all tiles to Bag when Bag has no tile
     * Make the number of Discard equals zero and empty the array of tiles
     *
     */
    public void movetoBag(){
        this.number = 0;
        //TODO FIX the function of movetoBag
    }



}
