package chapter4;

import base.Question;

public class Q6_Successor implements Question {

  class Node {
    Node parent;
    Node left;
    Node right;
    int value = 0;
  }

  @Override
  public void run() {

    // Find the next in order node.

    Node p = new Node();
    Node next = findNext(p);


  }

  private Node findNext(Node p) {
    if(p.parent != null) {
      findNextDown(p.parent)
    }
  }

  private Node findNextDown(Node root) {
    if( root == null ) return null;

    if( root.left == null && root.right == null) return root;
    if( root.left!= null) return findNextDown(root.left);
    return findNextDown(root.right);

  }
}
