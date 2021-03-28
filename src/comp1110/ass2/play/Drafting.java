package comp1110.ass2.play;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.Tile.TileColor;

public class Drafting {
    /**
     * Field tiles: The array of tiles while doing Drafting.
     * Field tileColor: the color player selected to move to Storage
     * Field row: the row player selected to place tiles
     */
    public Tile[] tiles;
    public TileColor tileColor;
    public int row;


    /**
     * Constructor of the Drafting
     * Initialize the tileColor while doing Drafting
     * Initialize the array of tiles while doing Drafting
     */
    public Drafting(TileColor tileColor) {
        this.tileColor = tileColor;
        this.tiles = new Tile[0];
    }


    /**
     * Get the array of tiles from Factory
     */
    public void getFromFactory () {
        //TODO FIX THE FUNCTION OF getFromFactory
    }
    /**
     * Move array of tiles to Storage
     */
    public void moveToStorage () {
        //TODO FIX THE FUNCTION OF moveToStorage
    }
    /**
     * Move array of tiles to the Floor
     */
    public void moveToFloor () {
        //TODO FIX THE FUNCTION OF moveToFloor
    }

    /**
     * Get array of tiles from Center to Storage
     */
    public void getFromCentre () {
        //TODO FIX THE FUNCTION OF getFromCentre
    }
}

