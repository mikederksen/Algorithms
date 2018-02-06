package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FaculteitTests {

    @Test
    public void recursive_0_Returns_1() {
        assertRecursive(1, 0);
    }

    @Test
    public void loop_0_Returns_1() {
        assertLoop(1, 0);
    }

    @Test
    public void recursive_1_Returns_1() {
        assertRecursive(1, 1);
    }

    @Test
    public void loop_1_Returns_1() {
        assertLoop(1, 1);
    }

    @Test
    public void recursive_Minus5_Returns_1() {
        assertRecursive(1, -5);
    }

    @Test
    public void loop_Minus5_Returns_1() {
        assertLoop(1, -5);
    }

    @Test
    public void recursive_2_Returns_2() {
        assertRecursive(2, 2);
    }

    @Test
    public void loop_2_Returns_2() {
        assertLoop(2, 2);
    }

    @Test
    public void recursive_5_Returns_120() {
        assertRecursive(120, 5);
    }

    @Test
    public void loop_5_Returns_120() {
        assertLoop(120, 5);
    }

    private static void assertLoop(int expected, int input) {
        int result = Faculteit.CalcRec(input);

        assertEquals(expected, result);
    }

    private static void assertRecursive(int expected, int input) {
        int result = Faculteit.CalcLoop(input);

        assertEquals(expected, result);
    }
}
