package comp1110.ass2.playerState;

public class Player {
    /**
     * Field score: The score of the Player
     * Field onTurn: Whether the player is on turn
     * Field id: The id of the player
     */
    private int score;
    public boolean onTurn;
    private final char id;

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the Player
     * @param id the id of the player
     */
    public Player(char id) {
        this.id = id;
        this.score = 0;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Constructor of the Player according to the state string, like "A20"
     *
     * @param stateStr the state string of the player with score
     */
    public Player(String stateStr){
        this.id = stateStr.charAt(0);
        int n = stateStr.length();
        this.score = Integer.parseInt(stateStr.substring(1,n));
    }

    /**
     * @author QinLing Zhong
     * Check if the state string of player is well formed
     *
     * @param playerStr the state string of the Player
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormed(String playerStr){
        String p = playerStr.substring(0,1);
        String s = playerStr.substring(1);
        if(!(p.equals("A") || p.equals("B") || p.equals("C") || p.equals("D"))){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author Yuhui Pang
     *
     * Update the score of the player (add or minus)
     * @param score the score need to be add (negative means minus)
     */
   public void updateScore(int score){
        this.score += score;
        if(this.score < 0) this.score = 0;
   }

    /**
     * @author Yuhui Pang
     *
     * Get the state string of the Player with score
     *
     * @return the state string of the Player with score
     */
    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append(this.id);
        state.append(this.score);
        return state.toString();
    }

    /**
     * @author Yuhui Pang
     *
     * Set the score
     * @param score the score to be set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get the score of the Player
     * @return the score of the Player
     */
    public int getScore() {
        return score;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang, Qinling Zhong
     *
     * Get the id of the Player
     * @return the id of the Player
     */
    public char getId() {
        return id;
    }

    /**
     * @author Jiawen Wang
     *
     * Determine whether the player is the first player
     * @param player the player
     * @return whether the player is the first player
     */
    public boolean isFirstPlayer(Player player) {
        // TODO FIX the function of isFirstPlayer
        return false;
    }
}