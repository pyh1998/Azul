package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.Tile.TileColor;

public class Centre {

    /**
     *Field number: the number of tiles of the Centre
     *Field tiles: the array of tiles in Centre
     */
    private int number = 0;
    public Tile[] tiles;

    /**
     * Constructor of Centre
     * Initialize the tiles number of Centre
     * Initialize the tiles in Centre
     *
     */
    public Centre(int number) {
        this.number = 0;
        this.tiles = new Tile[number];
    }

    /**
     *Get private field number of Centre
     *
     */
    public int getNumber() {
        return number;
    }
    /**
     *Get field the tile array of Centre
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Add tiles to Centre from Factory
     * Update the array of tiles
     *
     * @param tiles the array of tiles from Factory
     */
    public void addTiles(Tile[] tiles){
        this.number += tiles.length;
        //TODO FIX the function of addTiles
    }

    /**
     * Select tiles of the color in the Centre based on the color
     *
     * @param color the color player choose from Centre
     */
    public void selectTiles(TileColor color){

        //TODO FIX the function of selectTiles
    }



}
