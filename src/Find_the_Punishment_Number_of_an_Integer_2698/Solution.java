package Find_the_Punishment_Number_of_an_Integer_2698;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        //isValid(9);
        System.out.println(punishmentNumber(37));
    }


    public static int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                res += (i * i);
            }
        }
        return res;
    }


    public static boolean isValid(int num) {
        int numSqr = num * num;
        int digitCount = calculateDigitCount(numSqr);
        int[] digits = getDigits(numSqr, digitCount);
        return isValidRecursive(0, 0, digits, 0, num);
    }

    public static boolean isValidRecursive(int separator,
                                           int before,
                                           int[] digits,
                                           int currentValue,
                                           int target) {
        if (separator == digits.length || before == digits.length) {
            return currentValue == target;
        }
        for (int current = before + 1; current <= digits.length; current++) {
            int localValue = calculatePart(before, current, digits);
            boolean res = isValidRecursive(
                    separator + 1,
                    current,
                    digits,
                    currentValue + localValue,
                    target);
            if (res) {
                return true;
            }
        }
        return false;
    }


    private static int calculateDigitCount(int num) {
        int res = 0;
        while (num > 0) {
            res++;
            num /= 10;
        }
        return res;
    }

    private static int[] getDigits(int num, int digitCount) {
        int[] res = new int[digitCount];
        int i = digitCount;
        while (num > 0) {
            res[--i] = num % 10;
            num /= 10;
        }
        return res;
    }

    private static int calculatePart(int before, int current, int[] digits) {
        int part = 0;
        for (int i = before; i < current; i++) {
            part *= 10;
            part += digits[i];
        }
        return part;
    }


}
