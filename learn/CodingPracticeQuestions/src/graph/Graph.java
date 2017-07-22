package graph;

import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices = new ArrayList<>();

    public void addVertex(int i, int value) {
        // If vertex does not exist add it.
        for(Vertex x: vertices) {
            if(x.getId() == i) return;
        }
        vertices.add(new Vertex(i, value));
    }

    public void addEdge(int x, int y) {
        Vertex xV = findVertex(x);
        Vertex yV = findVertex(y);
        if(xV == null || yV == null) {
            throw new IllegalArgumentException("Edge is invalid");
        }
        xV.addAdjacent(yV);
        yV.addAdjacent(xV);
    }

    public void print() {
        for(Vertex v: vertices) {
            v.print();
            System.out.println();
        }

    }

    public final ArrayList<Vertex> neighbors(Vertex x) {
        return x.getAdj();
    }

    public final ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public Vertex findVertex(int i) {
        for(Vertex x: vertices) {
            if(x.getId() == i) return x;
        }
        return null;
    }

}
