package Longest_Palindrome_409;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        String input = "aba";
        System.out.println(longestPalindrome(input));

    }



    public static int longestPalindrome(String s) {

        char [] chars = s.toCharArray();
        char [] charsCounter = new char[128];

        int rst = 0;
        for (int i = 0; i < chars.length; i++) {
            charsCounter[chars[i]]++;
            if(charsCounter[chars[i]]>=2){
               rst+=2;
               charsCounter[chars[i]]=0;
            }
        }

        if(rst<chars.length)
            return rst+1;

        return rst;
    }

    /*
    public static int longestPalindrome(String s) {

        char [] chars = s.toCharArray();
        Arrays.sort(chars);
        char last = chars[0];
        int result = 0;
        boolean odd = false;
        int counter = 1;
        for (int i = 1; i < chars.length; i++) {
            if(last==chars[i]){
                counter++;
            }else{
                if(counter>=1){
                    result+=(counter/2)*2;
                    if(!odd)
                        odd = counter%2==1;
                }
                counter=1;
            }
            last = chars[i];
        }
        if(counter>=1){
            result+=(counter/2)*2;
            if(!odd)
                odd = counter%2==1;
        }
        if(odd)
            result++;

        return result;
    }
*/
}
