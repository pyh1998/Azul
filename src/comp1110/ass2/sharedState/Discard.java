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
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
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
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
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
     * @author QinLing Zhong
     *
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
     * @author Yuhui Pang
     *
     *Check if the discard is empty
     *
     * @return return true if the totalNum is zero
     */
    public boolean isEmpty(){
        return totalNum == 0;
    }

    /**
     * @author Yuhui Pang
     *
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
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     *Get private field tile_num of Discard
     *
     */
    public int[] getTile_num() {
        return tile_num;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     *Get private field totalNum of Discard
     *
     */
    public int getTotalNum() {
        return totalNum;
    }

    /**
     * @author Yuhui Pang
     *
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
     * @author Yuhui Pang
     *
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

    /**
     * @author Yuhui Pang
     *
     * Get tiles from the storage after tilling tiles to mosaic
     *
     * @param type the tile type
     * @param num the tile number
     */
    public void getTileFromStorage(char type,int num){
        this.totalNum += num;
        this.tile_num[Tile.CharToTile(type).getTILE_ID()] += num;
    }

}
