package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class Storage {
    public final int NUMBER_ROWS = 5;
    public Tile[][] tiles = new Tile[NUMBER_ROWS][];

    public Storage() {
        for (int i = 1; i <= 5; i++) {
            this.tiles[i-1] = new Tile[i];
        }
    }

}
