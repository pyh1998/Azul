package comp1110.ass2.sharedState;

public class SharedState {
    /**
     * Field bag: The Bag in the SharedState
     * Field centre: The Centre in the SharedState
     * Field discard: The Discard in the SharedState
     * Field factory: The Factory in the SharedState
     * Field player: The current Player
     */
    private Bag bag;
    private Centre centre;
    private Discard discard;
    private Factory factory;
    private char player;
    public static int playerNum = 2;
    public static int factoryNum = 5;

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of SharedState according to the sharedState string,like "AFCB1915161614D0000000000“
     *
     * The first character indicates the current player
     * The substring stating with F indicates the state of Factory pile
     * The substring stating with C indicates the tiles in Centre pile
     * The substring stating with B indicates the tiles in Bag pile
     * The substring stating with D indicates the tiles in Discard pile
     *
     * Initialize fields player, factory, centre, bag and discard
     * using the corresponding substrings {Player}{Factory}{Centre}{Bag}{Discard}
     *
     * @param shareStateStr The string representing the Factory state, the tiles in the Centre, Bag and Discard piles
     */
    public SharedState(String shareStateStr, int playerNum){
        SharedState.playerNum = playerNum;
        SharedState.factoryNum = 2 * playerNum + 1;
        int indexF = shareStateStr.indexOf("F",1);
        int indexC = shareStateStr.indexOf("C",1);
        int indexB = shareStateStr.indexOf("B",1);
        int indexD = shareStateStr.indexOf("D",1);
        String factoryStr = shareStateStr.substring(indexF, indexC);
        String centreStr = shareStateStr.substring(indexC, indexB);
        String bagStr = shareStateStr.substring(indexB, indexD);
        String discardStr = shareStateStr.substring(indexD);

        player = shareStateStr.charAt(0);
        factory = new Factory(factoryStr,playerNum);
        centre = new Centre(centreStr);
        bag = new Bag(bagStr);
        discard = new Discard(discardStr);
    }

    /**
     * @author Yuhui Pang
     *
     * Constructor of SharedState
     * Initialize fields player, factory, centre, bag and discard
     *
     */
    public SharedState(int playerNum){
        SharedState.playerNum = playerNum;
        SharedState.factoryNum = 2 * playerNum + 1;
        player = 'A';
        factory = new Factory(playerNum);
        centre = new Centre();
        bag = new Bag();
        discard = new Discard();
    }

    /**
     * @author QinLing Zhong
     *
     * Check if the SharedState string is well-formed
     *
     * @param shareStateStr The string representing the Factory state, the tiles in the Centre, Bag and Discard piles
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
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

    /**
     * @author Yuhui Pang
     *
     * Get total number of each type of tile in shared area
     * @return the total number of each type of tile in shared area
     */
    public int[] getTotalNumOfTiles(){
        int[] totalNum = new int[6];
        for(int i=0;i<6;i++){
            totalNum[i] = bag.getTotalNumOfTiles()[i] + centre.getTotalNumOfTiles()[i] + discard.getTotalNumOfTiles()[i] + factory.getTotalNumOfTiles()[i];
        }
        return totalNum;
    }

    /**
     * @author Yuhui Pang
     *
     * Set the player in this round
     * @param player the player char need add
     */
    public void setPlayer(char player){
        this.player = player;
    }

    /**
     * @author Yuhui Pang
     *
     * change the current player to next
     */
    public void nextPlayer(){
        player = (char) (((player - 'A') + 1) % playerNum + 'A');
    }

    /**
     * @author Yuhui Pang
     *
     * Get the string representing {Player}{Factory}{Centre}{Bag}{Discard}
     *
     * @return the string representing {Player}{Factory}{Centre}{Bag}{Discard}
     */
    public String getStateStr(){
        return player + factory.getStateStr() + centre.getStateStr() + bag.getStateStr() + discard.getStateStr();
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get field the bag of SharedState
     *
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get field the centre of SharedState
     *
     */
    public Centre getCentre() {
        return centre;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get field the discard of SharedState
     *
     */
    public Discard getDiscard() {
        return discard;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get field the factory of SharedState
     *
     */
    public Factory getFactory() {
        return factory;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get field the player of SharedState
     *
     */
    public char getPlayer() {
        return player;
    }
}
