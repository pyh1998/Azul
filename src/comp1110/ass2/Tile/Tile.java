package comp1110.ass2.Tile;

public class Tile {

    private final TileType TILE_TYPE;
    private final TileColor TILE_COLOR;
    private TileLocation tileLocation;
    public int col;
    public int row;

    /**
     * Constructor of Tile
     * The location of initializing tile is in bag
     * Initialize the color of tile according to the tile's type
     *
     * @param type  the type of the tile
     */
    public Tile(TileType type) {
        this.tileLocation= TileLocation.Bag;
        this.TILE_TYPE = type;
        switch (type){
            case A -> this.TILE_COLOR = TileColor.Blue;
            case B -> this.TILE_COLOR = TileColor.Green;
            case C -> this.TILE_COLOR = TileColor.Orange;
            case D -> this.TILE_COLOR = TileColor.Purple;
            case E -> this.TILE_COLOR = TileColor.Red;
            case First -> this.TILE_COLOR = TileColor.Black;
            default -> this.TILE_COLOR = null;
        }
    }

    /**
     * Constructor of Tile that mainly used when teh tile is in the Mosaic pile
     *
     * @param type the type of the tile
     * @param col the col number in mosaic
     * @param row the row number in mosaic
     */
    public Tile(TileType type, int col, int row) {
        this.tileLocation= TileLocation.Mosaic;
        this.TILE_TYPE = type;
        this.col = col;
        this.row = row;
        switch (type){
            case A -> this.TILE_COLOR = TileColor.Blue;
            case B -> this.TILE_COLOR = TileColor.Green;
            case C -> this.TILE_COLOR = TileColor.Orange;
            case D -> this.TILE_COLOR = TileColor.Purple;
            case E -> this.TILE_COLOR = TileColor.Red;
            case First -> this.TILE_COLOR = TileColor.Black;
            default -> this.TILE_COLOR = null;
        }
    }

    /**
     *Get private field TILE_TYPE of tile
     *
     */
    public TileType getTILE_TYPE() {
        return TILE_TYPE;
    }

    /**
     *Get private field TILE_COLOR of tile
     *
     */
    public TileColor getTILE_COLOR() {
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

