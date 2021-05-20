package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.sharedState.Discard;

import java.util.*;


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
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the empty Floor
     */
    public Floor() {
        this.number = 0;
        this.tiles = new Tile[number];
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the Floor according to the state string,like "Faabbe“
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
     * @author QinLing Zhong
     *
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
     * @author Yuhui Pang
     *
     *Get the lose points by the number of tiles in Floor
     *
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
     * @author Yuhui Pang
     *
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
     * @author Yuhui Pang
     *
     * After scoring, moves the all tiles except first-player-token in the floor to the discard pile
     */
    public Tile[] moveTilesToDiscard() {
        Tile[] tilesToDiscard;
        if(number > 0 && tiles[number - 1] == Tile.FIRST_PLAYER) tilesToDiscard = Arrays.copyOf(tiles,number - 1);
        else tilesToDiscard = this.tiles;
        this.number = 0;
        this.tiles = new Tile[number];
        return tilesToDiscard;
    }

    /**
     * @author Jiawen Wang
     * empty the floor
     */
    public void emptyFloor() {
        this.number = 0;
        this.tiles = new Tile[0];
    }
    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     * get the number of tiles in the floor.
     * @return number of the tiles
     */
    public int getNumber() {
        return number;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     * get all tiles in the floor.
     * @return tiles inside the floor
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     * check if the floor is full
     * @return return true if the floor is true
     */
    public boolean isFull(){
        return this.number == 7;
    }

    /**
     * @author Yuhui Pang
     *
     * Add the tiles to floor and update the tiles and number in floor
     * @param num the number of tiles that need to be added to floor
     * @param type the type of tiles that need to be added to floor
     *
     */
    public void addTilesToFloor(int num,char type){
        if(type == 'f'){
            if(this.number == MAX_LENGTH){
                this.tiles[number - 1] = Tile.FIRST_PLAYER;
            }
        }

        int addNum = Math.min(MAX_LENGTH - number,num);
        this.number += addNum;

        List<Tile> list = new ArrayList<>(Arrays.asList(tiles));
        for(int i=addNum;i>0;i--){
            list.add(Tile.CharToTile(type));
        }
        this.tiles = list.toArray(new Tile[number]);
        Arrays.sort(this.tiles);
    }

    /**
     * @author Yuhui Pang
     *
     * Get the remaining tiles after adding tiles to floor when the floor is full
     *
     * @param num the number of tiles that need to be added to floor
     * @param type the type of tiles that need to be added to floor
     * @return the remaining tile array
     */

    public Tile[] getRemainTiles(int num,char type){
        Tile[] remain = new Tile[0];
        if(type == 'f' && this.number == MAX_LENGTH) remain = new Tile[]{tiles[number - 1]};
        else if (this.number + num > MAX_LENGTH){
            remain = new Tile[this.number + num - MAX_LENGTH];
            for(int i=0;i<remain.length;i++){
                remain[i] = Tile.CharToTile(type);
            }
        }
        return remain;
    }

    /**
     * @author Yuhui Pang
     *
     * Get total number of each type of tile in floor
     * @return the total number of each type of tile in floor
     */
    public int[] getTotalNumOfTiles(){
        int[] totalNum = new int[6];
        for(Tile tile : tiles){
            if(tile!=null) totalNum[tile.getTILE_ID()] ++;
        }
        return totalNum;
    }
}
