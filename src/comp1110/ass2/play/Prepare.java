package comp1110.ass2.play;

import comp1110.ass2.shareState.Bag;
import comp1110.ass2.shareState.Discard;
import comp1110.ass2.shareState.Factory;

public class Prepare {
    public boolean beginning;
    public boolean isEnd;
    public Bag bag;
    public Factory factory;
    public Discard discard;

    /**
     * Constructor that is mainly used for testing purposes.
     *
     * @param beginning
     * @param isEnd
     * @param bag
     * @param factory
     * @param discard
     */
    public Prepare(boolean beginning, boolean isEnd, Bag bag, Factory factory, Discard discard) {
        this.beginning = beginning;
        this.isEnd = isEnd;
        this.bag = bag;
        this.factory = factory;
        this.discard = discard;
    }

    /**
     * Update the share state depending on the whether the game is the beginning or end.
     * @param beginning
     * @param isEnd
     */
    public void updateState(boolean beginning, boolean isEnd) {
        // if it is the beginning of the game, set up the initial game state.
        if (beginning) {

            // if the game reaches the end, no more updating
        } else if (isEnd) {

            // update the game state, prepare the next round
        } else {
        }
    }

    /**
     * setup the game state at the start of the game.
     */
    public void initialise () {
    }

    /**
     * fill the factory
     */
    public void factoryFill (Bag bag) {

    }

    /**
     * refill the bag from teh discard if the bag is empty
     */
    public void refillBag (Bag bag, Discard discard) {

    }

}
