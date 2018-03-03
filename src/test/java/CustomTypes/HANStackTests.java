package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;
import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class HANStackTests {
    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private HANStack<String> sut;

    @Before
    public void setUp() {
        sut = new HANStack<>();
    }

    @Test
    public void constructorSetsSizeTo_0() {
        assertEquals(0, sut.getSize());
    }

    @Test
    public void pushAddsItemToTop() {
        sut.push(ITEM1);

        assertEquals(ITEM1, sut.top());
    }

    @Test
    public void pushMultipleAddsLastItemToTop() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM2, sut.top());
    }

    @Test
    public void pushIncreasesSize() {
        sut.push(ITEM1);

        assertEquals(1, sut.getSize());
    }

    @Test
    public void pushMultpleIncreasesSize() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(2, sut.getSize());
    }

    @Test
    public void popRemovesLastItem() {
        sut.push(ITEM1);
        sut.push(ITEM2);

        assertEquals(ITEM2, sut.pop());
        assertEquals(ITEM1, sut.top());
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
    public void topThrowsEmptyStackExceptionWhenEmpty() {
        expectedException.expect(EmptyStackException.class);

        sut.top();
    }

    @Test
    public void popThrowsEmptyStackExceptionWhenEmpty() {
        expectedException.expect(EmptyStackException.class);

        sut.pop();
    }
}
