package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.sharedState.Discard;

import java.util.Arrays;

public class Floor {
    /**
     * Field MAX_LENGTH: The maximum number of tiles that the Floor can hold
     * Field number: The total number of tiles in the Floor
     * Field tiles: The tiles in the Floor
     */
    public final static int MAX_LENGTH = 7;
    private int number;
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

    /**
     * Constructor of the Floor according to the state string,like "Faabbe“
     *
     * Initialize the total tile number in Floor
     * Initialize the tiles in Floor
     *
     * @param stateStr the state string of the Floor
     */
    public Floor(String stateStr){
        this.number = stateStr.length() - 1;
        this.tiles = new Tile[number];
        for(int i = 1;i<stateStr.length();i++){
            char tile = stateStr.charAt(i);
            tiles[i-1] = Tile.CharToTile(tile);
        }
    }

    /**
     * Check if the state string is well-formed
     *
     * @param floorStr the state string of the Floor
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String floorStr){
        if (floorStr.length() > 8) return false;
        for (int j = 1, k = 0; j < floorStr.length(); j++) { // flag
            k += (floorStr.charAt(j) == 'f') ? 1 : 0;
            if (j + 1 < floorStr.length() && floorStr.charAt(j) > floorStr.charAt(j + 1)) return false;
            if (floorStr.charAt(j) < 'a' || floorStr.charAt(0) > 'f' || k > 1) return false;
        }
        return true;
    }

    /**
     *Get the lose points by the number of tiles in Floor
     * @return the lose points (negative)
     */
    public int getLostPoint(){
        return switch (this.number) {
            case 0 -> 0;
            case 1 -> -1;
            case 2 -> -2;
            case 3 -> -4;
            case 4 -> -6;
            case 5 -> -8;
            case 6 -> -11;
            //>=7
            default -> -14;
        };
    }

    /**
     * Get the state string of the floor
     *
     * @return the state string of the floor
     */
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
     * After scoring, moves the all tiles except first-player-token in the floor to the discard pile
     *
     */
    public Tile[] moveTilesToDiscard() {
        Tile[] tilesToDiscard;
        if(tiles[number - 1] == Tile.FIRST_PLAYER) tilesToDiscard = Arrays.copyOf(tiles,number - 1);
        else tilesToDiscard = this.tiles;
        this.number = 0;
        this.tiles = new Tile[number];
        return tilesToDiscard;
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

    /**
     * check if the floor is full
     * @return return true if the floor is true
     */
    public boolean isFull(){
        return this.number == 7;
    }

    public void getTiles(int num,char type){

    }
}
