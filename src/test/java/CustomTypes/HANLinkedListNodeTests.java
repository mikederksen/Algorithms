package CustomTypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HANLinkedListNodeTests {

    private static final String ITEM = "Something";

    private HANLinkedListNode<String> sut;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        sut = new HANLinkedListNode<>(ITEM);
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionWhenValueIsNull() {
        expectedException.expect(IllegalArgumentException.class);

        new HANLinkedListNode<String>(null);
    }

    @Test
    public void getValueReturnsValue() {
        assertEquals(ITEM, sut.getValue());
    }

    @Test
    public void nextCanBeSetAndRetrieved() {
        HANLinkedListNode<String> nextNode = new HANLinkedListNode<>("Something else");

        sut.setNext(nextNode);

        Optional<HANLinkedListNode<String>> next = sut.getNext();
        assertTrue(next.isPresent());
        assertEquals(nextNode, next.get());
    }
}
