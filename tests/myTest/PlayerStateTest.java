package myTest;

import comp1110.ass2.play.PlayerState;
import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.Player;
import comp1110.ass2.playerState.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerStateTest {
    @Test
    public void playerStateTest() {
        String str = "A20Ma02a13b00e42S2a13e44a1Faabbe";
        PlayerState playerState = new PlayerState(str);
        assertEquals(str, playerState.getStateStr());
    }

    @Test
    public void playerTest() {
        String str = "A";
        assertTrue(Player.isWellFormedPlayer(str));
    }

    @Test
    public void playerScoreTest() {
        String str = "20";
        assertTrue(Player.isWellFormedScore(str));
    }

    //[mosaic]
    @Test
    public void mosaicTest() {
        String str = "Ma02a13b00e42";
        assertTrue(Mosaic.isWellFormed(str));
        Mosaic mosaic = new Mosaic(str);
        assertEquals(str, mosaic.getStateStr());
    }

    //[mosaic]
    @Test
    public void bonusScoreTest() {
        String str = "A20Ma00b01c02e10a11b12c13d14d20e21a22c24c30d31b40c41a44S2a13e44a1Faabbe";
        PlayerState playerState = new PlayerState(str);
        assertEquals(26, playerState.getBonusPoint());
    }

    //[storage]
    @Test
    public void storageTest() {
        String str = "S2a13e44a1";
        assertTrue(Storage.isWellFormed(str));
        Storage storage = new Storage(str);
        assertEquals(str, storage.getStateStr());
    }

    //[floor]
    @Test
    public void floorTest() {
        String str = "Faabbe";
        assertTrue(Floor.isWellFormed(str));
        Floor floor = new Floor(str);
        assertEquals(str, floor.getStateStr());
    }
}
