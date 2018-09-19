package chapter1;

import base.Question;

import java.util.Arrays;

public class ArrayList1_UniqueChars implements Question {
    @Override
    public void run() {

        // 1.1 Determine if string characters are all unique.
        String input = "dd";

        int current=0, next=1;
        // initialize
        boolean hasDifference=false;
        if(input.length() != 1){
            // Sort the input first.
            char sorted[]  = input.toCharArray();
            Arrays.sort(sorted);

            for(int i=0; i < input.length()-1; i++){

                // Check
                if(sorted[current] == sorted[next]) {
                    hasDifference=true;
                    break;
                }

                // Advance pointers
                current++;
                next ++;
            }
        }
        if(hasDifference) System.out.println("String is not unique");
        else System.out.println("String is unique");
    }
}
