package Number_of_Strings_That_Appear_as_Substrings_in_Word_1967;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
        System.out.println(numOfStrings(new String[]{"a","b","c"},"aaaaabbbbb"));

    }


    public static int numOfStrings(String[] patterns, String word) {

        int counter = 0;
        for (int i = 0; i < patterns.length; i++) {
            if(word.contains(patterns[i]))
                counter++;
        }

        return counter;
    }




}
