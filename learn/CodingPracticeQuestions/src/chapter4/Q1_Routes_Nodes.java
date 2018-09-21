package chapter4;

import base.Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q1_Routes_Nodes implements Question {

    static public class Node {

        boolean visited = false;
        ArrayList<Node> adjacent = new ArrayList<>();
        int value=0;

        public Node(int i){
            value = i;
        }
    }

    @Override
    public void run() {

        // Is there a route between two nodes.
        // Use DFS .. when node found then route exists
        {
            Node from = new Node(3);
            Node to = new Node(2);

            Node another = new Node(5);
            Node another2 = new Node(4);

            from.adjacent.add(another);
            from.adjacent.add(another2);

            another.adjacent.add(to);
            another2.adjacent.add(from); // Cause a cycle.

            if (hasRouteDFS(from, to)) {
                System.out.println("has route");
            } else {
                System.out.println("no route");
            }
        }
        {
            Node from = new Node(3);
            Node to = new Node(2);

            Node another = new Node(5);
            Node another2 = new Node(4);

            from.adjacent.add(another);
            from.adjacent.add(another2);

            another.adjacent.add(to);
            another2.adjacent.add(from); // Cause a cycle.
            if (hasRouteBFS(from, to)) {
                System.out.println("has route");
            } else {
                System.out.println("no route");
            }
        }
    }

    private boolean hasRouteDFS(Node from, Node to) {

        // From is the root
        if(from.value == to.value) return true;

        from.visited = true;

        for(Node next : from.adjacent){
            if(!next.visited){
                if(hasRouteDFS(next, to)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean hasRouteBFS(Node from, Node to) {

        // Iterative BFS.
        // Create Queue, Push root.
        // Iterate taking next item. For each item if not visited , mark as visited and add to queue.
        Deque<Node> queue = new ArrayDeque<>();
        from.visited = true;
        queue.push(from);

        while(!queue.isEmpty()){
            Node next = queue.pop();
            if(next.value == to.value){
                return true;
            }

            for(Node n : next.adjacent){
                if(!n.visited){
                    n.visited = true;
                    queue.push(n);
                }
            }
        }
        return false;

    }

}
