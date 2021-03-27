package comp1110.ass2.play;

import comp1110.ass2.Tile.Tile;

public class Scoring {
    public int score;

    /**
     * Initialize the score be zero
     *
     */
    public Scoring() {
        this.score = 0;
    }

    /**
     * Calculate the score when tilled the tile to the Mosaic
     * Update the current score
     */
    public void gainscore(){
        //TODO FINISH THE RULE OF GAIN SCORE

    }

    /**
     * Calculate the lost score when round finished
     * Update the current score
     *
     * @param tiles the array of tiles in Floor
     */
    public void losescore(Tile[] tiles){
        //TODO FINISH THE RULE OF LOSE SCORE
    }

    /**
     * Calculate the bonus score when game finished
     * Update the current score
     *
     * @param tiles Two dimensional array of tiles in Mosaic
     */
    public void bonusscore(Tile[][] tiles){
        //TODO FINISH THE RULE OF LOSE SCORE
    }


}
