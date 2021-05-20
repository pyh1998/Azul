package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mosaic {
    /**
     * Field HEIGHT: The height of the Mosaic
     * Field WIDTH: The width of the Mosaic
     * Field tiles: The tiles inside the Mosaic
     */
    public static final int HEIGHT = 5;
    public static final int WIDTH = 5;
    public Tile[][] tiles;

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the mosaic pile according to the state string, like "Ma02a13b00e42"
     *
     * Initialize the tiles in Mosaic
     *
     * @param stateStr the state string of the mosaic
     */
    public Mosaic(String stateStr) {
        tiles = new Tile[HEIGHT][WIDTH];
        for(int i = 1;i<stateStr.length();i+=3){
            char tile = stateStr.charAt(i);
            int row = stateStr.charAt(i+1)-'0';
            int column = stateStr.charAt(i+2)-'0';
            tiles[row][column] = Tile.CharToTile(tile);
        }
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the empty mosaic
     *
     * Initialize the tiles in Mosaic
     *
     */
    public Mosaic() {
        tiles = new Tile[HEIGHT][WIDTH];
    }

    /**
     * @author QinLing Zhong
     *
     * Check if the state string is well formed
     *
     * @param mosaicStr the state string of the Mosaic
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String mosaicStr){
        if (mosaicStr.length() > 76 || (mosaicStr.length() - 1) % 3 != 0) return false;
        for (int j = 1; j < mosaicStr.length(); j += 3) {
            String s = mosaicStr.substring(j, j + 3);
            if ((s.charAt(0) < 'a' || s.charAt(0) > 'e') || (s.charAt(1) < '0' || s.charAt(1) > '4')
                    || (s.charAt(2) < '0' || s.charAt(2) > '4')) return false;
        }
        return true;
    }

    /**
     * @author Yuhui Pang
     *
     * Get the state string of the Mosaic
     *
     * @return the state string of the Mosaic
     */
    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('M');
        List<String> list = new ArrayList<>();
        for(int i = 0; i < tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                if(tiles[i][j] != null) {
                    state.append(tiles[i][j].getTILE_TYPE());
                    state.append(i);
                    state.append(j);
                }
            }
        }
        return state.toString();
    }


    /**
     * @author Jiawen Wang
     *
     * Check whether placement of tile to the mosaic is valid
     * Each row and column of the mosaic may not contain more than one tile of the same colour
     * (much like a sudoku).
     * The position of the placement should have no tiles already in it.
     *
     * @param tileType the type of tile to be placed to the mosaic pile
     * @param col the col number
     * @param row the row number
     */
    public Boolean isValidPlacement(char tileType, int row, int col) {
        boolean isEmpty = this.tiles[row][col] == null;
        boolean checkCol = true;
        boolean checkRow = true;

        for (int r = 0; r < HEIGHT; r++) { // check for column
            if (this.tiles[r][col] != null && this.tiles[r][col].getTILE_TYPE() == tileType) checkCol = false;
        }
        for (int c = 0; c < WIDTH; c++) { // check for row
            if (this.tiles[row][c] != null && this.tiles[row][c].getTILE_TYPE() == tileType) checkRow = false;
        }
        return isEmpty && checkCol && checkRow;
    }

    /**
     * @author Jiawen Wang
     *
     * Check whether a mosaic row contains a specific tile
     *
     * @param tileType the specific tile type
     * @param row the row number
     * @return whether a mosaic row contains a specific tile
     */
    public Boolean rowIsContained(char tileType, int row) {
        Tile[] tiles = this.tiles[row];
        for (int c = 0 ; c < WIDTH; c++) {
            if (tiles[c] != null && tiles[c].getTILE_TYPE() == tileType) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * get all tiles placed on the mosaic pile
     * @return all tiles placed on the mosaic pile
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * @author Yuhui Pang
     *
     * Perform a valid tiling move
     * @param type the tile type to be placed
     * @param col the col number
     * @param row the row number
     */
    public void tillingTileToMosaic(char type,int row,int col){
        this.tiles[row][col] = Tile.CharToTile(type);
    }

    /**
     * @author Yuhui Pang
     *
     * get the score need be added after tilling
     *
     * @param col the col number
     * @param row the row number
     */
    public int getTillingScore(int row,int col){
        int count = 1;
        boolean rowFlag = false;
        boolean colFlag = false;
        int right = col + 1;
        int left = col - 1;
        int down = row + 1;
        int up = row - 1;
        while(right < WIDTH && tiles[row][right] != null){
            count++;
            right++;
            rowFlag = true;
        }
        while(left >= 0 && tiles[row][left] != null){
            count++;
            left--;
            rowFlag = true;
        }
        while(down < HEIGHT && tiles[down][col] != null){
            count++;
            down++;
            colFlag = true;
        }
        while(up >= 0 && tiles[up][col] != null){
            count++;
            up--;
            colFlag = true;
        }
        if(rowFlag && colFlag) count++;
        return count;
    }

    public static final char[][] BeginnerMosaic = {{'a','b','c','d','e'},
                                                    {'e','a','b','c','d'},
                                                    {'d','e','a','b','c'},
                                                    {'c','d','e','a','b'},
                                                    {'b','c','d','e','a'}
                                                   };
    /**
     * Find the column of the mosaic in beginner mode.
     * @param row the row of the mosaic
     * @param tile the tile should be put
     * @return the column
     */
    public static int getColInBeginnerMosaic(int row, Tile tile) {
        for (int i=0;i<WIDTH;i++) {
            if (tile.getTILE_TYPE() == BeginnerMosaic[row][i]) return i;
        }
        return -1;
    }

    /**
     * @author Yuhui Pang
     *
     * Get total number of each type of tile in floor
     * @return the total number of each type of tile in floor
     */
    public int[] getTotalNumOfTiles(){
        int[] totalNum = new int[6];
        for(Tile[] tiles1 : tiles){
            for(Tile tile : tiles1){
                if(tile!=null) totalNum[tile.getTILE_ID()] ++;
            }
        }
        return totalNum;
    }

}
