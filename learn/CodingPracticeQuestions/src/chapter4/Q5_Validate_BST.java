package chapter4;

import base.Question;

public class Q5_Validate_BST implements Question {
  class Node {
    int max= 0;
    Node left;
    Node right;
    int value = 0;
    Node(int value){
      this.value=value;
    }
  }

  @Override
  public void run() {
    // BST =  left <= value < right
    // Traverse in order.
    Node root = new Node(5);

    root.left = new Node(3);
    Node n1 = new Node(6);
    root.right = n1;

    n1.left = new Node(4);
    n1.right = new Node(8);

    System.out.println( "Tree is valid: " + checkB( root ));

  }

  private boolean checkB(Node root) {

      return false;
  }
}
