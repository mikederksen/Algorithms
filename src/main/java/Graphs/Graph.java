package Graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;

    public void addEdge(String sourceName, String destName, double cost) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adj.add(new Edge(w, cost));
    }

    public void unweighted(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);

        if (start == null) {
            throw new NoSuchElementException("Start vertex not found");
        }

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;

        while (!q.isEmpty()) {
            Vertex v = q.remove();

            for (Edge e : v.adj) {
                Vertex w = e.dest;

                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }
    }

    public void dijkstra(String startName) {
        PriorityQueue<Path> pq = new PriorityQueue<Path>();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found");
        }

        clearAll();
        pq.add(new Path(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!pq.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if (v.scratch != 0) // already processed v
            {
                continue;
            }

            v.scratch = 1;
            nodesSeen++;

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if (cvw < 0) {
                    throw new GraphException("Graph has negative edges");
                }
                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }
    }

    public void negative(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found");
        }

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;
        start.scratch++;

        while (!q.isEmpty()) {
            Vertex v = q.remove();
            if (v.scratch++ > 2 * vertexMap.size()) {
                throw new GraphException("Negative cycle detected");
            }

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    // Enqueue only if not already on queue
                    if (w.scratch++ % 2 == 0) {
                        q.add(w);
                    } else {
                        w.scratch--; // undo the qneueue increment
                    }
                }
            }
        }
    }

    public void acyclic(String startName) {
        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found");
        }

        clearAll();
        Queue<Vertex> q = new LinkedList<Vertex>();
        start.dist = 0;

        // Compute the indegrees
        Collection<Vertex> vertexSet = vertexMap.values();
        for (Vertex v : vertexSet) {
            for (Edge e : v.adj) {
                e.dest.scratch++;
            }
        }

        // Enqueue vertices of indegree zero
        for (Vertex v : vertexSet) {
            if (v.scratch == 0) {
                q.add(v);
            }
        }

        int iterations;
        for (iterations = 0; !q.isEmpty(); iterations++) {
            Vertex v = q.remove();

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if (--w.scratch == 0) {
                    q.add(w);
                }
                if (v.dist == INFINITY) {
                    continue;
                }
                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }
        }

        if (iterations != vertexMap.size()) {
            throw new GraphException("Graph has a cycle!");
        }
    }

    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    public boolean isConnected() {
        for (Vertex vertex : vertexMap.values()) {
            if (vertex.dist == INFINITY) {
                return false;
            }
        }
        return true;
    }

    private void printPath(Vertex dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }

    public void printPath(String destName) {
        Vertex w = vertexMap.get(destName);
        if (w == null) {
            throw new NoSuchElementException();
        } else if (w.dist == INFINITY) {
            System.out.println(destName + " is unreachable");
        } else {
            System.out.print("(Cost is: " + w.dist + " ) ");
            printPath(w);
            System.out.println();
        }
    }

    public double getDistance(String destName) {
        Vertex w = vertexMap.get(destName);
        if (w == null) {
            throw new NoSuchElementException();
        }
        return w.dist;
    }

    private void clearAll() {
        for (Vertex v : vertexMap.values()) {
            v.reset();
        }
    }

    @Override
    public String toString() {
        String string = "NODES: " + vertexMap.size() + "\n"; // aantal nodes
        for (Vertex vertex : vertexMap.values()) { // loop door vertexes
            string += "Vertex " + vertex.name + ":\n";
            if (vertex.adj.size() != 0)
                for (Edge edge : vertex.adj) {
                    string += edge.dest.name + " " + edge.cost + "\n";
                }
            else string += "No edges...\n";
        }
        return string;
    }

    private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();
}

// Used to signal violations of preconditions for
// various shortest path algorithms.
class GraphException extends RuntimeException {
    public GraphException(String name) {
        super(name);
    }
}
