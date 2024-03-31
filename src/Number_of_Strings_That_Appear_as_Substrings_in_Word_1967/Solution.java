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
            if(Search(patterns[i], word))
                counter++;
        }

        return counter;
    }


    private static boolean Search(String pat, String txt) {

        char [] word = txt.toCharArray();
        char [] window = pat.toCharArray();

        UpperFor:
        for (int i = 0; i < word.length - window.length + 1; i++) {
            for (int j = 0; j < window.length; j++) {
                char c0 = word[i + j];
                char c1 = window[j];
                if(c0 != c1){
                    continue UpperFor;
                }
            }

            return true;
        }

        return false;
    }


}
