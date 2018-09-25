package chapter4;

import base.Question;

public class Q6_Successor implements Question {

  class Node {
    Node parent;
    Node left;
    Node right;
    int value = 0;
    Node(int v, Node parent){
      this.value = v;
      this.parent = parent;
    }
    public String toString() {
      return  "" + value;
    }
  }

  @Override
  public void run() {

    // Find the next in order node.

    Node p = new Node(6, null);
    Node n3  = new Node(3, p);

    p.left = n3;

    Node n2 = new Node(2,n3);
    n3.left = n2;
    Node n4 = new Node(4, n3);
    n3.right = n4;

    Node n7 = new Node(7, p);
    p.right = n7;
    n7.left = new Node(5, null);

    // Node next = findNext(n4);

    System.out.println("Next item is :" );


  }



}
