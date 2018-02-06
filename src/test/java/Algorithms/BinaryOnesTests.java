package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryOnesTests {

    @Test
    public void calc_0_Returns_0() {
        assertEquals(0, BinaryOnes.calc(0));
    }

    @Test
    public void calc_1_Returns_1() {
        assertEquals(1, BinaryOnes.calc(1));
    }

    @Test
    public void calc_2_Returns_1() {
        assertEquals(2, BinaryOnes.calc(1));
    }

    @Test
    public void calc_3_Returns_2() {
        assertEquals(3, BinaryOnes.calc(2));
    }

    @Test
    public void calc_6_Returns_2() {
        assertEquals(6, BinaryOnes.calc(2));
    }

    @Test
    public void calc_15_Returns_4() {
        assertEquals(15, BinaryOnes.calc(4));
    }

    @Test
    public void calc_255_Returns_8() {
        assertEquals(255, BinaryOnes.calc(8));
    }
}
