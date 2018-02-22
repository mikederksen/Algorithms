package CustomTypes;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HANLinkedListTests {

    private static final String ITEM1 = "Something";
    private static final String ITEM2 = "Something else";
    private static final String ITEM3 = "Another something else";

    private HANLinkedList<String> sut;

    @Before
    public void setUp() {
        sut = new HANLinkedList<String>();
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
    public void removeFirstRemovesFirstNode() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.removeFirst();

        assertEquals(ITEM2, sut.get(0));
    }

    @Test
    public void insertInsertsItemAtIndex() {
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.insert(1, ITEM3);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(ITEM3, sut.get(1));
        assertEquals(ITEM2, sut.get(2));
    }

    @Test
    public void deleteDeletsItemAtIndex() {
        sut.addFirst(ITEM3);
        sut.addFirst(ITEM2);
        sut.addFirst(ITEM1);

        sut.delete(1);

        assertEquals(ITEM1, sut.get(0));
        assertEquals(ITEM3, sut.get(1));
    }
}
