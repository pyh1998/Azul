package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Centre {

    /**
     *Field number: the number of tiles of the Centre
     *Field tiles: the array of tiles in Centre
     */
    private int number;
    private Tile[] tiles;

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of Centre by the state string of Centre pat
     * Initialize the tiles number of Centre
     * Initialize the tiles in Centre
     *
     * @param stateStr the state string of Centre pat
     */
    public Centre(String stateStr){
        this.number = stateStr.length()-1;
        tiles = new Tile[this.number];
        for(int i=1;i<stateStr.length();i++){
            char ch=stateStr.charAt(i);
            tiles[i-1]=Tile.CharToTile(ch);
        }
    }


    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of Centre
     * Initialize the tiles number of Centre
     * Initialize the tiles in Centre
     *
     */
    public Centre() {
        this.number = 1;
        this.tiles = new Tile[]{Tile.FIRST_PLAYER};
    }

    /**
     * @author QinLing Zhong
     *
     * Check if the state string is well-formed
     *
     * @param centreStr the state string of centre part
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    //Caaabcdde
    public static boolean isWellFormed(String centreStr){
        if (centreStr.length() > 16) return false;
        for(int i=2;i<centreStr.length();i++){
            if(centreStr.charAt(i) < centreStr.charAt(i - 1)) return false;
        }
        return true;
    }

    public boolean isEmpty(){
        if(this.number == 1 && tiles[0] == Tile.FIRST_PLAYER) return true;
        return this.number == 0;

    }
    /**
     * @author Yuhui Pang
     *
     * Get the state string of the centre
     *
     * @return the state string of the centre
     */
    public String getStateStr() {
        StringBuilder state = new StringBuilder();
        state.append('C');
        for (Tile tile : tiles) {
            state.append(tile.getTILE_TYPE());
        }
        return state.toString();
    }

    /**
     * @author Yuhui Pang
     *
     * get the first-player-token from floor
     * if this floor has first-player-token before next round
     */
    public void getFirstPlayerTileFromFloor(){
        this.number ++;
        this.tiles = new Tile[number];
        this.tiles[number - 1] = Tile.FIRST_PLAYER;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get private field number of Centre
     *
     */
    public int getNumber() {
        return number;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     *Get the private field the tile array of Centre
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * @author Yuhui Pang
     *
     * Check if Centre has fist-player-token
     * @return if centre has first-player-token return true
     */
    public boolean hasFirst() {
        return tiles[number-1] == Tile.FIRST_PLAYER;
    }

    /**
     * @author Yuhui Pang
     *
     * Add tiles to Centre from Factory
     * Update the array of tiles
     *
     * @param addTiles the array of tiles from Factory
     */
    public void addTiles(Tile[] addTiles){
        List<Tile> list = new ArrayList<>(Arrays.asList(tiles));
        this.number += addTiles.length;
        Collections.addAll(list, addTiles);
        tiles = list.toArray(new Tile[number]);
        Arrays.sort(tiles);
    }

    /**
     * @author Yuhui Pang
     *
     * Select tiles of the color in the Centre based on the color and also update the centre.
     *
     * @param ch the Tile char player choose from Centre
     * @return the number of selected tiles from the centre
     */
    public int selectTilesFromCentre(char ch){
        int count = 0;
        for(int i=0;i<this.number;i++){
            if(tiles[i].getTILE_TYPE() == ch){
                count++;
                tiles[i] = null;
            }
        }
        this.number -= count;
        Tile[] newTiles =new Tile[number];
        int index = 0;
        for(Tile tile : tiles){
            if(tile != null && tile!= Tile.FIRST_PLAYER){
                newTiles[index++]=tile;
            }
        }
        this.tiles = newTiles;
        return count;
    }

    /**
     * @author Jiawen Wang
     *
     * Check whether there is at least one tile of the specific type in centre
     * @param tileType the specific type of tile
     * @return whether there is at least one tile of the specific type
     */
    public boolean atLeastOneTile(char tileType) {
        for (int i = 0; i < number; i++) {
            if (this.tiles[i].getTILE_TYPE() == tileType) return true;
        }
        return false;
    }

    /**
     * @author Jiawen Wang
     * get unique tiles inside the centre
     * @return an array of unique tiles inside the centre
     */
    public ArrayList<Tile> uniqueTileType() {
        ArrayList<Tile> unique = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (!unique.contains(this.tiles[i]) && this.tiles[i].getTILE_TYPE() != 'f') {
                unique.add(this.tiles[i]);
            }
        }
        return unique;
    }
}
