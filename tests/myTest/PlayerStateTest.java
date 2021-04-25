package myTest;

import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.Player;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.Centre;
import comp1110.ass2.sharedState.Factory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerStateTest {
    @Test
    public void playerStateTest() {
        String str = "B12Ma00d01b02e04b10a11c12e13d14d23b24c43S3e14e4Faaacddd";
        PlayerState playerState = new PlayerState(str);
        assertEquals(str, playerState.getStateStr());
    }

    @Test
    public void playerTest() {
        String str = "A20";
        assertTrue(Player.isWellFormed(str));
    }


    //[mosaic]
    @Test
    public void mosaicTest() {
        String str = "Mb00a02a13e42";
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
        assertEquals(0, playerState.getBonusPoint());

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
            assertTrue(PlayerState.isWellFormed(subStr2[i]));
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
            assertTrue(PlayerState.isWellFormed(subStr4[i]));
            PlayerState playerState = new PlayerState(subStr4[i]);
            assertEquals(subStr4[i], playerState.getStateStr());
        }
    }

    @Test
    public void storageRowIsCompleteTest() {
        String storageStr = "S1e22c13a44a1";
        assertTrue(Storage.isWellFormed(storageStr));
        Storage storage = new Storage(storageStr);
        assertFalse(storage.rowIsComplete(0));
        assertTrue(storage.rowIsComplete(1));
        assertFalse(storage.rowIsComplete(2));
        assertTrue(storage.rowIsComplete(3));
        assertFalse(storage.rowIsComplete(4));
    }

    @Test
    public void storageIsValidPlacementTest() {
        String storageStr = "S0a11e12b14c1";
        assertTrue(Storage.isWellFormed(storageStr));
        Storage storage = new Storage(storageStr);
        assertTrue(storage.isValidPlacement('a',0));
        assertFalse(storage.isValidPlacement('a',1));
        assertTrue(storage.isValidPlacement('b',2));
        for (int i = 0; i < 5; i++) {
            assertTrue(storage.isValidPlacement((char)('a' + i),3));
        }
        assertFalse(storage.isValidPlacement('e',4));
    }

    @Test
    public void mosaicRowIsContainedTest() {
        String mosaicStr = "Mc02d33a14e21";
        assertTrue(Mosaic.isWellFormed(mosaicStr));
        Mosaic mosaic = new Mosaic(mosaicStr);
        // c02 d33 a14 e21
        //  0 1 2 3 4
        //0     c
        //1         a
        //2   e
        //3       d
        //4
        for (int i = 0; i < 4; i++) {
            char tileType = mosaicStr.charAt(1+3*i);
            int rowNum = mosaicStr.charAt(2+3*i) - '0';
            assertTrue(mosaic.rowIsContained(tileType,rowNum));
        }
        for (int r = 0; r < 5; r++) {
            assertFalse(mosaic.rowIsContained('b',r));
        }
    }

    @Test
    public void mosaicIsValidPlacementTest() {
        String mosaicStr = "Ma01b13e40";
        assertTrue(Mosaic.isWellFormed(mosaicStr));
        Mosaic mosaic = new Mosaic(mosaicStr);
        // a01 b13 e40
        //  0 1 2 3 4
        //0   a
        //1       b
        //2
        //3
        //4 e
        assertTrue(mosaic.isValidPlacement('a',3,4));
        assertTrue(mosaic.isValidPlacement('b',2,0));
        assertTrue(mosaic.isValidPlacement('e',1,2));
        for (int i = 0; i < 3; i++) {
            char tileType = mosaicStr.charAt(1+3*i);
            int rowNum = mosaicStr.charAt(2+3*i) - '0';
            int colNum = mosaicStr.charAt(3+3*i) -'0';
            assertFalse(mosaic.isValidPlacement(tileType,rowNum,colNum));
        }
        for (int i = 0; i < 5; i++) {
            assertFalse(mosaic.isValidPlacement('e',i,0));
            assertFalse(mosaic.isValidPlacement('a',i,1));
            assertFalse(mosaic.isValidPlacement('b',i,3));
            assertFalse(mosaic.isValidPlacement('e',4,i));
            assertFalse(mosaic.isValidPlacement('a',0,i));
            assertFalse(mosaic.isValidPlacement('b',1,i));
            assertTrue(mosaic.isValidPlacement('c',2,i));
            assertTrue(mosaic.isValidPlacement('c',3,i));
            assertTrue(mosaic.isValidPlacement('c',i,4));
            assertTrue(mosaic.isValidPlacement('d',2,i));
            assertTrue(mosaic.isValidPlacement('d',3,i));
            assertTrue(mosaic.isValidPlacement('d',i,4));
        }
    }
    @Test
    public void centreAtLeastOneTileTest() {
        String centreStr = "Caabbbceeeef";
        assertTrue(Centre.isWellFormed(centreStr));
        Centre centre = new Centre(centreStr);
        char[] contains = new char[] {'a','b','c','e','f'};
        for (char tileType : contains) {
            assertTrue(centre.atLeastOneTile(tileType));
        }
        assertFalse(centre.atLeastOneTile('d'));

        String emptyCentreStr = "C";
        assertTrue(Centre.isWellFormed(emptyCentreStr));
        Centre empty = new Centre(emptyCentreStr);
        for (int i = 0; i < 5; i++) {
            assertFalse(empty.atLeastOneTile((char)('a'+i)));
        }
    }

    @Test
    public void factoryAtLeastOneTileTest() {
        String factoryStr = "F0cdee1bdde2abbe3bcde4aaae";
        assertTrue(Factory.isWellFormed(factoryStr));
        char[][] contains = new char[][] {new char[] {'c','d','e'},new char[] {'b','d','e'}
                                         ,new char[] {'a','b','e'},new char[] {'b','c','d','e'}
                                         ,new char[] {'a','e'}};
        char[][] notContains = new char[][] {new char[] {'a','b'},new char[] {'a','c'}
                                            ,new char[] {'c','d'},new char[] {'a'}
                                            ,new char[] {'b','c','d'}};
        Factory factory = new Factory(factoryStr);
        assertTrue(factory.atLeastOneTile('c',0));
        for (int i = 0; i < contains.length; i++) {
            for (char tileType : contains[i]) {
                assertTrue(factory.atLeastOneTile(tileType,i));
            }
            for (char tileType : notContains[i]) {
                assertFalse(factory.atLeastOneTile(tileType,i));
            }
        }

        String emptyFactory = "F";
        assertTrue(Factory.isWellFormed(emptyFactory));
        Factory empty = new Factory(emptyFactory);
        for (int i = 0; i < factory.FACTORY_NUMBER; i++) {
            for (int j = 0; j < 5; j++) {
                assertFalse(empty.atLeastOneTile((char)('a'+j), i));
            }
        }
    }
}
