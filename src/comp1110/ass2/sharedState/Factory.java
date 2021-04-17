package comp1110.ass2.sharedState;

import comp1110.ass2.Tile.Tile;

import java.util.Arrays;

public class Factory {
    /**
     * The capacity of the each factory.
     * Every factory has 4 regions to place tiles.
     */
    public final int FACTORY_CAPACITY = 4;
    public final int FACTORY_NUMBER = 9;
    public Tile[][] tiles;
    public int totalNum;

    /**
     * Constructor of Factory by the state string
     * Initialize the total number of tiles in Factory
     * Initialize the tiles included in this factory
     *
     * @param stateStr the state string of Factory
     */
    // F1aabc2abbb4ddee
    public Factory(String stateStr) {
        //this.FACTORY_NUMBER = (state.length()-1)/5;
        int count = 0;
        this.tiles = new Tile[FACTORY_NUMBER][FACTORY_CAPACITY];
        for (int i = 1; i < stateStr.length(); i += 5) {
            int row = stateStr.charAt(i) - '0';
            for (int j = i + 1; j < i + 5; j++) {
                int col = j - i - 1;
                char ch = stateStr.charAt(j);
                this.tiles[row][col] = Tile.CharToTile(ch);
                count++;
            }
        }
        totalNum = count;
    }

    /**
     * Check if the state string is well-formed
     *
     * @param factoryStr the state string of factory part
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String factoryStr){
        if (factoryStr.length() > (1 + 5 * 5)) {
            return false;
        }
        if ((factoryStr.length() - 1) % 5 != 0) {
            return false;
        }
        for (int i = 1; i < factoryStr.length(); i += 5) {
            if (!Character.isDigit(factoryStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     *Check if the factory is empty
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
        state.append('F');
        for (int i = 0; i < tiles.length; i++) {
            if(tiles[i][0] != null){
                state.append(i);
            }
            for (Tile tile : tiles[i]) {
                if (tile != null)
                    state.append(tile.getTILE_TYPE());
            }

        }
        return state.toString();
    }


    /**
     *Get field tiles of factory
     *
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     *Set tiles of factory
     *
     */
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Select tiles of the color in the current factory based on the color
     *
     * @param id the Tile id player choose from this factory
     */
    public Tile[] selectTiles(int id) {
        //TODO FIX the function of selectTiles
        return null;
    }

    /**
     * Get tiles to Factory from Bag
     *
     * @return Array of the tiles from Bag
     */
    public void getFromBag(Tile[] tiles){
        int factoryNum = tiles.length / FACTORY_CAPACITY;
        for(int i=0;i<factoryNum;i++){
            for(int j=0;j<FACTORY_CAPACITY;j++){
                if(this.tiles[i][j] == null){
                    this.tiles[i][j] = tiles[i*FACTORY_CAPACITY+j];
                }
            }
            Arrays.sort(this.tiles[i]);
        }

    }

    /**
     * Move the unselected tiles to Centre
     *
     */
    public void movetoCentre(){
        //TODO FIX the function of movetoCentre
    }


}
