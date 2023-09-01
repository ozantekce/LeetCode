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

        List<Integer> letters = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];
            if((c>=97 && c<=122) || (c>=65 && c<=90) ){
                letters.add(i);
                stack.add(c);
            }

        }

        for (int index : letters) {
            char c = stack.pop();
            chars[index] = c;
        }

        return new String(chars);
    }

}
