package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomTests {

    @Test
    public void recursive_0_Returns_0() {
        assertEquals(0, Som.calcRec(0));
    }

    @Test
    public void loop_0_Returns_0() {
        assertEquals(0, Som.calcLoop(0));
    }

    @Test
    public void recursive_1_Returns_1() {
        assertEquals(1, Som.calcRec(1));
    }

    @Test
    public void loop_1_Returns_1() {
        assertEquals(1, Som.calcLoop(1));
    }

    @Test
    public void recursive_3_Returns_6() {
        assertEquals(6, Som.calcRec(3));
    }

    @Test
    public void loop_3_Returns_6() {
        assertEquals(6, Som.calcLoop(3));
    }

    @Test
    public void recursive_5_Returns_15() {
        assertEquals(15, Som.calcRec(5));
    }

    @Test
    public void loop_5_Returns_15() {
        assertEquals(15, Som.calcLoop(5));
    }
}
