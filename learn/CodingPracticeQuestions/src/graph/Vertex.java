package graph;

import java.util.ArrayList;

public class Vertex {

    ArrayList<Vertex> adj = new ArrayList<>();

    int id;
    int value;

    public Vertex(int i, int value) {
        id = i;
        this.value = value;
    }

    public int getId() {
        return  id;
    }

    public int getValue() {
        return value;
    }
    public void  addAdjacent(Vertex newVertex) {
        // don't add duplicates
        for(Vertex x: adj) {
            if(x.getId() == newVertex.getId()) return;
        }
        adj.add(newVertex);
    }

    public void print() {
        System.out.print("V:" + id + " ");
        for(Vertex v: adj) {
            System.out.print("->" + v.getId() + " ");
        }
    }

    public String toString() {
        return "V:" + id + "," + value;
    }

    final ArrayList<Vertex> getAdj() {
        return adj;
    }


}
