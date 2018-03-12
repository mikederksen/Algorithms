package Graphs;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GraphTests {
    Graph _sut;

    @Before
    public void initialize() {
        _sut = new Graph();

        _sut.addEdge("A", "B", 5);
        _sut.addEdge("A", "C", 3);
        _sut.addEdge("B", "C", 2);
        _sut.addEdge("B", "G", 1);
        _sut.addEdge("B", "E", 3);
        _sut.addEdge("C", "E", 7);
        _sut.addEdge("C", "D", 7);
        _sut.addEdge("D", "A", 2);
        _sut.addEdge("D", "F", 6);
        _sut.addEdge("E", "F", 1);
        _sut.addEdge("E", "D", 2);
        _sut.addEdge("G", "E", 1);
    }

    @Test
    public void distanceOfAtoBShouldBe5UsingDijkstra() {
        _sut.dijkstra("A");

        assertEquals(5.0, _sut.getDistance("B"), 0);
    }

    @Test
    public void distanceOfAtoBShouldBe1UsingUnweighted() {
        _sut.unweighted("A");

        assertEquals(1.0, _sut.getDistance("B"), 0);
    }

    @Test
    public void distanceOfBtoDShouldBe4UsingDijkstra() {
        _sut.dijkstra("B");

        assertEquals(4.0, _sut.getDistance("D"), 0);
    }

    @Test
    public void distanceOfBtoDShouldBe2UsingUnweighted() {
        _sut.unweighted("B");

        assertEquals(2.0, _sut.getDistance("D"), 0);
    }

    @Test
    public void graphShouldBeConnected() {
        _sut.dijkstra("B");

        assertEquals(true, _sut.isConnected());
    }

    @Test
    public void graphShouldNotBeConnected() {
        _sut.addEdge("H", "I", 1);
        _sut.dijkstra("B");

        assertEquals(false, _sut.isConnected());
    }
}
