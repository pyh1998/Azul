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
     * @param playStr the state string of the Player
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormedPlayer(String playStr){
        if((playStr.equals("A") || playStr.equals("B") || playStr.equals("C") || playStr.equals("D"))){
            return true;
        }
        return false;
    }

    /**
     * Check if the state string of score is well formed
     *
     * @param scoreStr the state string of the score
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
    public static boolean isWellFormedScore(String scoreStr){
        for (int i = 1; i < scoreStr.length(); i++) {
            if (!Character.isDigit(scoreStr.charAt(i))) {
                return false;
            }
        }
        return true;
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