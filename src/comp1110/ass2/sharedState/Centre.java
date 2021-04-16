package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.Tile.TileColor;

public class Centre {

    /**
     *Field number: the number of tiles of the Centre
     *Field tiles: the array of tiles in Centre
     */
    private int number;
    private final Tile[] tiles;

    /**
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
     * Constructor of Centre
     * Initialize the tiles number of Centre
     * Initialize the tiles in Centre
     *
     */
    public Centre(int number) {
        this.number = 0;
        this.tiles = new Tile[number];
    }

    /**
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
     *Get private field number of Centre
     *
     */
    public int getNumber() {
        return number;
    }
    /**
     *Get the private field the tile array of Centre
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Add tiles to Centre from Factory
     * Update the array of tiles
     *
     * @param tiles the array of tiles from Factory
     */
    public void addTiles(Tile[] tiles){
        this.number += tiles.length;
        //TODO FIX the function of addTiles
    }

    /**
     * Select tiles of the color in the Centre based on the color
     *
     * @param color the color player choose from Centre
     */
    public void selectTiles(TileColor color){

        //TODO FIX the function of selectTiles
    }



}
