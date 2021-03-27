package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class Storage {
    public final int NUMBER_ROWS = 5;
    public Tile[][] tiles = new Tile[NUMBER_ROWS][];
    public Tile[] row0;
    public Tile[] row1;
    public Tile[] row2;
    public Tile[] row3;
    public Tile[] row4;
    public int rowNumber;

    /**
     * Create an array of tile array that stores all the tiles.
     * The index of tile array indicated the row number.
     */
    public Storage() {
        for (int i = 1; i <= 5; i++) {
            this.tiles[i-1] = new Tile[i];
        }
    }

    /**
     * Constructor of the Storage pile
     * @param tiles an array of tile arrays of the five rows
     */
    public Storage(Tile[][] tiles) {
        this.tiles = tiles;
        this.row0 = tiles[0];
        this.row1 = tiles[1];
        this.row2 = tiles[2];
        this.row3 = tiles[3];
        this.row4 = tiles[4];
    }

    /**
     * After picking up tiles, add them to one of the five storage rows
     * According to following the rules:
     *
     * You must place the tiles from right to left in your chosen row.
     *
     * If a row already contains tiles, you may only add tiles of the same colour to it.
     *
     * If you have more tiles than can fit in your chosen row,
     * then you must place the excess tiles on the floor.
     *
     * You are not allowed to place tiles of a certain colour in a row
     * if the corresponding mosaic row already contains a tile of that colour.
     *
     * If you cannot or do not want to place tiles on a row, you may place them directly onto the floor.
     *
     * @param tiles an array of tiles to be added to the storage
     * @param rowNumber the row number to add the tiles
     */
    public void addTiles (Tile[] tiles, int rowNumber) {
        // TODO FIX the function of addTiles

    }

    /**
     * get an array of the tile array of the five rows
     * @return an array of the tile array of the five rows
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * get the array of tiles in row 0
     * @return an array of tiles in row 0
     */
    public Tile[] getRow0() {
        return row0;
    }

    /**
     * get the array of tiles in row 1
     * @return an array of tiles in row 1
     */
    public Tile[] getRow1() {
        return row1;
    }

    /**
     * get the array of tiles in row 2
     * @return an array of tiles in row 2
     */
    public Tile[] getRow2() {
        return row2;
    }

    /**
     * get the array of tiles in row 3
     * @return an array of tiles in row 3
     */
    public Tile[] getRow3() {
        return row3;
    }

    /**
     * get the array of tiles in row 4
     * @return an array of tiles in row 4
     */
    public Tile[] getRow4() {
        return row4;
    }
}
