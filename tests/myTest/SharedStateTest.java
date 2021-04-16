package myTest;

import comp1110.ass2.Azul;
import comp1110.ass2.shareState.Bag;
import comp1110.ass2.shareState.Centre;
import comp1110.ass2.shareState.Discard;
import comp1110.ass2.shareState.Factory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SharedStateTest {
    @Test
    public void FactoryTest() {
        String stateStr = "F1aabc2abbb4ddee";
        assertTrue(Factory.isWellFormed(stateStr));
        Factory factory = new Factory(stateStr);
        assertEquals(stateStr,factory.getStateStr());
    }

    @Test
    public void CentreTest() {
        String stateStr = "Caaabcdde";
        assertTrue(Centre.isWellFormed(stateStr));
        Centre centre = new Centre(stateStr);
        assertEquals(stateStr,centre.getStateStr());
    }

    @Test
    public void BagTest() {
        String stateStr = "B0005201020";
        assertTrue(Bag.isWellFormed(stateStr));
        Bag bag = new Bag(stateStr);
        assertEquals(stateStr,bag.getStateStr());
    }

    @Test
    public void DiscardTest() {
        String stateStr = "D0005201020";
        assertTrue(Discard.isWellFormed(stateStr));
        Discard discard = new Discard(stateStr);
        assertEquals(stateStr,discard.getStateStr());
    }

    @Test
    public void ShareStateTest() {
        String stateStr = "AFBcdde1bbbe2abde3cdee4bcceCfB1915161614DBBBBBBBBBB";
        assertTrue(Azul.isSharedStateWellFormed(stateStr));
    }
}