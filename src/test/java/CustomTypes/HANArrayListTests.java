package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class HANArrayListTests {

    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    private HANArrayList<String> sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        sut = new HANArrayList<String>();
    }

    @Test
    public void getRetrievesAddedItem() {
        sut.add(ITEM1);

        assertEquals(ITEM1, sut.get(0));
    }

    @Test
    public void getRetrievesLastItemWhenMultipleAdded() {
        sut.add(ITEM2);
        sut.add(ITEM3);
        sut.add(ITEM1);

        assertEquals(ITEM1, sut.get(2));
    }

    @Test
    public void getRetrievesItemAtIndexWhenMultipleAddded() {
        sut.add(ITEM2);
        sut.add(ITEM1);
        sut.add(ITEM3);

        assertEquals(ITEM1, sut.get(1));
    }

    @Test
    public void getThrowsIndexOutOfBoundsExceptionWhenIndexDoesntExist() {
        expectedException.expect(IndexOutOfBoundsException.class);

        sut.add(ITEM1);

        sut.get(1);
    }

    @Test
    public void getThrowsIndexOutOfBoundsExceptionWhenIndexBelow_0() {
        expectedException.expect(IndexOutOfBoundsException.class);

        sut.get(-1);
    }

    @Test
    public void addCanInsert20Items() {
        final int amount = 20;

        for (int i = 0; i < amount; i++) {
            sut.add(ITEM1 + i);
        }

        for(int i = 0; i < amount; i++) {
            assertEquals(ITEM1 + i, sut.get(i));
        }
    }

    @Test
    public void setInsertsItemAtIndex() {
        sut.add(ITEM2);
        sut.set(0, ITEM1);

        assertEquals(ITEM1, sut.get(0));
    }

    @Test
    public void setThrowsArrayIndexOutOfBoundsExceptionWhenIndexNotInList() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.add(ITEM2);
        sut.set(1, ITEM1);
    }

    @Test
    public void setThrowsArrayIndexOutOfBoundsExceptionWhenIndexBelow_0() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.get(-1);
    }

    @Test
    public void toStringDisplaysShowsAllItemsWhenMultiple() {
        sut.add(ITEM1);
        sut.add(ITEM2);
        sut.add(ITEM3);

        String expected = String.format("%s, %s, %s", ITEM1, ITEM2, ITEM3);

        assertEquals(expected, sut.toString());
    }

    @Test
    public void toStringDisplaysEmptyStringWhenListEmpty() {
        assertEquals("", sut.toString());
    }
}
