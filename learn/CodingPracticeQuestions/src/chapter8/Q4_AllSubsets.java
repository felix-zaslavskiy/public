package chapter8;

import base.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q4_AllSubsets implements Question {

    @Override
    public void run() {
        // Return all subsets of a set.

        // 1        -> 1
        // 1, 2     -> 1 - 1,2 - 2
        // 1, 2 , 3 -> 1 - 1,2 - 2 - 3 - 1,3 - 2,3 - 1, 2, 3

        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);

        List<List<Integer>> allSubsets = getSubsets(items);
        for( List<Integer> x : allSubsets){
            for(Integer i : x){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("done");
    }

    private List<List<Integer>> getSubsets(List<Integer> items) {
        if(items.size() == 1){
            List<List<Integer>> l = new ArrayList<>(1);
            l.add(items);
            return l;
        }

        // Take the last element and append it to all the subsets
        int lastIndex = items.size() - 1;

        List<Integer> smaller = new ArrayList<>(items.size() -1);
        for(int i =0 ; i < items.size() -1;  i ++ ){
            smaller.add(items.get(i));
        }

        List<List<Integer>> subsets = getSubsets(smaller);

        List<List<Integer>> biggerSet = new ArrayList<>(subsets);
        for(int i =0; i < subsets.size(); i++){
            // Copy it.
            List<Integer> x = subsets.get(i);
            List<Integer> y = new ArrayList<>(x);
            y.add(items.get(lastIndex));
            biggerSet.add(y);
        }

        List<Integer> l = new ArrayList<>(1);
        l.add(items.get(lastIndex));

        biggerSet.add(l);

        // return itself and all the remaining subsets.
        return biggerSet;
    }
}
