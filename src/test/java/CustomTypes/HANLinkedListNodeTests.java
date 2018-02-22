package CustomTypes;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HANLinkedListNodeTests {

    private static final String ITEM = "Something";

    private HANLinkedListNode<String> sut;

    @Before
    public void setUp() {
        sut = new HANLinkedListNode<String>(ITEM);
    }

    @Test
    public void getValueReturnsValue() {
        assertEquals(ITEM, sut.getValue());
    }

    @Test
    public void nextCanBeSetAndRetrieved() {
        HANLinkedListNode<String> nextNode = new HANLinkedListNode<String>("Something else");

        sut.setNext(nextNode);

        assertEquals(nextNode, sut.getNext());
    }
}
