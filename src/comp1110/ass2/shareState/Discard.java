package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;

public class Discard {
    int number = 0;
    public Tile[] tiles;

    public Discard(int number, Tile[] tiles) {
        this.number = number;
        this.tiles = tiles;
    }
}
