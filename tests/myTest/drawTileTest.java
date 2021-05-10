package myTest;

import comp1110.ass2.Azul;
import comp1110.ass2.sharedState.Bag;
import comp1110.ass2.sharedState.Discard;
import comp1110.ass2.sharedState.Factory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class drawTileTest {

    @Test
    public void drawTileFromToFactory(){
        String stateStr = "B0000000000";
        Bag bag = new Bag(stateStr);
        assertTrue(bag.isEmpty());
        assertEquals(null,bag.addToFactory());
        stateStr = "B1600000000";
        bag = new Bag(stateStr);
        assertEquals('a',bag.addToFactory().getTILE_TYPE());
        assertEquals("B1500000000",bag.getStateStr());
        stateStr = "B0005000000";
        bag = new Bag(stateStr);
        assertEquals('b',bag.addToFactory().getTILE_TYPE());
        assertEquals("B0004000000",bag.getStateStr());
        stateStr = "B0000200000";
        bag = new Bag(stateStr);
        assertEquals('c',bag.addToFactory().getTILE_TYPE());
        assertEquals("B0000190000",bag.getStateStr());
    }

    @Test
    public void moveTileToBag(){
        String stateStr = "D0506070809";
        Discard discard = new Discard(stateStr);
        int[] expect = {5,6,7,8,9};
        int[] empty = {0,0,0,0,0};
        boolean b1 = Arrays.equals(expect,discard.moveTileToBag());
        boolean b2 = Arrays.equals(empty,discard.getTile_num());
        assertTrue(b1);
        assertTrue(b2);
    }

    @Test
    public void FactoryEmptyTest(){
        String stateStr = "F";
        Factory factory = new Factory(stateStr,2);
        assertTrue(factory.isEmpty());
    }

    @Test
    public void refillFactoryTest(){
//        String[] state = {"BF0ccce1aace2aade3abde4ccdeCfB0505040402D0609040610", "A14Mb01d03c13d14d20a22b23e32b34e43S3a14d2FB6Ma00b01b12d14d20e21c30a44S4c4F"};
//        assertEquals("a", Azul.refillFactories(state));

//        String[] state2 = {"BFCB0000000000D1110100612", "A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S1a22e23c34d5FadfB10Ma00b01e10b12d14d20e21c30c41a44S1a22c33d34b5F"};
//        assertEquals("a", Azul.refillFactories(state2));

        String[] state3 = {"AFCfB0012000006D0903090705","A0Ma00b01c02d03e10a11c13d14e21a22b23c24c30d31e32b34b40d42e43a44S3a34c4FB0Md00a01e04e11e20b21d22c23e32d33e43S1d22c23a34d4F"};
        assertEquals(state3,Azul.refillFactories(state3));

    }


}
