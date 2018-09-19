package chapter1;

import base.Question;

import java.util.Arrays;

public class ArrayList3_StringEditInPlace implements Question {
    @Override
    public void run() {

        char urlify[] = "       ".toCharArray();
        // keep original
        char urlcopy[] = Arrays.copyOf(urlify, urlify.length);

        int size = 0;

        urlify(urlify, size);

        System.out.println(urlcopy);
        System.out.println(urlify);
    }

    public void urlify(char[] url, int size){
        if(size ==0 ) return;
        // We can calculate the index where to start placing characters from
        // end into the url.
        // We need to walk through the array and count number of non spaces.
        // Subtract non spaces from total characters.
        char space = ' ';
        int nonSpaces = 0;
        for(int i =0; i < url.length; i++) {
            if(url[i] != space) nonSpaces++;
        }

        // "x  x  ";
        // "x%20x ";
        int indexOfLast  = (size - nonSpaces) * 3 + nonSpaces - 1;
        int indexOfLastNonSpace = url.length-1;

        // Skip over spaces from the end until we find a non space.
        for(int i = url.length-1; i>=0; i--){
            if(url[i] != space) {
                indexOfLastNonSpace = i;
                break;
            }
        }
        // Iterate from end and for each nonSpace
        // Move the character into its predicted index.
        for(int i = indexOfLastNonSpace; i>=0; i--){
            if(url[i] != space) {
                url[indexOfLast] = url[i];
                indexOfLast--;
            } else {
                url[indexOfLast] = '0';
                url[indexOfLast-1] = '2';
                url[indexOfLast-2] = '%';
                indexOfLast -=3;
            }
        }

    }

}
