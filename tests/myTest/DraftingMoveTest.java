package myTest;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.Centre;
import comp1110.ass2.sharedState.Factory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DraftingMoveTest {
    @Test
    public void selectTilesToStorageOrFloorTest(){
        String stateStr = "F0aabc1aabc2abbb3ccde4ddee";
        Factory factory = new Factory(stateStr,2);
        assertEquals(2,factory.selectTilesFromFactory(0,'a'));
        assertEquals("F0bc1aabc2abbb3ccde4ddee",factory.getStateStr());
    }
    @Test
    public void remainTilesToCentreTest(){
        String stateStr = "F0aabc1aabc2abbb3ccde4ddee";
        Factory factory = new Factory(stateStr,2);
        assertEquals(2,factory.selectTilesFromFactory(0,'a'));
        Tile[] tiles = {Tile.B,Tile.C};
        Tile[] tiles2 = factory.remainTilesToCentre(0,'a');
        assertTrue(Arrays.equals(tiles,tiles2));
        assertEquals("F1aabc2abbb3ccde4ddee",factory.getStateStr());
        String stateStr2 = "Cabc";
        Centre centre = new Centre(stateStr2);
        centre.addTiles(tiles2);
        assertEquals("Cabbcc",centre.getStateStr());
    }
    @Test
    public void selectTilesFromCentreTest(){
        String stateStr = "Caaabcdde";
        Centre centre = new Centre(stateStr);
        assertEquals(3,centre.selectTilesFromCentre('a'));
        assertEquals("Cbcdde",centre.getStateStr());
    }
    @Test
    public void addTilesToFloorTest(){
        String stateStr = "Faabc";
        Floor floor = new Floor(stateStr);
        Tile[] tiles = floor.getRemainTiles(2,'a');
        assertTrue(tiles.length == 0);
        floor.addTilesToFloor(2,'a');
        assertEquals("Faaaabc",floor.getStateStr());

        tiles = floor.getRemainTiles(2,'a');
        Tile[] result = new Tile[]{Tile.A};
        assertTrue(Arrays.equals(tiles, result));
        floor.addTilesToFloor(2,'a');
        assertEquals("Faaaaabc",floor.getStateStr());

        tiles = floor.getRemainTiles(1,'f');
        result = new Tile[]{Tile.C};
        assertTrue(Arrays.equals(tiles, result));
        floor.addTilesToFloor(1,'f');
        assertEquals("Faaaaabf",floor.getStateStr());
    }
    @Test
    public void addTilesToStorageTest(){
        String stateStr = "S2a13e44a1";
        Storage storage = new Storage(stateStr);
        assertEquals(0,storage.getRemainTiles(2,1,'a'));
        storage.addTilesToStorage(2,1,'a');
        assertEquals("S2a23e44a1",storage.getStateStr());
        assertEquals(2,storage.getRemainTiles(2,3,'a'));
        storage.addTilesToStorage(2,3,'a');
        assertEquals("S2a33e44a1",storage.getStateStr());

    }

}
