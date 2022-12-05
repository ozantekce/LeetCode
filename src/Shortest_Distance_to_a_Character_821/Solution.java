package Shortest_Distance_to_a_Character_821;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(shortestToChar(s,c)));

    }



    public static int[] shortestToChar(String s, char c) {


        char [] chars = s.toCharArray();
        int  [] result = new int[s.length()];

        int lastCharIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==c){
                lastCharIndex = i;
            }
            result[i] = s.length();
            if(lastCharIndex!=-1){
                result[i] = i-lastCharIndex;
            }
        }

        lastCharIndex = -1;
        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i]==c){
                lastCharIndex = i;
            }
            if(lastCharIndex!=-1){
                result[i] = Math.min(result[i],(lastCharIndex-i));
            }
        }


        return result;
    }

}
