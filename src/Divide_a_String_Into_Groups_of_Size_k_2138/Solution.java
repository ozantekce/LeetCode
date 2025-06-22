package Divide_a_String_Into_Groups_of_Size_k_2138;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));

    }

    public static String[] divideString(String s, int k, char fill) {

        int l = (s.length() / k) + (s.length() % k == 0 ? 0 : 1);
        String[] result = new String[l];

        int p = 0;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()) {
            int j = 0;
            stringBuilder.setLength(0);
            while (j < k && i < s.length()) {
                stringBuilder.append(s.charAt(i));
                i++;
                j++;
            }
            result[p++] = stringBuilder.toString();
        }

        while (stringBuilder.length() < k) {
            stringBuilder.append(fill);
        }

        result[l - 1] = stringBuilder.toString();

        return result;
    }

}
