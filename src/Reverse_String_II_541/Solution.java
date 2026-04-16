package Reverse_String_II_541;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(reverseStr("abcdefg", 2));
        //System.out.println(reverseStr("abcd", 2));
        //System.out.println(reverseStr("a", 2));
        //System.out.println(reverseStr("abcdefg", 8));
        System.out.println(reverseStr("abcdefg", 1213));
    }


    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int end = i + k - 1;
            if (end >= chars.length) end = chars.length - 1;
            int mid = (end - i) / 2;

            for (int j = 0; j <= mid; j++) {
                int p0 = i + j;
                int p1 = end - j;
                char c = chars[p0];
                chars[p0] = chars[p1];
                chars[p1] = c;
            }

        }

        return new String(chars);
    }

}
