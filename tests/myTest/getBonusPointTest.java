package myTest;

import comp1110.ass2.Azul;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getBonusPointTest {
    @Test
    public void bonusScoreTest() {
        String[] str = {"BFCB0606060308D0407080801","A29Me00a01c02b04d10c11e13a14b20d22a23c24a40S3e24b2FafB12Ma00d01b02e04b10a11c12e13d14d23b24c43S3e14e4Faaacdddd"};
        assertEquals(26, Azul.getBonusPoints(str,'B'));

    }
}
