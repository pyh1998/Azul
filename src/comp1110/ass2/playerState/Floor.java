package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.shareState.Discard;

public class Floor {
    /**
     * The maximum number of tiles that the floor can hold.
     */
    public final static int MAX_LENGTH = 7;

    public int number;
    private Tile[] tiles;

    /**
     * Constructor of the Floor
     * @param number number of tiles inside the floor
     * @param tiles tiles inside the floor
     */
    public Floor(int number, Tile[] tiles) {
        this.number = number;
        this.tiles = tiles;
    }

    public Floor(String stateStr){
        this.number = stateStr.length() - 1;
        this.tiles = new Tile[MAX_LENGTH];
        for(int i = 1;i<stateStr.length();i++){
            char tile = stateStr.charAt(i);
            tiles[i-1] = Tile.CharToTile(tile);
        }
    }


    public static boolean isWellFormed(String floorStr){
        if (floorStr.length() > 8) return false;
        for (int j = 1, k = 0; j < floorStr.length(); j++) { // flag
            k += (floorStr.charAt(j) == 'f') ? 1 : 0;
            if (j + 1 < floorStr.length() && floorStr.charAt(j) > floorStr.charAt(j + 1)) return false;
            if (floorStr.charAt(j) < 'a' || floorStr.charAt(0) > 'f' || k > 1) return false;
        }
        return true;
    }

    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('F');
        for(int i=0;i< tiles.length;i++){
            if (tiles[i] != null)
                state.append(tiles[i].getTILE_TYPE());
        }
        return state.toString();
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
