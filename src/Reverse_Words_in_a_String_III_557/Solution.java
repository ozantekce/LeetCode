package Reverse_Words_in_a_String_III_557;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));

    }


    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int startIndex = 0;
        int finishIndex =-1;
        for (int i = 0; i < s.length(); i++) {

            if(chars[i]==' '){
                finishIndex = i;
                Swap(chars,startIndex,finishIndex-1);
                startIndex = finishIndex+1;
            }else if(i== s.length()-1){
                Swap(chars,startIndex,i);
            }
            //System.out.println(new String(chars));
        }


        return new String(chars);
    }

    private static void Swap(char[] chars, int startIndex, int finishIndex) {

        int mid = (finishIndex+startIndex)/2;
        for (int i = 0; startIndex+i <= mid ; i++) {

            char record = chars[i+startIndex];
            chars[startIndex+i] = chars[finishIndex-i];
            chars[finishIndex-i] = record;
        }

    }

    /*
    public static String reverseWords(String s) {


        List<Stack<Character>> handler = new ArrayList<>();

        char[] chars = s.toCharArray();

        Stack<Character> currentStack = new Stack<>();
        handler.add(currentStack);

        for (int i = 0; i < chars.length; i++) {

            if(chars[i]==' '){
                currentStack = new Stack<>();
                handler.add(currentStack);
            }else{
                currentStack.add(chars[i]);
            }

        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < handler.size(); i++) {
            currentStack = handler.get(i);
            while (!currentStack.isEmpty()){
                char c = currentStack.pop();
                stringBuilder.append(c);
            }
            if(i!=handler.size()-1)
                stringBuilder.append(" ");
        }


        return stringBuilder.toString();
    }
    */

}
