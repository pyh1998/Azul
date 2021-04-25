package comp1110.ass2.playerState;

public class Player {
    /**
     * Field score: The score of the Player
     * Field onTurn: Whether the player is on turn
     * Field id: The id of the player
     */
    private int score = 0;
    public boolean onTurn;
    private final char id;

    /**
     * Constructor of the Player
     * @param id the id of the player
     */
    public Player(char id, boolean onTurn) {
        this.id = id;
        this.onTurn = onTurn;
    }

    /**
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
     * Update the score of the player (add or minus)
     * @param score the score need to be add (negative means minus)
     */
   public void updateScore(int score){
        this.score += score;
        if(this.score < 0) this.score = 0;
   }

    /**
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
     * Set the score
     * @param score the score to be set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get the score of the Player
     * @return the score of the Player
     */
    public int getScore() {
        return score;
    }

    /**
     * Get the id of the Player
     * @return the id of the Player
     */
    public char getId() {
        return id;
    }

    /**
     * Determine whether the player is the first player
     * @param player the player
     * @return whether the player is the first player
     */
    public boolean isFirstPlayer(Player player) {
        // TODO FIX the function of isFirstPlayer
        return false;
    }
}