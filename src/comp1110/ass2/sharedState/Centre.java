package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;

public class Centre {

    /**
     *Field number: the number of tiles of the Centre
     *Field tiles: the array of tiles in Centre
     */
    private int number;
    private Tile[] tiles;

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
        char[] tileChar = new char[tiles.length];
        for (int i=0;i<tiles.length;i++) {
            tileChar[i] = tiles[i].getTILE_TYPE();
        }
        for(char ch : tileChar){
            state.append(ch);
        }
        return state.toString();
    }

    public void getFirstPlayerTileFromFloor(){
        this.number ++;
        this.tiles = new Tile[number];
        this.tiles[number - 1] = Tile.FIRST_PLAYER;
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
     * Select tiles of the color in the Centre based on the color and also update the centre.
     *
     * @param id the Tile id player choose from Centre
     * @param tile The kind of tile to choose
     * @return selected tiles from the centre
     */
    public Tile[] selectTiles(Tile tile, int id){
        //TODO FIX the function of selectTiles
        return null;
    }

    /**
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
}
