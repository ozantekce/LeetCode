package Construct_Smallest_Number_From_DI_String_2375;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(smallestNumber("IIIDIDDD"));
        //System.out.println(smallestNumber("DDD"));

    }


    public static String smallestNumber(String pattern) {
        char[] num = new char[pattern.length() + 1];
        boolean[] used = new boolean[10];
        for (char i = '1'; i <= '9'; i++) {
            num[0] = i;
            used[i - '0'] = true;
            if (find(0, pattern, num, used)) {
                return new String(num);
            }
            used[i - '0'] = false;
        }
        return "";
    }

    // P[i] == I => num[i] < num[i+1]
    // P[i] == D => num[i] > num[i+1]

    // x = i+1 => i = x-1
    // P[x-1] == I => num[x-1] < num[x] => num[x] > num[x-1] => num[x] is greater than num[x-1]
    // P[x-1] == D => num[x-1] > num[x] => num[x] < num[x-1] => num[x] is less than num[x-1]

    public static boolean find(int i, String P, char[] num, boolean[] used) {
        if (i == P.length()) return true;
        int x = i + 1;
        boolean lessThanBefore = P.charAt(x - 1) == 'D';
        char before = num[x - 1];

        if (lessThanBefore) {
            for (char current = (char) (before - 1); current >= '1'; current--) {
                int index = current - '0';
                if (used[index]) continue;
                num[x] = current;
                used[index] = true;
                if (find(i + 1, P, num, used)) return true;
                used[index] = false;
            }
        } else {
            for (char current = (char) (before + 1); current <= '9'; current++) {
                int index = current - '0';
                if (used[index]) continue;
                num[x] = current;
                used[index] = true;
                if (find(i + 1, P, num, used)) return true;
                used[index] = false;
            }
        }
        return false;
    }


}
