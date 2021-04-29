package myTest;

import comp1110.ass2.playerState.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TillingMoveTest {
    @Test
    public void storageTest() {
        String str = "S2a33e44a1";
        Storage storage = new Storage(str);
        assertEquals('a', storage.getTileTypeByRow(2));
    }
}
