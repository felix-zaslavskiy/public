package chapter4;

import base.Question;

public class Q2_Create_MinHeight_BinaryTree implements Question {

    static public class Node {
        int value;
        Node left = null;
        Node right = null;
    }

    @Override
    public void run() {

        // Create binary search tree. Must be complete binary tree.
        // BST.. left <= n < right
        // Given sorted asc unique integers.

        // 1, 2, 3, 4 ,5
        //    1
        //  2
        // 3

        // Start middle 3
        // Create left tree . Create right tree

        // 1, 2, 4 ,5
        //     2
        //   1   4
        //         5

        // 1, 2, 4 ,5

        //     4
        //   2   5
        // 1

        // Take ceiling of middle.
        int[] array = {1, 2, 3, 4 };

        Node n = buildTree(array, 0, array.length);

        printTree(n, 0);


    }

    private void printTree(Node n, int level) {
        if(n == null) return;

        for(int i =0; i <= level; i++){
            System.out.print("\t");
        }
        System.out.println(n.value);
        int levelNew = level + 1;
        printTree(n.left, levelNew);
        printTree(n.right, levelNew);

    }

    private Node buildTree(int[] array, int leftIdx, int rightIdx) {

        int size = rightIdx - leftIdx; // 4
        int offset;
        if(size == 1){
            offset =0;
        }else {
            offset = (int)Math.floor((float)size/2.0f);
        }
        int center = leftIdx +  offset;

        Node n = new Node();
        n.value = array[center];

        if(leftIdx != center )
            n.left = buildTree(array, leftIdx, center ); // 0, 2   0, 1

        if(center != rightIdx - 1)
            n.right = buildTree(array, center + 1, rightIdx);

        return n;
    }

}
