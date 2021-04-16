package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mosaic {
    public static final int HEIGHT = 5;
    public static final int WIDTH = 5;

    public Tile[][] tiles;

    int col;
    int row;

    /**
     * Constructor of the mosaic pile
     * @param stateStr
     */
    //Ma02a13b00e42
    public Mosaic(String stateStr) {
        tiles = new Tile[HEIGHT][WIDTH];
        for(int i = 1;i<stateStr.length();i+=3){
            char tile = stateStr.charAt(i);
            int row = stateStr.charAt(i+1)-'0';
            int column = stateStr.charAt(i+2)-'0';
            tiles[row][column] = Tile.CharToTile(tile);
        }
    }


    public static boolean isWellFormed(String mosaicStr){
        if (mosaicStr.length() > 76 || (mosaicStr.length() - 1) % 3 != 0) return false;
        for (int j = 1; j < mosaicStr.length(); j += 3) {
            String s = mosaicStr.substring(j, j + 3);
            if ((s.charAt(0) < 'a' || s.charAt(0) > 'e') || (s.charAt(1) < '0' || s.charAt(1) > '4')
                    || (s.charAt(2) < '0' || s.charAt(2) > '4')) return false;
        }
        return true;
    }


    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append('M');
        List<String> list = new ArrayList<>();
        for(int i = 0; i < tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                if(tiles[i][j] != null) {
                    StringBuilder str = new StringBuilder();
                    str.append(tiles[i][j].getTILE_TYPE());
                    str.append(i);
                    str.append(j);
                    list.add(str.toString());
                }
            }
        }
        Collections.sort(list);
        for (String s : list) {
            state.append(s);
        }
        return state.toString();
    }
    /**
     * Perform a valid tiling move
     * @param tile the tile to be placed
     * @param col the col number
     * @param row teh row number
     */
    public void addTileToMosaic(Tile tile, int col, int row) {
        // TODO FIX the function of addTileToMosaic
    }

    /**
     * Check whether placement of tile to the storage is valid
     *      * Each row and column of the mosaic may not contain more than one tile of the same colour
     *      * (much like a sudoku).
     *      *
     *      * If you are unable to move a tile of a certain colour across because there is no valid space
     *      * left for it, you must place all tiles from that row onto your floor instead.
     * @param tile the tile to be placed to the mosaic pile
     * @param col the col number
     * @param row teh row number
     */
    public void isValidPlacement(Tile tile, int col, int row) {

    }

    /**
     * get all tiles placed on the mosaic pile
     * @return all tiles placed on the mosaic pile
     */
    public Tile[][] getTiles() {
        return tiles;
    }
}
