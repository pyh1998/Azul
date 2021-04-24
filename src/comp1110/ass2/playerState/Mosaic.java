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
     * Perform a valid tiling move
     * @param tile the tile to be placed
     * @param col the col number
     * @param row the row number
     */
    public void addTileToMosaic(Tile tile, int col, int row) {
        this.tiles[col][row] = tile;
    }

    /**
     * Check whether placement of tile to the mosaic is valid
     *      * Each row and column of the mosaic may not contain more than one tile of the same colour
     *      * (much like a sudoku).
     *      *
     *      * If you are unable to move a tile of a certain colour across because there is no valid space
     *      * left for it, you must place all tiles from that row onto your floor instead.
     * @param tile the tile to be placed to the mosaic pile
     * @param col the col number
     * @param row teh row number
     */
    public Boolean isValidPlacement(Tile tile, int col, int row) {
        if (this.tiles[row][col] != null) return false; // check for the position

        for (int r = 0; r < HEIGHT; r++) { // check for column
            if ((this.tiles[r][col] != null) && (this.tiles[r][col].getTILE_COLOR() == tile.getTILE_COLOR())) {
                return false;
            }
        }
        for (int c = 0; c < WIDTH; c++) { // check for row
            if ((this.tiles[row][c] != null) && (this.tiles[row][c].getTILE_COLOR() == tile.getTILE_COLOR())) {
                return false;
            }
        }
        return true;
    }

    /**
     * get all tiles placed on the mosaic pile
     * @return all tiles placed on the mosaic pile
     */
    public Tile[][] getTiles() {
        return tiles;
    }
}
