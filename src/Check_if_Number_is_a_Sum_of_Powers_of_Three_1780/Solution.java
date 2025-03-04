package Check_if_Number_is_a_Sum_of_Powers_of_Three_1780;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(21));
        System.out.println(checkPowersOfThree(1000000));

    }

    public static boolean checkPowersOfThree(int n) {
        if (n == 0) return true;
        int val = 43_046_721;
        for (int i = 0; i <= 16; i++) {
            if (n >= val) {
                n -= val;
                if (n == 0) {
                    return true;
                } else if (n < 0) {
                    return false;
                }
            }
            val /= 3;
        }
        return false;
    }


}
