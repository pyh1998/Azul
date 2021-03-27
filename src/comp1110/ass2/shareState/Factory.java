package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.Tile.TileColor;

public class Factory {
    /**
     * The capacity of the each factory.
     */
    public final int FACTORY_CAPACITY = 4;

    int number = 0;
    public Tile[][] tiles;

    public Factory(int number) {
        this.number = number;
        this.tiles = new Tile[number][FACTORY_CAPACITY];
    }

    public Tile[] getTiles(TileColor color, int factoryIndex) {
        return null;
    }

}
