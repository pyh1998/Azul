package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;

import java.util.Random;


public class Bag {
    /**
     * Field MAX_SIZE: The maximum size of tiles that the bag can hold
     * Field TILE_TYPE_NUMBER: The number of the kind of the tiles
     * Field tile_num: The array of the number of different type of tiles in Bag
     * Field totalNum: The total number of the tiles in bag
     */
    public static final int MAX_SIZE = 20;
    public static final int TILE_TYPE_NUMBER = 5;
    private final int[] tile_num;
    private int totalNum;


    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of Bag
     * Initialize the total tile number in Bag
     * Initialize the number of different type of tiles in Bag
     *
     */
    public Bag () {
        totalNum = 100;
        tile_num = new int[TILE_TYPE_NUMBER];
        for(int i=0;i<TILE_TYPE_NUMBER;i++){
            tile_num[i] = MAX_SIZE;
        }
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of Bag according to the state string,like "B0005201020“
     * Initialize the total tile number in Bag
     * Initialize the number of different type of tiles in Bag
     *
     * @param stateStr the state string of bag part
     */
    //B0005201020
    public Bag(String stateStr){
        tile_num = new int[TILE_TYPE_NUMBER];
        int index = 0;
        int count = 0;
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
     * @param bagStr the state string of bag part
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    //B0005201020
    public static boolean isWellFormed(String bagStr){
        if (bagStr.length() > (1 + 5 * 2)) {
            return false;
        }
        for (int i = 1; i < 11; i++) if (!Character.isDigit(bagStr.charAt(i))) {
            return false;
        }
        return true;
    }

    /**
     * @author Yuhui Pang
     *
     *Check if the bag is empty
     *
     * @return return true if the totalNum is zero
     */
    public boolean isEmpty(){
        return totalNum == 0;
    }

    /**
     * @author Yuhui Pang
     *
     * Get the state string of the bag
     *
     * @return the state string of the bag
     */
    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('B');
        for(int i=0;i<TILE_TYPE_NUMBER;i++){
            if(tile_num[i] < 10){
                state.append('0');
            }
            state.append(tile_num[i]);
        }
        return state.toString();
    }

    /**
     * @author Yuhui Pang
     *
     *Get the number of the tiles with certain type
     *
     * @param  tileType the char of the tile type,like 'a','b'
     * @return the number of the certain type tile
     */
    public int getTileNumByChar(char tileType) {
        int num;
        switch(tileType){
            case 'a' -> num = tile_num[0];
            case 'b' -> num = tile_num[1];
            case 'c' -> num = tile_num[2];
            case 'd' -> num = tile_num[3];
            case 'e' -> num = tile_num[4];
            default -> num = 0;
        }
        return num;
    }

    /**
     * @author Yuhui Pang
     *
     * Add tiles to Factory from Bag
     * Update the array of tiles
     *
     * @return the tile need to add to Factory
     */
    public Tile addToFactory(){
        if(totalNum == 0) return null;
        Random random = new Random();
        int randomNumber = random.nextInt(totalNum);
        int index = 0;
        for(int i=0;i<tile_num.length;i++){
            if(tile_num[i] != 0){
                for(int j=0;j<tile_num[i];j++){
                    if(index == randomNumber){
                        tile_num[i] --;
                        return Tile.idToTile(i);
                    }
                    index++;
                }
            }
        }
        return null;
    }

    /**
     * @author Yuhui Pang
     *
     * Add tiles to Factory from Bag
     * Update the array of tiles in Bag
     *
     * @param tile_num the array of the number of different kinds of tiles in discard
     */
    public void getTilesFromDiscard(int[] tile_num){
        if(totalNum == 0){
            int count = 0;
            for(int i=0;i<tile_num.length;i++){
                this.tile_num[i] = tile_num[i];
                count += tile_num[i];
            }
            this.totalNum = count;
        }
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     *Get field the tile_num of Bag
     *
     */
    public int[] getTile_num() {
        return tile_num;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     *Get field the totalNum of Bag
     *
     */
    public int getTotalNum() {
        return totalNum;
    }
}
