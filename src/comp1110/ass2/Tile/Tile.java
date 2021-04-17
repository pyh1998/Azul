package comp1110.ass2.Tile;

import javafx.scene.paint.Color;

public enum Tile {

    /**
     * six different kinds of tiles
     */
    A(0, 'a'),
    B(1, 'b'),
    C(2, 'c'),
    D(3, 'd'),
    E(4, 'e'),
    FIRST_PLAYER(5, 'f');

    private final char TILE_TYPE;
    public final int TILE_ID;

    private final Color TILE_COLOR;
    private TileLocation tileLocation;
    public int col;
    public int row;


    /**
     * Constructor of Tile
     * The location of initializing tile is in bag
     * Initialize the color of tile according to the tile's type
     *
     * @param TILE_ID the id of the tile
     * @param TILE_TYPE the char of the tile
     */

    Tile(int TILE_ID,char TILE_TYPE) {
        this.TILE_TYPE = TILE_TYPE;
        this.TILE_ID = TILE_ID;
        switch (TILE_TYPE){
            case 'a' -> this.TILE_COLOR = Color.BLUE;
            case 'b' -> this.TILE_COLOR = Color.GREEN;
            case 'c' -> this.TILE_COLOR = Color.ORANGE;
            case 'd' -> this.TILE_COLOR = Color.PURPLE;
            case 'e' -> this.TILE_COLOR = Color.RED;
            case 'f' -> this.TILE_COLOR = Color.BLACK;
            default -> this.TILE_COLOR = null;
        }
    }

    /**
     * Get the tile from a char, like get Tile A from char 'a'
     *
     * @param ch the char of the tile
     * @return the tile represented by char
     */
    public static Tile CharToTile(char ch) {
        for (Tile tile : Tile.values()) {
            if (tile.TILE_TYPE == ch) {
                return tile;
            }
        }
        return null;
    }

    /**
     * Get the tile from a int id, like get Tile A from int 0
     *
     * @param id the id of the tile
     * @return the tile represented by int id
     */
    public static Tile idToTile(int id) {
        for (Tile tile : Tile.values()) {
            if (tile.TILE_ID == id) {
                return tile;
            }
        }
        return null;
    }

    /**
     * Check if the tile is the first player tile
     *
     * @return return true if the tile is the first player tile
     */
    public boolean isFirstPlayerTile(){
        return this.TILE_ID == 5;
    }

    /**
     *Get private field TILE_TYPE of tile
     *
     */
    public char getTILE_TYPE() {
        return TILE_TYPE;
    }

    /**
     *Get private field TILE_ID of tile
     *
     */
    public int getTILE_ID() {
        return TILE_ID;
    }

    /**
     *Get private field TILE_COLOR of tile
     *
     */
    public Color getTILE_COLOR() {
        return TILE_COLOR;
    }

    /**
     *Get private field TileLocation of tile
     *
     */
    public TileLocation getTileLocation() {
        return tileLocation;
    }
    /**
     *Set private field TileLocation of tile
     *
     */
    public void setTileLocation(TileLocation tileLocation) {
        this.tileLocation = tileLocation;
    }
}

