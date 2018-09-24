package chapter4;

import base.Question;

public class Q4_Check_Balanced implements Question {
  class Node {
    boolean hasChildren(){
      if(right!= null|| left!=null) return true;
      return false;
    }
    Node left;
    Node right;
    String value = "";
    Node(String value){
      this.value=value;
    }
  }
  @Override
  public void run() {
    // Balanced binary tree =
    //  heights of two subtree never differ by more then once.

    // This is different from book solution but still should work.
    Node n1 = new Node("n1");
    Node n2 = new Node("n2");
    n1.left = n2;
    Node n3 = new Node("n3");
    n1.right = n3;
    Node n4 = new Node("n4");
    n3.left = n4;
    Node n5 = new Node("n5");
    n4.left = n5;

    boolean isBalaned = isBalanced(n1);
    System.out.println("Tree is balanced: " + isBalaned);

  }

  private boolean isBalanced(Node n1) {

    if(n1 == null ) return true;

    if(n1.left != null && n1.left.hasChildren() && n1.right == null) return false;
    if(n1.right != null && n1.right.hasChildren() && n1.left == null) return false;

    if(!isBalanced(n1.left)) return false;
    if(!isBalanced(n1.right)) return false;

    return true;

  }


}
