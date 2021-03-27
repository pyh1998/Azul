package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.shareState.Discard;

public class Floor {
    /**
     * The maximum number of tiles that the floor can hold.
     */
    public final int MAX_LENGTH = 7;

    public int number;
    public Tile[] tiles;

    /**
     * Constructor of the Floor
     * @param number number of tiles inside the floor
     * @param tiles tiles inside the floor
     */
    public Floor(int number, Tile[] tiles) {
        this.number = number;
        this.tiles = tiles;
    }

    /**
     * Add tiles to the floor
     * @param tiles the tiles need to be added to the floor
     * @param floor the current floor to add thr tiles
     */
    public void floorAddTiles(Tile[] tiles, Floor floor) {
        // TODO: FIX the function of floorAddTiles
    }

    /**
     * After scoring, moves the all tiles in the floor to the discard pile
     * @param floor the current floor
     * @param discard the current discard
     */
    public void moveTilesToDiscard(Floor floor, Discard discard) {
        // TODO: FIX the function of moveTilesToDiscard

    }
    /**
     * empty the floor
     */
    public void emptyFloor() {
        this.number = 0;
        this.tiles = new Tile[0];
    }
    /**
     * get the number of tiles in the floor.
     * @return number of the tiles
     */
    public int getNumber() {
        return number;
    }

    /**
     * get all tiles in the floor.
     * @return tiles inside the floor
     */
    public Tile[] getTiles() {
        return tiles;
    }
}
