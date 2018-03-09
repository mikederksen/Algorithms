package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("Duplicates")
public class HANArrayStackTests {
    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private HANArrayStack<String> sut;

    @Before
    public void setUp() {
        sut = new HANArrayStack<>();
    }

    @Test
    public void constructorSetsSizeTo_0() {
        assertEquals(0, sut.size());
    }

    @Test
    public void pushAddsItemToPeek() {
        sut.push(ITEM1);

        assertEquals(ITEM1, sut.peek());
    }

    @Test
    public void pushMultipleAddsLastItemToPeek() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM2, sut.peek());
    }

    @Test
    public void pushIncreasesSize() {
        sut.push(ITEM1);

        assertEquals(1, sut.size());
    }

    @Test
    public void pushMultpleIncreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(2, sut.size());
    }

    @Test
    public void popRemovesLastItem() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM2, sut.pop());
        assertEquals(ITEM1, sut.peek());
    }

    @Test
    public void popDecreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        sut.pop();

        assertEquals(1, sut.size());
    }

    @Test
    public void popMultipleDecreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);
        sut.push(ITEM3);

        sut.pop();
        sut.pop();

        assertEquals(1, sut.size());
    }

    @Test
    public void peekThrowsEmptyStackExceptionWhenEmpty() {
        expectedException.expect(EmptyStackException.class);

        sut.peek();
    }

    @Test
    public void popThrowsEmptyStackExceptionWhenEmpty() {
        expectedException.expect(EmptyStackException.class);

        sut.pop();
    }

    @Test
    public void clearClearsStack() {
        expectedException.expect(EmptyStackException.class);

        sut.push(ITEM1);

        sut.clear();
        sut.peek();
    }

    @Test
    public void toStringDisplaysElementsIfMultipleExist() {
        sut.push(ITEM1);
        sut.push(ITEM2);
        sut.push(ITEM3);

        String expected = String.format("[%s, %s, %s]", ITEM1, ITEM2, ITEM3);

        assertEquals(expected, sut.toString());
    }

    @Test
    public void toStringDisplaysElementIfOneExist() {
        sut.push(ITEM1);

        assertEquals(String.format("[%s]", ITEM1), sut.toString());
    }

    @Test
    public void toStringDisplaysEmptyStringIfNoneExist() {
        assertEquals("[]", sut.toString());
    }
}
