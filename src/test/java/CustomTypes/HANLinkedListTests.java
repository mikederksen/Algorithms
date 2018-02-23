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
    public void insertIncreasesSize() {
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
    public void deleteDeletesItemAtIndex() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(1);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(ITEM3, sut.get(1));
    }

    @Test
    public void deleteThrowsArrayIndexOutOfBoundsExceptionWhenIndexDoesntExist() {
        expectedException.expect(ArrayIndexOutOfBoundsException.class);
        sut.addFirst(ITEM1);

        sut.delete(1);
    }
}
