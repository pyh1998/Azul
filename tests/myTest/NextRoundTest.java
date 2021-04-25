package myTest;

import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Player;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.sharedState.Centre;
import comp1110.ass2.sharedState.Discard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NextRoundTest {
    @Test
    public void nextPlayerTest() {
        String str = "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F";
        //Check if the string of playerState is valid
        assertTrue(PlayerState.isWellFormed(str));
        //initialization
        PlayerState[] players = PlayerState.getAllPlayerStates(str);
        //Check if the next player is A, because the first-player-token is in A's Floor
        assertEquals('A', PlayerState.getNextPlayer(players));
    }

    @Test
    public void getFirstPlayerTileFromFloorTest() {
        String str = "C";
        //Check if the string of Centre is valid
        assertTrue(Centre.isWellFormed(str));
        //initialization
        Centre centre = new Centre(str);
        //Check if the centre is empty
        assertTrue(centre.isEmpty());
        centre.getFirstPlayerTileFromFloor();
        //Check if the centre get the first-player-token
        assertEquals("Cf", centre.getStateStr());
    }

    @Test
    public void FloorToDiscardTest() {
        String strF = "Faabbc";
        String strD = "D0000000000";
        //Check if the string of floor and discard is valid
        assertTrue(Floor.isWellFormed(strF));
        assertTrue(Discard.isWellFormed(strD));
        //initialization
        Floor floor = new Floor(strF);
        Discard discard = new Discard(strD);
        //move the tiles
        discard.getTileFromFloor(floor.moveTilesToDiscard());
        //Check if move successfully
        assertEquals("F", floor.getStateStr());
        assertEquals("D0202010000", discard.getStateStr());
    }

    @Test
    public void getLostPointTest() {
        String str = "Faabcd";
        //Check if the string of floor is valid
        assertTrue(Floor.isWellFormed(str));
        //initialization
        Floor floor = new Floor(str);
        //Check if the lost point is -8, because there are 5 tiles in floor
        assertEquals(-8,floor.getLostPoint());
    }

    @Test
    public void updateScoreTest() {
        String str = "A20";
        int score = -2;
        //Check if the string of player is valid
        assertTrue(Player.isWellFormed(str));
        //initialization
        Player player = new Player(str);
        assertEquals(20,player.getScore());
        //update the score
        player.updateScore(score);
        //Check if the score updated
        assertEquals(18,player.getScore());
    }



}
