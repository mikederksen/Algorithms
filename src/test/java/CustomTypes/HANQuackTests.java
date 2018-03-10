package CustomTypes;

import Exceptions.EmptyQuackException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("Duplicates")
public class HANQuackTests {

    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private HANQuack<String> sut;

    @Before
    public void setUp() {
        sut = new HANQuack<>();
    }

    @Test
    public void constructorSetsSizeTo_0() {
        assertEquals(0, sut.getSize());
    }

    @Test
    public void pushAddsItemToPeekAndPoll() {
        sut.push(ITEM1);

        assertEquals(ITEM1, sut.peek());
        assertEquals(ITEM1, sut.poll());
    }

    @Test
    public void pushMultipleAddsLastItemToPeek() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM2, sut.peek());
    }

    @Test
    public void pushMultipleAddsFirstItemToPoll() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM1, sut.poll());
    }

    @Test
    public void pushIncreasesSize() {
        sut.push(ITEM1);

        assertEquals(1, sut.getSize());
    }

    @Test
    public void pushMultipleIncreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(2, sut.getSize());
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

        assertEquals(1, sut.getSize());
    }

    @Test
    public void popMultipleDecreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);
        sut.push(ITEM3);

        sut.pop();
        sut.pop();

        assertEquals(1, sut.getSize());
    }

    @Test
    public void dequeueRemovesFirstItem() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM1, sut.dequeue());
        assertEquals(ITEM2, sut.poll());
    }

    @Test
    public void dequeueDecreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        sut.dequeue();

        assertEquals(1, sut.getSize());
    }

    @Test
    public void dequeueMultipleDecreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);
        sut.push(ITEM3);

        sut.dequeue();
        sut.dequeue();

        assertEquals(1, sut.getSize());
    }

    @Test
    public void peekThrowsEmptyQuackExceptionWhenEmpty() {
        expectedException.expect(EmptyQuackException.class);

        sut.peek();
    }

    @Test
    public void popThrowsEmptyQuackExceptionWhenEmpty() {
        expectedException.expect(EmptyQuackException.class);

        sut.pop();
    }

    @Test
    public void dequeueThrowsEmptyQuackExceptionWhenEmpty() {
        expectedException.expect(EmptyQuackException.class);

        sut.dequeue();
    }

    @Test
    public void pollThrowsEmptyQuackExceptionWhenEmpty() {
        expectedException.expect(EmptyQuackException.class);

        sut.poll();
    }

    @Test
    public void clearClearsQuack() {
        expectedException.expect(EmptyQuackException.class);

        sut.push(ITEM1);

        sut.clear();
        sut.peek();
    }

    @Test
    public void toStringDisplaysElementsIfMultipleExist() {
        sut.push(ITEM3);
        sut.push(ITEM2);
        sut.push(ITEM1);

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
