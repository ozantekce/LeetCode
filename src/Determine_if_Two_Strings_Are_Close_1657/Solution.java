package Determine_if_Two_Strings_Are_Close_1657;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(closeStrings("abc","bca"));
        System.out.println(closeStrings("uau","ssx"));
        System.out.println(closeStrings("abbzccca","babzzczc"));
        //1,1,1
        //2,1
    }

    public static boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length())
            return false;

        int [] frequency1 = new int[26];
        int [] frequency2 = new int[26];

        char [] chars1 = word1.toCharArray();
        char [] chars2 = word2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {frequency1[chars1[i]-97]++;}

        for (int i = 0; i < chars1.length; i++) {
            frequency2[chars2[i]-97]++;
            if(frequency1[chars2[i]-97]==0)return false;
        }

        Arrays.sort(frequency1);
        Arrays.sort(frequency2);
        for (int i = 0; i < 26; i++) {
            if(frequency1[i]!=frequency2[i])return false;
        }

        return true;
    }



}
