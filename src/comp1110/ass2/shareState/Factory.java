package comp1110.ass2.shareState;

import comp1110.ass2.Tile;
import comp1110.ass2.TileColor;

public class Factory {
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
