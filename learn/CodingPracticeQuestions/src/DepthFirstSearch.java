import graph.Graph;
import graph.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch implements Question {
    @Override
    public void run() {
        Graph g = new Graph();
        g.addVertex(0, 0);
        g.addVertex(1,1);
        g.addVertex(2,2);

        g.addVertex(3, 3);
        g.addVertex(4, 4);
        g.addVertex( 5, 5 );

        g.addEdge( 0, 5 );
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge( 1, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 4);


        Vertex root = g.findVertex(1);
        dfs(g, root, 10);
    }

    public Vertex dfs(Graph g, Vertex root, int value ) {

        Stack<Vertex> S = new Stack<>();

        Map<Vertex, Vertex> discoveredList = new HashMap<>();
        discoveredList.put(root, null);
        S.push(root);

        while (!S.empty()) {
            Vertex current = S.pop();
            discoveredList.put(current, S.peek());
            for (Vertex n : g.neighbors(current)) {
                S.push(n);
            }
        }

        printDFSTree(discoveredList, root, 0);
        return null;
    }

    private void printDFSTree(Map<Vertex, Vertex> discoveredList, Vertex root, int depth) {
        // Find vertices w/ root as parent
        for(int i =0;i<depth;i++) System.out.print("  ");
        System.out.print(root);
        System.out.print("\n");
        for(Map.Entry<Vertex,Vertex> entry:  discoveredList.entrySet()) {
            if(entry.getValue()!=null && entry.getValue().equals(root)){
                int newDepth = depth+1;
                printDFSTree(discoveredList, entry.getKey(), newDepth);
            }
        }
    }

}
