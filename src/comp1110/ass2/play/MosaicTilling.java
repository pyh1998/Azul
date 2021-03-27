package comp1110.ass2.play;

import comp1110.ass2.Tile.Tile;

public class MosaicTilling {
    public Tile[] movement = new Tile[2];
    public Tile before;
    public Tile after;

    /**
     * Constructor of the Tiling Move
     * @param movement an array of Tiles contains the tile before and after the move
     */
    public MosaicTilling(Tile[] movement) {
        this.movement = movement;
        this.before = movement[0];
        this.after = movement[1];
    }

    public boolean isValidTiling(Tile[] movement) {
        // TODO FIX the function of isValidDrafting
        return false;
    }

    /**
     * set the tile before Tiling Move
     * @param before the tile before Tiling Move
     */
    public void setBefore(Tile before) {
        this.before = before;
    }

    /**
     * set the tile after Tiling Move
     * @param after the tile after Tiling Move
     */
    public void setAfter(Tile after) {
        this.after = after;
    }

    /**
     * get the Tiling Move
     * @return an array of Tiles contains the tile before and after the Tiling Move
     */
    public Tile[] getMovement() {
        return movement;
    }

    /**
     * get the tile before the Tiling Move
     * @return the tile before the Tiling Move
     */
    public Tile getBefore() {
        return before;
    }

    /**
     * get the tile after the Tiling Move
     * @return
     */
    public Tile getAfter() {
        return after;
    }
}
