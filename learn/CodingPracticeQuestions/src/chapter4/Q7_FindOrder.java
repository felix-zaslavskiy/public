package chapter4;

import base.Question;

import java.util.*;

public class Q7_FindOrder implements Question {


    class Node {

        boolean visited = false;
        String value;
        List<Node> adjacent = new ArrayList<>();

        Node(String v){
            this.value = v;
        }

    }

    @Override
    public void run() {

        // Build the directed graph.
        // NOTE : not solve the problem as described in book.

        List<String> items  =Arrays.asList("a", "b", "c", "d");

        String[] from = {"a", "c", "d", "d"};
        String[] to   = { "b", "b", "a", "c"};


        Map<String, Node>  nodes = new HashMap();
        for(String s : items ){
            nodes.put(s, new Node(s));
        }

        for(int i = 0; i < from.length; i++){
          String f = from[i];
          String t = to[i];
          Node n  = nodes.get(f);
          n.adjacent.add(nodes.get(t));
        }

        // For each node perform DFS through.. If all nodes visited then found.

        for(Node n : nodes.values()){

            // Clear all the visited flags
            for(Node x: nodes.values()){
                x.visited = false;
            }

            // Do DFS
            checkDFS(n);

            // Check if all visited.
            boolean allVisited = true;
            for(Node y: nodes.values()){
                if(!y.visited){
                    allVisited = false;
                    break;
                }
            }

            if(allVisited){
                System.out.println("Found a path");
                break;
            }

        }

    }

    private void checkDFS(Node n) {
        // Mark as visited
        n.visited = true;
        for(Node x : n.adjacent){
            if(!x.visited) {
                checkDFS(x);
            }
        }
    }
}
