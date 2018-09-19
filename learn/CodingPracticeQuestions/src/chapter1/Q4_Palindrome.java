package chapter1;

import base.Question;

public class Q4_Palindrome implements Question {

    // TODO: Explore checking palindrome permutations.

    @Override
    public void run() {
        String s1 = "Test";
        String s2 = "tseT";

        boolean isPalindrome = true;
        for(int idxL = 0, idxR=s2.length()-1; idxL <= s2.length()-1 ; idxL++, idxR--){

            if(idxL > idxR) break;

            if(s1.charAt(idxL) != s2.charAt(idxR)) {
                isPalindrome = false;
                break;
                // Continue
            } else {
                // Is Palindrome
            }

        }
        if(isPalindrome){
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }

    }
}
