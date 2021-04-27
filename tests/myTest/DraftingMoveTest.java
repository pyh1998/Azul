package myTest;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.sharedState.Centre;
import comp1110.ass2.sharedState.Factory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DraftingMoveTest {
    @Test
    public void selectTilesToStorageOrFloorTest(){
        String stateStr = "F0aabc1aabc2abbb3ccde4ddee";
        Factory factory = new Factory(stateStr);
        assertEquals(2,factory.selectTilesToStorageOrFloor(0,'a'));
        assertEquals("F0bc1aabc2abbb3ccde4ddee",factory.getStateStr());
    }
    @Test
    public void remainTilesToCentreTest(){
        String stateStr = "F0aabc1aabc2abbb3ccde4ddee";
        Factory factory = new Factory(stateStr);
        Tile[] tiles = {Tile.B,Tile.C};
        assertTrue(Arrays.equals(tiles,factory.remainTilesToCentre(0,'a')));
        assertEquals("F1aabc2abbb3ccde4ddee",factory.getStateStr());
    }
    @Test
    public void selectTilesFromCentreTest(){
        String stateStr = "Caaabcdde";
        Centre centre = new Centre(stateStr);
        assertEquals(3,centre.selectTilesFromCentre('a'));
        assertEquals("Cbcdde",centre.getStateStr());
    }

}
