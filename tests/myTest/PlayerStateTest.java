package myTest;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.playerState.PlayerState;
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
        String str = "B12Ma00d01b02e04b10a11c12e13d14d23b24c43S3e14e4Faaacddd";
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
        String str2 = "A29Me00a01c02b04d10c11e13a14b20d22a23c24a40S3e24b2Faf";
        playerState = new PlayerState(str2);
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

    @Test
    public void getAllPlayerStatesTest() {
        String twoStateStr = "A7Me01a11d20b30b41S0a11b22c13c44d1FeeB8Md03b13e23c32b41S0b11c12a33d24e4Fab";
        String[] subStr2 = new String[] {"A7Me01a11d20b30b41S0a11b22c13c44d1Fee",
                                         "B8Md03b13e23c32b41S0b11c12a33d24e4Fab"};
        assertEquals(2, PlayerState.getAllPlayerStates(twoStateStr).length);
        for (int i = 0; i < subStr2.length; i++) {
            PlayerState playerState = new PlayerState(subStr2[i]);
            assertEquals(subStr2[i],playerState.getStateStr());
        }
        String fourStateStr = "A2Me04b11S2c13a34a1FbeeeeB1Mc02S1b12e13d4FfC0MS2c13a34a1FD0MS0c11b12e1Ff";
        String[] subStr4 = new String[] {"A2Me04b11S2c13a34a1Fbeeee",
                                         "B1Mc02S1b12e13d4Ff",
                                         "C0MS2c13a34a1F",
                                         "D0MS0c11b12e1Ff"};
        assertEquals(4, PlayerState.getAllPlayerStates(fourStateStr).length);
        for (int i = 0; i < subStr4.length; i++) {
            PlayerState playerState = new PlayerState(subStr4[i]);
            assertEquals(subStr4[i], playerState.getStateStr());
        }
    }
}
