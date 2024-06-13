package Reverse_Vowels_of_a_String_345;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));

    }


    public static String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right){
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }


        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U';
    }




}
