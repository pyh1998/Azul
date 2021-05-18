package myTest;

import comp1110.ass2.Azul;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.sharedState.SharedState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NextPlayerTest {
    @Test
    public void ShareStateTest() {
        SharedState sharedState = new SharedState(2);
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("BFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());

        sharedState = new SharedState(3);
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("BFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("CFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("BFCfB2020202020D0000000000",sharedState.getStateStr());

        sharedState = new SharedState(4);
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("BFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("CFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("DFCfB2020202020D0000000000",sharedState.getStateStr());
        sharedState.nextPlayer();
        assertEquals("AFCfB2020202020D0000000000",sharedState.getStateStr());
    }
}
