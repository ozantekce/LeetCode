package Count_the_Number_of_Powerful_Integers_2999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(numberOfPowerfulInt(1, 6000, 4, "124"));     // 5
        //System.out.println(numberOfPowerfulInt(15, 215, 6, "10"));      // 2
        //System.out.println(numberOfPowerfulInt(1000, 2000, 4, "3000")); // 0
        //System.out.println(numberOfPowerfulInt(20, 1159, 5, "20"));     // 8
        //System.out.println(numberOfPowerfulInt(1, 971, 9, "71"));       // 10

        //System.out.println(numberOfPowerfulInt(697662853L, 11109609599885L, 6, "5"));

        //System.out.println(numberOfPowerfulInt(20, 1159, 5, "20")); // 8
        //System.out.println(numberOfPowerfulInt(1, 971, 9, "71"));   // 10
        System.out.println(numberOfPowerfulInt(1, 971, 9, "72"));   // 9
    }

    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);

        int suffixDigitCount = log10(suffix) + 1;

        int[] finishDigits = getDigits(finish);
        int finishLength = finishDigits.length - suffixDigitCount;
        long finishCount;

        if (finishLength > 0) {
            finishCount = count(finishDigits, limit, 0, finishLength, suffix);
        } else if (finishLength == 0 && finish >= suffix) {
            finishCount = 1;
        } else {
            finishCount = 0;
        }

        int[] startDigits = getDigits(start - 1);
        int startLength = startDigits.length - suffixDigitCount;
        long startCount;

        if (startLength > 0) {
            startCount = count(startDigits, limit, 0, startLength, suffix);
        } else if (startLength == 0 && start - 1 >= suffix) {
            startCount = 1;
        } else {
            startCount = 0;
        }

        return finishCount - startCount;
    }

    public static long count(int[] digits, int limit, int offset, int length, long suffix) {

        if (offset >= length) {
            long num = 0;
            for (int i = offset; i < digits.length; i++) {
                num *= 10;
                num += digits[i];
            }
            return num >= suffix ? 1 : 0;
        }

        int digit = digits[offset];
        int max;
        if (digit > limit) {
            max = limit;
            long res = max + 1;
            for (int i = offset + 1; i < length; i++) {
                res *= (limit + 1);
            }
            return res;
        } else {
            max = digit;
            long res = max;
            for (int i = offset + 1; i < length; i++) {
                res *= (limit + 1);
            }
            return res + count(digits, limit, offset + 1, length, suffix);
        }


    }

    private static int[] getDigits(long num) {
        if (num == 0)
            return new int[]{0};

        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int) (num % 10));
            num /= 10;
        }

        Collections.reverse(digits);

        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);
        }
        return result;
    }

    private static int log10(long num) {
        int result = 0;
        while (num >= 10) {
            num /= 10;
            result++;
        }
        return result;
    }


}
