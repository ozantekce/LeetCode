package Repeated_Substring_Pattern_459;

public class Solution {


    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));

    }


    public static boolean repeatedSubstringPattern(String s) {
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 1; i < s.length()/2+1; i++) {
            String temp = s.substring(0,i);
            stringBuilder.append(temp.repeat((s.length() / (i))));
            if(stringBuilder.toString().equals(s))return true;
            stringBuilder.setLength(0);
        }

        return false;
    }

}
