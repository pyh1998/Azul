package comp1110.ass2;

public class Tile {

    char type;
    String color;
    /**
     * Constructor that is mainly used for testing purposes.
     *
     * @param type   the type of the tile
     */
    public Tile(TileType type) {

    }
}
/**
 * The type of the tiles.
 */
enum TileType {
    A, B, C, D, E, First;
}
/**
 * The color of the tiles.
 */
public enum TileColor {
    Blue, Green, Orange, Purple, Red, Black;
}
/**
 * The location of the tile.
 */
enum Location {
    Factory, Centre, Bag, Discard, Mosaic, Storage, Floor;
}
