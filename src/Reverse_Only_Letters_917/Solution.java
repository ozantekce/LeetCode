package Reverse_Only_Letters_917;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {


        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }



    public static String reverseOnlyLetters(String s) {

        char[] chars = s.toCharArray();

        int f = 0;
        int l = s.length()-1;

        while (f<l){

            char f_c = chars[f];
            char l_c = chars[l];

            boolean f_c_l = isLetter(f_c);
            boolean l_c_l = isLetter(l_c);

            if(f_c_l && l_c_l){
                chars[f] = l_c;
                chars[l] = f_c;
                f++;
                l--;
            }else if(f_c_l){
                l--;
            }else if(l_c_l){
                f++;
            }else{
                f++;
                l--;
            }

        }


        return new String(chars);
    }


    private static boolean isLetter(char c){
        return (c>=97 && c<=122) || (c>=65 && c<=90);
    }

}
