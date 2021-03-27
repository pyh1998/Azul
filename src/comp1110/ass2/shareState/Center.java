package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;

public class Center {
    int number = 0;
    public Tile[] tiles;

    public Center (int number) {
        this.number = number;
        this.tiles = new Tile[number];
    }

    public void setTiles (int number) {
        this.tiles = new Tile[number];
    }
}
