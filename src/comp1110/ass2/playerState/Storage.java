package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class Storage {
    /**
     * Field NUMBER_ROWS: The number of rows of the Storage
     * Field TILE_TYPE_NUMBER: The maximum types of the tiles
     * Field tileType: The tile types of the Storage
     * Field tileNumber: The number of tiles of each tile type
     */
    public static final int NUMBER_ROWS = 5;
    public static final int TILE_TYPE_NUMBER = 5;
    private Tile[] tileType;
    private int[] tileNumber;

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Create an array of tile array that stores all the tiles.
     * The index of tile array indicated the row number.
     */
    public Storage() {
        tileType = new Tile[TILE_TYPE_NUMBER];
        tileNumber = new int[NUMBER_ROWS];
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the Storage according to the state string, like S2a13e44a1
     *
     * Initialize the tile type types of the Storage
     * Initialize the number of tiles of each tile type
     *
     * @param stateStr The state string of the Storage
     */
    public Storage(String stateStr){
        tileType = new Tile[TILE_TYPE_NUMBER];
        tileNumber = new int[NUMBER_ROWS];
        for(int i = 1; i < stateStr.length(); i += 3){
            int row = stateStr.charAt(i) - '0';
            char ch = stateStr.charAt(i+1);
            Tile tile = Tile.CharToTile(ch);
            int num = stateStr.charAt(i + 2) - '0';
            tileType[row] = tile;
            tileNumber[row] = num;
        }
    }

    /**
     * @author QinLing Zhong
     *
     * Check if the state string is well formed
     *
     * @param storageStr the state string of the Storage
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String storageStr){
        if (storageStr.length() > 16 || (storageStr.length() - 1) % 3 != 0) return false;
        for (int j = 1; j < storageStr.length(); j += 3) {
            String s = storageStr.substring(j, j + 3);
            if ((s.charAt(0) < '0' || s.charAt(0) > '4') || (s.charAt(1) < 'a' || s.charAt(0) > 'e')
                    || (s.charAt(2) < '0' || s.charAt(0) > '5')) return false;
        }
        return true;
    }

    /**
     * @author Yuhui Pang
     *
     * Check if the storage has full rows
     * @return if the storage has full rows return true
     */
    public boolean hasFullRow(){
        for(int i = 0;i<tileNumber.length;i++){
            if(tileNumber[i] == i+1) return true;
        }
        return false;
    }

    /**
     * @author Yuhui Pang
     *
     * Get the state string of the Storage
     * @return the state string of the Storage
     */
    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('S');
        for(int i=0;i< tileType.length;i++){
            if (tileType[i] != null){
                state.append(i);
                state.append(tileType[i].getTILE_TYPE());
                state.append(tileNumber[i]);
            }
        }
        return state.toString();
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get the tile types of the Storage
     * @return the tile types of the Storage
     */
    public Tile[] getTileType() {
        return tileType;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get the number of tiles of each tile type
     * @return the number of tiles of each tile type
     */
    public int[] getTileNumber() {
        return tileNumber;
    }


    /**
     * @author Jiawen Wang
     *
     * Determine whether a row is complete. ie, whether the row is full
     * @param rowNumber the row number
     * @return whether a row is complete
     */
    public boolean rowIsComplete (int rowNumber) {
        if ((this.tileType[rowNumber] != null) && (this.tileNumber[rowNumber] == rowNumber + 1)) return true;
        return false;
    }

    /**
     * @author Yuhui Pang
     *
     * After picking up tiles, add them to one of the five storage rows
     *
     * @param rowNum the row number to add the tiles
     * @param tileNum the number of tiles that need to be added to storage
     * @param type the type of tiles that need to be added to storage
     *
     * @return the remain number of tiles need to add to floor
     */
    public void addTilesToStorage (int rowNum,int tileNum,char type) {
        if (this.tileType[rowNum] == null) {
            this.tileType[rowNum] = Tile.CharToTile(type);
            this.tileNumber[rowNum] = Math.min(tileNum, rowNum + 1);
        }
        else {
            this.tileNumber[rowNum] = Math.min(tileNum + tileNumber[rowNum], rowNum + 1);
        }
    }

    /**
     * @author Yuhui Pang
     *
     * the remaining tile number after picking tiles to storage
     * Get the remaining tile number after picking tiles to storage
     * @param rowNum the row number to add the tiles
     * @param tileNum the number of tiles that need to be added to storage
     * @param type the type of tiles that need to be added to storage
     * @return the remaining tile number after picking tiles to storage
     */
    public int getRemainTiles(int rowNum,int tileNum,char type){
        int remainNum = 0;
        if(tileNumber[rowNum] + tileNum > rowNum + 1){
            remainNum = tileNumber[rowNum] + tileNum - (rowNum + 1);
        }
        return remainNum;
    }

    /**
     * @author Yuhui Pang
     *
     * Get the tile type in certain row
     * @param row the row of storage
     * @return the type of tile in this row
     */
    public char getTileTypeByRow(int row){
        char type = tileType[row].getTILE_TYPE();
        emptyRow(row);
        return type;
    }

    /**
     * @author Jiawen Wang
     *
     * Decide whether a placement of tiles in the storage is valid.
     *
     * A row can only contain the same type of tiles.
     *
     * @param tileType a char of the type of tile
     * @param rowNumber the row number to add the tiles
     * @return whether the placement to a row in the storage is valid
     */
    public boolean isValidPlacement (char tileType, int rowNumber) {
        if (this.tileType[rowNumber] == null) {
            return true;
        } else if (this.tileType[rowNumber].getTILE_TYPE() == tileType) {
            return true;
        }
        return false;
    }


    /**
     * @author Jiawen Wang
     *
     * After placing the rightmost tile to the mosaic pile, empty the row;
     * @param rowNumber the row number of the row to be empty
     */
    public void emptyRow(int rowNumber) {
        this.tileType[rowNumber] = null;
        this.tileNumber[rowNumber] = 0;
    }


}
