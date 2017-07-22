import graph.Graph;

public class BasicGraph implements  Question {
    @Override
    public void run() {
        Graph g = new Graph();
        g.addVertex(1,0);
        g.addVertex(2,0);

        g.addVertex(3, 0);

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge( 1, 3);

        g.print();
    }
}
