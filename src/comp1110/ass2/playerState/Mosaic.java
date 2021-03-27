package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class Mosaic {
    public final int HEIGHT = 5;
    public final int WIDTH = 5;

    public Tile[][] tiles;

    int col;
    int row;

    /**
     * Constructor of the mosaic pile
     * @param tiles all tiles inside the mosaic
     */
    public Mosaic(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Perform a valid tiling move
     * @param tile the tile to be placed
     * @param col the col number
     * @param row teh row number
     */
    public void addTileToMosaic(Tile tile, int col, int row) {
        // TODO FIX the function of addTileToMosaic
    }

    /**
     * Check whether placement of tile to the storage is valid
     *      * Each row and column of the mosaic may not contain more than one tile of the same colour
     *      * (much like a sudoku).
     *      *
     *      * If you are unable to move a tile of a certain colour across because there is no valid space
     *      * left for it, you must place all tiles from that row onto your floor instead.
     * @param tile the tile to be placed to the mosaic pile
     * @param col the col number
     * @param row teh row number
     */
    public void isValidPlacement(Tile tile, int col, int row) {

    }

    /**
     * get all tiles placed on the mosaic pile
     * @return all tiles placed on the mosaic pile
     */
    public Tile[][] getTiles() {
        return tiles;
    }
}
