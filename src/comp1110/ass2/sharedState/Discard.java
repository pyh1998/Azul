package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;
import javafx.scene.paint.Color;

public class Discard {

    /**
     * Field MAX_SIZE: The maximum size of tiles that the Discard can hold
     * Field TILE_TYPE_NUMBER: The number of the kind of the tiles
     * Field tile_num: The array of the number of different type of tiles in Discard
     * Field totalNum: The total number of the tiles in Discard
     */
    public static final int MAX_SIZE = 20;
    public static final int TILE_TYPE_NUMBER = 5;
    private int[] tile_num;
    private int totalNum;


    /**
     * Constructor of Discard
     * Initialize the tiles number of number of the kind of the tiles
     * Initialize the total number of the tiles in Discard
     *
     */
    public Discard() {
        tile_num = new int[TILE_TYPE_NUMBER];
        totalNum = 0;
    }

    /**
     * Constructor of Discard according to the state string,like "D0005201020“
     * Initialize the total tile number in Discard
     * Initialize the number of different type of tiles in Discard
     *
     * @param stateStr the state string of bag part
     */
    //D0005201020
    public Discard(String stateStr){
        tile_num = new int[TILE_TYPE_NUMBER];
        int index = 0;
        int count =0;
        for(int i=1;i<stateStr.length();i+=2){
            int num=Integer.parseInt(stateStr.substring(i,i+2));
            tile_num[index] = num;
            count += num;
            index++;
        }
        totalNum = count;
    }

    /**
     * Check if the state string is well-formed
     *
     * @param discardStr the state string of discard part
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String discardStr){
        if (discardStr.length() > (1 + 5 * 2)) {
            return false;
        }
        for (int i = 1; i < 11; i++) if (!Character.isDigit(discardStr.charAt(i))){
            return false;
        }
        return true;
    }

    /**
     *Check if the discard is empty
     *
     * @return return true if the totalNum is zero
     */
    public boolean isEmpty(){
        return totalNum == 0;
    }

    /**
     * Get the state string of the discard
     *
     * @return the state string of the discard
     */
    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('D');
        for(int i=0;i<TILE_TYPE_NUMBER;i++){
            if(tile_num[i] < 10){
                state.append('0');
            }
            state.append(tile_num[i]);
        }
        return state.toString();
    }

    /**
     *Get private field tile_num of Discard
     *
     */
    public int[] getTile_num() {
        return tile_num;
    }

    /**
     *Get private field totalNum of Discard
     *
     */
    public int getTotalNum() {
        return totalNum;
    }


    /**
     * Add tiles to Discard from Storage and Floor
     * Update the array of tiles
     *
     * @param tiles the array of tiles from other places
     */
    public void addTiles(Tile[] tiles){
        for (Tile tile: tiles) {
            switch (tile.getTILE_TYPE()) {
                case 'a' -> tile_num[0] ++;
                case 'b' -> tile_num[1] ++;
                case 'c' -> tile_num[2] ++;
                case 'd' -> tile_num[3] ++;
                case 'e' -> tile_num[4] ++;
            }
            totalNum ++;
        }
    }
    /**
     * Move all tiles to Bag when Bag has no tile
     * Make the number of Discard equals zero and empty the array of tiles
     *
     */
    public int[] moveTileToBag(){
        int[] tileNum = this.tile_num;
        this.tile_num = new int[TILE_TYPE_NUMBER];
        return tileNum;
    }

    /**
     * Get tiles from the floor when the round is over
     *
     * @param tiles the tiles in the floor need to move to discard
     */
    public void getTileFromFloor(Tile[] tiles){
        this.totalNum += tiles.length;
        for (Tile tile : tiles) {
            this.tile_num[tile.getTILE_ID()]++;
        }
    }

}
