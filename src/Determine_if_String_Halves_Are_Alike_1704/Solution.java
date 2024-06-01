package Determine_if_String_Halves_Are_Alike_1704;

import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(halvesAreAlike("book"));
        //System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("AbCdEfGh"));
    }


    public static boolean halvesAreAlike(String s) {

        int count = 0;

        String VOWELS = "aeiouAEIOU";

        for (int i = 0; i < s.length()/2; i++) {
            char c = s.charAt(i);
            if(VOWELS.indexOf(c) != -1)
                count++;
        }

        for (int i = s.length()/2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(VOWELS.indexOf(c) != -1)
                count--;
        }


        return count == 0;
    }

}
