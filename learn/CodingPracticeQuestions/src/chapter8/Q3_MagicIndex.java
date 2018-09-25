package chapter8;

import base.Question;

public class Q3_MagicIndex implements Question {

    @Override
    public void run() {
        // A[0..n-1]  magic index A[i] = i
        // Given sorted array of Distinct integers
        // Find magic index if one exists.


        int A[] = {-2, -1, 0, 3, 4 };

        int magicIndex = findMagicIndex(A);
        if( magicIndex == Integer.MIN_VALUE) {
            System.out.println("Not found");
        } else {
            System.out.println("Found :" + magicIndex);
        }
    }

    private int findMagicIndex(int[] A) {
        return findMagicIndexInt(A, 0, A.length);
    }

    private int findMagicIndexInt(int[] a, int left, int right) {
        if(right - left == 0) return Integer.MIN_VALUE;
        int mid = (right - left)/2;

        int testIndex = left + mid;
        if(a[testIndex] == testIndex){
            return testIndex;
        } else if(a[testIndex] < testIndex){
            // go right
            return findMagicIndexInt(a, testIndex, right);
        } else {
            // go left
            return findMagicIndexInt(a, left, testIndex - 1);
        }

    }


}
