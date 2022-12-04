package Reverse_String_344;

public class Solution {

    public static void main(String[] args) {

        reverseString(new char[]{});

    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }

    }

}
