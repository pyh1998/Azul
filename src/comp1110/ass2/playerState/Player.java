package comp1110.ass2.playerState;

public class Player {
    public int score = 0;
    char id;

    public Player(char id) {
        this.id = id;
    }

}

enum Id {
    Player1, PLayer2, Player3, Player4;
}