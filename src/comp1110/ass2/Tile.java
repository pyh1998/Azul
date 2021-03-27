package comp1110.ass2;

import comp1110.ass2.shareState.Bag;

public class Tile {

    private final TileType TILE_TYPE;
    private final TileColor TILE_COLOR;
    private TileLocation tileLocation;

    /**
     * Constructor that is mainly used for testing purposes.
     * The location of initializing tile is in bag
     *Initialize the color of tile according to the tile's type
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
/**
 * The type of the tiles.
 */
enum TileType {
    A, B, C, D, E, First;
}
/**
 * The location of the tile.
 */
enum TileLocation {
    Factory, Centre, Bag, Discard, Mosaic, Storage, Floor;

}
