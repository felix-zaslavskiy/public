package graph;

public class GraphDirected extends Graph {

    public void addEdge(int from, int to) {
        Vertex fromV = findVertex(from);
        Vertex toV = findVertex(to);
        if(fromV == null || toV == null) {
            throw new IllegalArgumentException("Edge is invalid");
        }
        fromV.addAdjacent(toV); // Only add in one direction.

    }
}
