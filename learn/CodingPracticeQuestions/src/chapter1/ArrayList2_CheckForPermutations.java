package chapter1;

import base.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayList2_CheckForPermutations implements Question {
    @Override
    public void run() {
        String x = "II";
        String y = "II";

        // Determine if two strings are permutations of each other.
        if(arePermutations(x,y )) {
            System.out.println("1 Strings are permutations");
        } else {
            System.out.println("1 Strings are not permutations");
        }
        if(arePermutations2(x,y )) {
            System.out.println("2 Strings are permutations");
        } else {
            System.out.println("2 Strings are not permutations");
        }
    }

    // O( n Log n )
    boolean arePermutations(String x, String y) {
        if(x.length() != y.length()) return false;

        // Sort characters in both strings and compare.
        char x1[] = x.toCharArray();
        char y1[] = y.toCharArray();

        Arrays.sort(x1);
        Arrays.sort(y1);

        return Arrays.equals(x1, y1);
    }

    // O( N )
    // Collect counts of characters in each string and compare them after.
    boolean arePermutations2( String x, String y ) {
        // Count number of characters in first string.. record in table
        // make sure counts for second string match.

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> counts2= new HashMap<>();
        x.chars().forEach( c -> { if(counts.containsKey(c)) {
            counts.put(c, counts.get(c) + 1);
        } else {
            counts.put(c, 1);
        }
        });
        y.chars().forEach( c -> { if(counts.containsKey(c)) {
            counts2.put(c, counts.get(c) + 1);
        } else {
            counts2.put(c, 1);
        }
        });

        for(int i=0; i < y.length(); i++) {
            int c = y.codePointAt(i);
            Integer count = counts.get(c);
            Integer count2=counts.get(c);
            if(count==null ) return  false;
            if(!count.equals(count2) ) {
                return false;
            }

        }
        return true;

    }
}
