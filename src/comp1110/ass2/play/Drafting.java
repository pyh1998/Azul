package comp1110.ass2.play;

import comp1110.ass2.Tile.Tile;

public class Drafting {
    public Tile[] movement = new Tile[2];
    public Tile before;
    public Tile after;

    /**
     * Constructor of the Drafting move
     * @param movement an array of Tiles contains the tile before and after the move
     */
    public Drafting(Tile[] movement) {
        this.movement = movement;
        this.before = movement[0];
        this.after = movement[1];
    }

    public boolean isValidDrafting (Tile[] movement) {
        // TODO FIX the function of isValidDrafting
        return false;
    }

    /**
     * set the tile before Drafting move
     * @param before the tile before Drafting move
     */
    public void setBefore(Tile before) {
        this.before = before;
    }

    /**
     * set the tile after Drafting move
     * @param after the tile after Drafting move
     */
    public void setAfter(Tile after) {
        this.after = after;
    }

    /**
     * get the Drafting move
     * @return an array of Tiles contains the tile before and after the move
     */
    public Tile[] getMovement() {
        return movement;
    }

    /**
     * get the tile before the Drafting move
     * @return the tile before the Drafting move
     */
    public Tile getBefore() {
        return before;
    }

    /**
     * get the tile after the Drafting move
     * @return
     */
    public Tile getAfter() {
        return after;
    }
}
