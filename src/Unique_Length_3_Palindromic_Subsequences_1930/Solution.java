package Unique_Length_3_Palindromic_Subsequences_1930;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countPalindromicSubsequence("bbcbaba"));

    }

    public static int countPalindromicSubsequence(String s) {

        char [] chars = s.toCharArray();
        int totalNumOfChars =0;
        //int aVal =97-97;//0
        //int zVal =122-97;//25
        int [] charCounter = new int[26];
        for (int i =0; i<s.length() ; i++) {
            if(charCounter[s.charAt(i)-97]==0){
                totalNumOfChars++;
            }
            charCounter[s.charAt(i)-97]++;

        }

        char[] palindromic = new char[3];
        int val=0;
        for (int i = 0; i < 26; i++) {

            char firstChar = (char) (i+97);
            palindromic[0] = firstChar;
            if(charCounter[i]>=2){

                for (int j = 0; j < 26; j++) {
                    char secondChar = (char)(j+97);
                    palindromic[1] = secondChar;
                    if(charCounter[j]>0){
                        palindromic[2] = firstChar;
                        if(stringContains(palindromic,chars))
                            val++;
                    }

                }

            }


        }


        return val;
    }


    private static boolean stringContains(char[] palindromic, char[] string){

        char first = palindromic[0];
        boolean firstFound = false;
        char second = palindromic[1];
        boolean secondFound= false;
        char third = palindromic[2];

        for (int i = 0; i < string.length; i++) {

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
