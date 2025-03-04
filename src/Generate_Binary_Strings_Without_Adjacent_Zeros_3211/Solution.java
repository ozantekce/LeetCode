package Generate_Binary_Strings_Without_Adjacent_Zeros_3211;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(validStrings(3));
        System.out.println(validStrings(1));

    }


    public static List<String> validStrings(int n) {
        char[] chars = new char[n];
        List<String> result = new ArrayList<>();
        chars[0] = '0';
        find(chars, 1, n, result);
        chars[0] = '1';
        find(chars, 1, n, result);
        return result;
    }

    public static void find(char[] chars, int i, int n, List<String> result) {
        if (i == n) {
            result.add(new String(chars));
            return;
        }
        if (chars[i - 1] != '0') {
            chars[i] = '0';
            find(chars, i + 1, n, result);
        }
        chars[i] = '1';
        find(chars, i + 1, n, result);
    }


}
