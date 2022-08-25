package Unique_Length_3_Palindromic_Subsequences_1930;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countPalindromicSubsequence("adc"));

    }

    public static int countPalindromicSubsequence(String s) {

        char [] chars = s.toCharArray();
        int [] charFirstIndex = new int[26];
        int [] charLastIndex = new int[26];
        int [] charCounter = new int[26];
        for (int i =0; i<s.length() ; i++) {
            int charVal = s.charAt(i)-97;
            if(charCounter[charVal]==0){
                charFirstIndex[charVal] = i;
            }
            charLastIndex[charVal] = i;
            charCounter[s.charAt(i)-97]++;
        }

        char[] palindromic = new char[3];
        int val=0;
        for (int i = 0; i < 26; i++) {
            if(charCounter[i]>=2){
                char firstChar = (char) (i+97);
                palindromic[0] = firstChar;
                for (int j = 0; j < 26; j++) {
                    if(charCounter[j]>0){
                        char secondChar = (char)(j+97);
                        palindromic[1] = secondChar;
                        palindromic[2] = firstChar;
                        if(stringContains(palindromic,chars,charFirstIndex[i],charLastIndex[i]))
                            val++;
                    }
                }
            }

        }


        return val;
    }


    private static boolean stringContains(char[] palindromic
            , char[] string,int firstIndex,int lastIndex){

        char first = palindromic[0];
        boolean firstFound = false;
        char second = palindromic[1];
        boolean secondFound= false;
        char third = palindromic[2];

        for (int i = firstIndex; i <= lastIndex; i++) {

            if(!firstFound){
                if(string[i] == first)
                    firstFound=true;
            }
            else if(firstFound && !secondFound){
                if(string[i] == second)
                    secondFound = true;
            }
            else if(firstFound && secondFound){

                if(string[i] == third)
                    return true;
            }


        }
        
        return false;
    }




}
