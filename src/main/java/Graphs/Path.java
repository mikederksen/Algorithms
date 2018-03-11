package Graphs;

public class Path implements Comparable<Path> {

    public Vertex dest; //w
    public double cost; // d(w)

    public Path(Vertex d, double c) {
        dest = d;
        cost = c;
    }

    @Override
    public int compareTo(Path rhs) {
        double otherCost = rhs.cost;

        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }
}

