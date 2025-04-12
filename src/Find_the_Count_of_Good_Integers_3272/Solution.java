package Find_the_Count_of_Good_Integers_3272;

import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(countGoodIntegers(3, 5));
        //System.out.println(countGoodIntegers(1, 4));
        //System.out.println(countGoodIntegers(5, 6));
        System.out.println(countGoodIntegers(9, 4));

    }

    public static long countGoodIntegers(int n, int k) {
        int[] digitCounts = new int[10];
        Duplicated = new HashSet<>();
        return count(0, 0, n, k, digitCounts);
    }

    private static HashSet<Long> Duplicated;

    private static long count(long num, int offset, int n, int k, int[] digitCounts) {
        int front = n - 1 - offset;

        if (offset == front) {
            int res = 0;
            long powOffset = pow(10, offset);
            for (int i = 0; i <= 9; i++) {
                long t = num + powOffset * i;
                digitCounts[i]++;
                res += count(t, offset + 1, n, k, digitCounts);
                digitCounts[i]--;
            }
            return res;
        } else if (offset > front) {
            if (num % k == 0 && Duplicated.add(convertToNum(digitCounts))) {
                return permutations(digitCounts, n);
            } else {
                return 0;
            }
        }else{
            int res = 0;
            long powOffset = pow(10, offset);
            long powFront = pow(10, front);

            for (int i = offset == 0 ? 1 : 0; i <= 9; i++) {
                long t = num + powOffset * i + powFront * i;
                digitCounts[i] += 2;
                res += count(t, offset + 1, n, k, digitCounts);
                digitCounts[i] -= 2;
            }
            return res;
        }

    }

    private static long convertToNum(int[] digitCounts) {
        long res = 0;
        for (int i = 9; i >= 0; i--) {
            int count = digitCounts[i];
            for (int j = 0; j < count; j++) {
                res *= 10;
                res += i;
            }
        }
        return res;
    }

    private static long permutations(int[] digitCounts, int n) {

        long[] fact = new long[n + 1];
        fact[0] = 1L;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        long total = 0;
        for (int first = 1; first <= 9; first++) {
            if (digitCounts[first] == 0) continue;

            digitCounts[first]--;

            int rest = n - 1;
            long denom = 1L;
            for (int d = 0; d <= 9; d++) {
                denom *= fact[digitCounts[d]];
            }

            total += fact[rest] / denom;

            digitCounts[first]++;
        }
        return total;
    }

    private static long pow(int a, int b) {
        long result = 1;
        long base = a;

        while (b > 0) {
            if ((b & 1) == 1) {
                result *= base;
            }
            base *= base;
            b >>= 1;
        }

        return result;
    }


}
