package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class HANLinkedListTests {

    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    private HANLinkedList<String> sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        sut = new HANLinkedList<>();
    }

    @Test
    public void constructorSetsSizeTo_0() {
        assertEquals(0, sut.getSize());
    }

    @Test
    public void getThrowsArrayIndexOutOfBoundsExceptionWhenListEmpty() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.get(0);
    }

    @Test
    public void getThrowsArrayIndexOutOfBoundsExceptionWhenIndexDoesntExist() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.addFirst(ITEM1);

        sut.get(1);
    }

    @Test
    public void getThrowsArrayIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);

        sut.get(-1);
    }

    @Test
    public void addFirstIncreasesSizeWith_1() {
        sut.addFirst(ITEM1);

        assertEquals(1, sut.getSize());
    }

    @Test
    public void addFirstTwiceIncreasesSizeWith_2() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        assertEquals(2, sut.getSize());
    }

    @Test
    public void addFirstAddsNodeInBeginningOfList() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        assertEquals(ITEM1, sut.get(0));
    }

    @Test
    public void addFirstMovesPreviousFirstModeToSecond() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        assertEquals(ITEM2, sut.get(1));
    }

    @Test
    public void removeFirstDecreasesSizeWith1() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.removeFirst();

        assertEquals(1, sut.getSize());
    }

    @Test
    public void removeFirstDoesntDecreaseIfEmpty() {
        sut.removeFirst();

        assertEquals(0, sut.getSize());
    }

    @Test
    public void removeFirstRemovesFirstNode() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.removeFirst();

        assertEquals(ITEM2, sut.get(0));
    }

    @Test
    public void removeFirstDoesNothingWhenListEmpty() {
        sut.removeFirst();
    }

    @Test
    public void insertInsertsItemAtIndex_1() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.insert(1, ITEM3);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(ITEM3, sut.get(1));
        assertEquals(ITEM2, sut.get(2));
    }

    @Test
    public void insertInsertsItemAtIndex_0() {
        sut.insert(0, ITEM1);

        assertEquals(ITEM1, sut.get(0));
    }

    @Test
    public void insertIncreasesSizeWith_1() {
        sut.insert(0, ITEM1);

        assertEquals(1, sut.getSize());
    }

    @Test
    public void insertTwiceIncreasesSizeWith_2() {
        sut.insert(0, ITEM1);
        sut.insert(1, ITEM2);

        assertEquals(2, sut.getSize());
    }

    @Test
    public void insertThrowsArrayIndexOutOfBoundsExceptionWhenNoItemBeforeIndex() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.insert(3, ITEM3);
    }

    @Test
    public void insertInsertsItemAfterLastItem() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.insert(2,ITEM3);

        assertEquals(ITEM3, sut.get(2));
    }

    @Test
    public void deleteDeletesFirstItem() {
        sut.addFirst(ITEM1);

        sut.delete(0);

        assertEquals(0, sut.getSize());
    }

    @Test
    public void deleteDeletesItemAtIndex() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(1);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(ITEM3, sut.get(1));
    }

    @Test
    public void deleteDeletesLastItem() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(1);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(1, sut.getSize());
    }

    @Test
    public void deleteDecresesSizeWith_1() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(1);

        assertEquals(2, sut.getSize());
    }

    @Test
    public void deleteTwiceDecresesSizeWith_2() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(2);
        sut.delete(1);

        assertEquals(1, sut.getSize());
    }

    @Test
    public void deleteThrowsArrayIndexOutOfBoundsExceptionWhenIndexDoesntExist() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);
        sut.addFirst(ITEM1);

        sut.delete(1);
    }

    @Test
    public void toStringDisplaysElementsIfMultipleExist() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        String expected = String.format("[%s, %s, %s]", ITEM1, ITEM2, ITEM3);

        assertEquals(expected, sut.toString());
    }

    @Test
    public void toStringDisplaysElementIfOneExist() {
        sut.addFirst(ITEM1);

        assertEquals(String.format("[%s]", ITEM1), sut.toString());
    }

    @Test
    public void toStringDisplaysEmptyStringIfNoneExist() {
        assertEquals("[]", sut.toString());
    }
}
