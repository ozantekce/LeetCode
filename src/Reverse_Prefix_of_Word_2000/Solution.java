package Reverse_Prefix_of_Word_2000;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reversePrefix("abcdefd",'d'));

    }


    public static String reversePrefix(String word, char ch) {


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            stringBuilder.append(c);
            if(c == ch){
                stringBuilder.reverse();
                stringBuilder.append(word.substring(i+1));
                break;
            }
        }


        return stringBuilder.toString();
    }

}
