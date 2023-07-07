package Find_First_Palindromic_String_in_the_Array_2108;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        String[] words = {"abc","car","ada","racecar","cool"};

        System.out.println(firstPalindrome(words));

    }

    public static String firstPalindrome(String[] words) {

        for (String word : words) {
            //check
            boolean isPalindrome = true;
            int first = 0, last = word.length() - 1;
            while (first < last) {
                if (word.charAt(first) != word.charAt(last)) {
                    isPalindrome =  false;
                    break;
                }
                first++;
                last--;
            }
            if (isPalindrome) {
                return word;
            }
        }

        return "";
    }

}
