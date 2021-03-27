package comp1110.ass2.playerState;

public class Player {
    public enum Id {
        Player1, PLayer2, Player3, Player4;
    }

    public int score = 0;
    public boolean onTurn;
    Id id;

    /**
     * Constructor of the Player
     * @param id the id of the player
     */
    public Player(Id id, boolean onTurn) {
        this.id = id;
        this.onTurn = onTurn;
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