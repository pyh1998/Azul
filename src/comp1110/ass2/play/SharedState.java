package comp1110.ass2.play;

import comp1110.ass2.shareState.Bag;
import comp1110.ass2.shareState.Centre;
import comp1110.ass2.shareState.Discard;
import comp1110.ass2.shareState.Factory;

public class SharedState {
    private Bag bag;
    private Centre centre;
    private Discard discard;
    private Factory factory;
    private char player;


    public SharedState(String shareStateStr){
        int indexF = shareStateStr.indexOf("F",1);
        int indexC = shareStateStr.indexOf("C",1);
        int indexB = shareStateStr.indexOf("B",1);
        int indexD = shareStateStr.indexOf("D",1);
        String factoryStr = shareStateStr.substring(indexF, indexC);
        String centreStr = shareStateStr.substring(indexC, indexB);
        String bagStr = shareStateStr.substring(indexB, indexD);
        String discardStr = shareStateStr.substring(indexD);

        player = shareStateStr.charAt(0);
        factory = new Factory(factoryStr);
        centre = new Centre(centreStr);
        bag = new Bag(bagStr);
        discard = new Discard(discardStr);
    }

    public static boolean isWellFormed(String shareStateStr){
        //AFCB1915161614D0000000000
        int indexF = shareStateStr.indexOf("F",1);
        int indexC = shareStateStr.indexOf("C",1);
        int indexB = shareStateStr.indexOf("B",1);
        int indexD = shareStateStr.indexOf("D",1);
        if (indexF == -1 || indexC == -1 || indexB == -1 || indexD == -1) return false;


        // part 1: check the form of the Factory state
        String factoryStr = shareStateStr.substring(indexF, indexC);
        if(!Factory.isWellFormed(factoryStr)) return false;

        // part 2: check the form of the Centre state
        String centreStr = shareStateStr.substring(indexC, indexB);
        if(!Centre.isWellFormed(centreStr)) return false;

        // part 3: check the form of the Bag state
        String bagStr = shareStateStr.substring(indexB, indexD);
        if(!Bag.isWellFormed(bagStr)) return false;

        // part 4: check the form of the Discard state
        String discardStr = shareStateStr.substring(indexD);
        if(!Bag.isWellFormed(discardStr)) return false;

        return true;
    }

    public String getStateStr(){
        return player + factory.getStateStr() + centre.getStateStr() + bag.getStateStr() + discard.getStateStr();
    }

    public Bag getBag() {
        return bag;
    }

    public Centre getCentre() {
        return centre;
    }

    public Discard getDiscard() {
        return discard;
    }

    public Factory getFactory() {
        return factory;
    }

    public char getPlayer() {
        return player;
    }
}
