package comp1110.ass2.shareState;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.Tile.TileColor;

public class Factory {
    /**
     * The capacity of the each factory.
     * Every factory has 4 regions to place tiles.
     */
    public final int FACTORY_CAPACITY = 4;
    private final int FACTORY_INDEX;
    public Tile[] tiles;

    /**
     * Constructor of Factory
     * Initialize the index of Factory
     * Initialize the tiles included in this factory
     *
     * @param index the index of the Factory
     */
    public Factory(int index) {
        this.FACTORY_INDEX = index;
        this.tiles = new Tile[FACTORY_CAPACITY];
    }

    /**
     *Get private field index of factory
     *
     */
    public int getIndex() {
        return this.FACTORY_INDEX;
    }

    /**
     *Get field tiles of factory
     *
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     *Set tiles of factory
     *
     */
    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }

    /**
     * Select tiles of the color in the current factory based on the color
     *
     * @param color the color player choose from this factory
     */
    public Tile[] selectTiles(TileColor color) {
        //TODO FIX the function of selectTiles
        return null;
    }

    /**
     * Get tiles to Factory from Bag
     *
     * @return Array of the tiles from Bag
     */
    public Tile[] getfromBag(){
        //TODO FIX the function of getfromBag
        return null;
    }

    /**
     * Move the unselected tiles to Centre
     *
     */
    public void movetoCentre(){
        //TODO FIX the function of movetoCentre
    }


}
