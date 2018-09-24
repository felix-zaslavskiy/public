package chapter4;

import base.Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Q3_List_Of_Depths implements Question {

  class Node {
    int level = 0;
    Node left;
    Node right;
    String value = "";
    Node(String value){
      this.value=value;
    }
  }


  @Override
  public void run() {
    // Given Binary tree , create Linked list at each Depth.

    Node root = new Node("root");
    Node n1 = new Node("n1" );
    Node n2 = new Node("n2");
    Node n3 = new Node( "n3");
    Node n4 = new Node( "n4");
    root.left = n1;
    root.right = n2;
    n2.left = n3;
    n2.right = n4;

    // Traverse Tree - Any order is ok.
    // Return List of Lists
    Collection<List<Node>> result = traverseTree(root);

    // Using BFS.
    ArrayList<List<Node>> result2 = traverseTreeBFS(root);

    System.out.print(result);

  }

  private ArrayList<List<Node>>  traverseTreeBFS(Node root) {

    ArrayList<List<Node>> result =new ArrayList<>();
    ArrayDeque<Node> queue = new ArrayDeque<>();

    queue.push(root);

    while(!queue.isEmpty()){

      Node next = queue.pop();

      if(next.level >= result.size()){
        result.add(new ArrayList<>());
      }
      result.get(next.level).add(next);

      if(next.left!= null) {
        next.left.level = next.level + 1;
        queue.push(next.left);
      }

      if(next.right!= null) {
        next.right.level = next.level + 1;
        queue.push(next.right);
      }

    }
    return result;
  }

  private Collection<List<Node>> traverseTree(Node root) {
    Map<Integer, List<Node>> result =  traverseTreeInternal(root, 0);
    return result.values();
  }

  private Map<Integer, List<Node>> traverseTreeInternal(Node root, int i) {

    if(root == null) return new HashMap<>();

    int level = i + 1;
    Map<Integer, List<Node>> leftList = traverseTreeInternal(root.right, level);
    Map<Integer, List<Node>> rightList= traverseTreeInternal(root.left, level);

    // Merge the maps from both trees.
    for(Map.Entry<Integer,List<Node>> entry : leftList.entrySet()){
      Integer entryLevel = entry.getKey();
      if(rightList.containsKey(entryLevel)){
        rightList.get(entryLevel).addAll(leftList.get(entryLevel));
      } else {
        rightList.put(entryLevel, leftList.get(entryLevel));
      }
    }

    // Add the current item
    if(rightList.containsKey(level)){
      rightList.get(level).add(root);
    } else {
      LinkedList<Node> newList= new LinkedList<>();
      newList.add(root);
      rightList.put(level, newList);
    }
    return rightList;

  }


}
