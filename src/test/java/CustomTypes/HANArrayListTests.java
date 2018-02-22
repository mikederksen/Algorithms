package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class HANArrayListTests {

    private static final String ITEM = "Something";

    private HANArrayList<String> sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Before
    public void setUp() {
        sut = new HANArrayList<String>();
    }

    @Test
    public void getRetrievesAddedItem() {
        sut.add(ITEM);

        assertEquals(ITEM, sut.get(0));
    }

    @Test
    public void getRetrievesLastItemWhenMultipleAdded() {
        sut.add("Something else");
        sut.add("Another something else");
        sut.add(ITEM);

        assertEquals(ITEM, sut.get(2));
    }

    @Test
    public void getRetrievesItemAtIndexWhenMultipleAddded() {
        sut.add("Something else");
        sut.add(ITEM);
        sut.add("Another something else");

        assertEquals(ITEM, sut.get(1));
    }

    @Test
    public void getThrowsIndexOutOfBoundsExceptionWhenIndexDoesntExist() {
        expectedException.expect(IndexOutOfBoundsException.class);

        sut.add(ITEM);

        sut.get(1);
    }

    @Test
    public void getThrowsIndexOutOfBoundsExceptionWhenIndexBelow_0() {
        expectedException.expect(IndexOutOfBoundsException.class);

        sut.get(-1);
    }

    @Test
    public void addCanInsert20Items() {
        for(int i = 0; i < 20; i++) {
            sut.add(ITEM + i);
        }
    }

    @Test
    public void setInsertsItemAtIndex() {
        sut.add("Something else");
        sut.set(0, ITEM);

        assertEquals(ITEM, sut.get(0));
    }

    @Test
    public void setThrowsArrayIndexOutOfBoundsExceptionWhenIndexNotInList() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.add("Something else");
        sut.set(1, ITEM);
    }

    @Test
    public void setThrowsArrayIndexOutOfBoundsExceptionWhenIndexBelow_0() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.get(-1);
    }
}
