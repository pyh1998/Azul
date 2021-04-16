package comp1110.ass2.playerState;

public class Player {

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
    //A20
    public Player(String stateStr){
        this.id = stateStr.charAt(0);
        int n = stateStr.length();
        this.score = Integer.parseInt(stateStr.substring(1,n));
    }

    public static boolean isWellFormedPlayer(String playStr){
        if((playStr.equals("A") || playStr.equals("B") || playStr.equals("C") || playStr.equals("D"))){
            return true;
        }
        return false;
    }

    public static boolean isWellFormedScore(String scoreStr){
        for (int i = 1; i < scoreStr.length(); i++) {
            if (!Character.isDigit(scoreStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getStateStr(){
        StringBuilder state = new StringBuilder();
        state.append(this.id);
        state.append(this.score);
        return state.toString();
    }

    public int getScore() {
        return score;
    }

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