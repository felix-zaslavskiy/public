import base.Question;
import graph.Graph;
import graph.GraphDirected;
import graph.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch implements Question {
    @Override
    public void run() {
        /*
        Graph g = new Graph();
        //g2.addVertex(0, 0);
        g.addVertex(1,1);
        g.addVertex(2,2);

        g.addVertex(3, 3);
        g.addVertex(4, 4);
        g.addVertex( 5, 5 );
        g.addVertex( 6, 6 );

        //g2.addEdge( 0, 5 );
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.addEdge( 2, 4);

        g.addEdge(1, 5);
        g.addEdge( 5, 6);
*/
        //g2.addEdge(2, 5);
        //g2.addEdge(2, 4);


      //  Vertex root = g.findVertex(1);
     //   dfs(g, root, 9);

        GraphDirected g2 = new GraphDirected();
        //g2.addVertex(0, 0);
        g2.addVertex(1,1);
        g2.addVertex(2,2);

        g2.addVertex(3, 3);
        g2.addVertex(4, 4);
        g2.addVertex( 5, 5 );
        g2.addVertex( 6, 6 );

        //g2.addEdge( 0, 5 );
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        g2.addEdge( 2, 4);

        g2.addEdge(1, 5);
        g2.addEdge( 5, 6);
        Vertex root2 = g2.findVertex(1);
        Vertex v  = dfs(g2, root2, 4);
        v.print();
    }

    public Vertex dfs(Graph g, Vertex root, int value ) {

        Stack<Vertex> S = new Stack<>();

        Map<Vertex, Vertex> discoveredList = new HashMap<>();

        S.push(root);


        while (!S.empty()) {

            Vertex current = S.pop();

            if(!discoveredList.containsKey(current)) {
                discoveredList.put(current, null );

                if(current.getValue()== value) {
                    return current;
                }
                for (Vertex n : g.neighbors(current)) {
                    S.push(n);
                }
            }
        }

        return null;
    }

    private void printDFSPath(Map<Vertex, Vertex> discoveredList, Vertex root, int depth) {
        // Find vertices w/ root as parent
        for(int i =0;i<depth;i++) System.out.print("  ");
        System.out.print(root);
        System.out.print("\n");
        for(Map.Entry<Vertex,Vertex> entry:  discoveredList.entrySet()) {
            if(entry.getValue()!=null && entry.getValue().equals(root)){
                int newDepth = depth+1;
                printDFSPath(discoveredList, entry.getKey(), newDepth);
            }
        }
    }

}
