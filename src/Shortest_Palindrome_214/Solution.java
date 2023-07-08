package Shortest_Palindrome_214;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        System.out.println(shortestPalindrome("aacecaaa"));
        //System.out.println(shortestPalindrome("abbacd"));
        //System.out.println(shortestPalindrome("abcd"));
        //System.out.println(shortestPalindrome("abbabaab"));
        //System.out.println(shortestPalindrome("fnkusducfwltsfaahfsfqxpwxzmsjcxyixzjhaguutgmuopsmfoontikdtdvezmypitnguzteqfusrbnplnecgzlsdqdnqqh"));

        System.out.println(shortestPalindrome("babbbabbaba"));
        //abab|babbbabbaba
        //ababbab|babbbabbaba
        //ababbabbbabbbabbaba
        //ababbabbbabbaba
        //System.out.println(findPattern("ababcabcabababd","ababd"));
        //System.out.println(findPattern("aacecaaa","caad"));

    }


    public static String shortestPalindrome(String s) {
        if(s.equals(""))return "";
        return String.valueOf(findBestPatternOptimized(s.toCharArray()));
    }

    private static char[] findBestPatternOptimized(char [] chars_String){

        int size = chars_String.length;
        int [] table = new int[size+1];
        int pointer = 0;
        int score = 1;
        for (int i = 1; i < size; i++) {
            char pointedChar = chars_String[pointer];
            char currentChar = chars_String[i];
            if(currentChar==pointedChar){
                table[i+1] = score;
                score++;
                pointer++;
            }else{
                pointer = 0;
                score = 1;
                if(currentChar == chars_String[0]){
                    table[i+1] = 1;
                }
            }
            //System.out.println(currentChar+" "+pointedChar+" "+Arrays.toString(table));
        }

        //System.out.println(Arrays.toString(table));
        int pointerOfString = 0;
        int pointerOfTable = 0;

        while (pointerOfString < size) {

            char nextInPattern = chars_String[pointerOfTable];
            char currentInString = chars_String[reversedIndex(pointerOfString,size)];
            //System.out.println(currentInString+" "+nextInPattern+" "+pointerOfTable);
            if(nextInPattern == currentInString){
                pointerOfTable++;
                pointerOfString++;
            }else{
                if(pointerOfTable == 0){
                    pointerOfString++;
                }else{
                    pointerOfTable = table[pointerOfTable];
                }
            }

        }

        char[] result = new char[size + chars_String.length - pointerOfTable];

        for (int i = size - 1, j = 0; i >= pointerOfTable; i--, j++) {
            result[j] = chars_String[i];
        }

        System.arraycopy(chars_String, 0, result, size - pointerOfTable, chars_String.length);

        return result;
    }

    private static int reversedIndex(int index,int size){
        return size-1-index;
    }



    private static String findBestPattern(String string, String pattern){

        //System.out.println(string+" "+pattern);
        int [] table = new int[pattern.length()+1];
        int pointer = 0;
        int score = 1;

        char [] chars_String  = string.toCharArray();
        char [] chars_Pattern = pattern.toCharArray();

        for (int i = 1; i < pattern.length(); i++) {
            char pointedChar = chars_Pattern[pointer];
            char currentChar = chars_Pattern[i];
            if(currentChar==pointedChar){
                table[i+1] = score;
                score++;
                pointer++;
            }else{
                pointer = 0;
                score = 1;
                if(currentChar == pattern.charAt(0)){
                    table[i+1] = 1;
                }
            }
            //System.out.println(currentChar+" "+pointedChar+" "+Arrays.toString(table));
        }

        //System.out.println(Arrays.toString(table));
        //if(1==1)return "";
        int pointerOfString = 0;
        int pointerOfTable = 0;

        while (pointerOfString < string.length()) {

            char nextInPattern = chars_Pattern[pointerOfTable];
            char currentInString = chars_String[pointerOfString];
            //System.out.println(currentInString+" "+nextInPattern+" "+pointerOfTable);
            if(nextInPattern == currentInString){
                pointerOfTable++;
                pointerOfString++;
            }else{
                if(pointerOfTable == 0){
                    pointerOfString++;
                }else{
                    pointerOfTable = table[pointerOfTable];
                }
            }

        }
        //System.out.println(pointerOfTable);

        StringBuilder result = new StringBuilder();
        result.append(string, 0, string.length()-pointerOfTable);
        result.append(pattern);
        return result.toString();
    }


    private static boolean findPattern(String string, String pattern){

        int [] table = new int[pattern.length()+1];

        int pointer = 0;
        int score = 1;
        for (int i = 1; i < pattern.length(); i++) {
            char pointedChar = pattern.charAt(pointer);
            char currentChar = pattern.charAt(i);
            if(currentChar==pointedChar){
                table[i+1] = score;
                score++;
                pointer++;
            }else{
                pointer = 0;
                score = 1;
            }
        }

        int pointerOfString = 0;
        int pointerOfTable = 0;
        while (pointerOfString < string.length()) {

            char nextInPattern = pattern.charAt(pointerOfTable);
            char currentInString = string.charAt(pointerOfString);

            if(nextInPattern == currentInString){
                pointerOfTable++;
                pointerOfString++;
            }else{
                if(pointerOfTable == 0){
                    pointerOfString++;
                }else{
                    pointerOfTable = table[pointerOfTable];
                }
            }
            if(pointerOfTable==table.length-1)return true;
        }

        return false;
    }


}
