package Closest_Prime_Numbers_in_Range_2523;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
        System.out.println(Arrays.toString(closestPrimes(4, 6)));
    }

    public static int[] closestPrimes(int left, int right) {
        boolean[] notPrime = sieveOfEratosthenes(right);
        int[] res = new int[]{-1, -1};
        int minDistance = Integer.MAX_VALUE;

        int num = Integer.MIN_VALUE + 1 + right;
        for (int i = left; i <= right; i++) {
            if (notPrime[i]) continue;
            int distance = i - num;
            if (distance < minDistance) {
                res[0] = num;
                res[1] = i;
                minDistance = distance;
                if (minDistance <= 2) break;
            }
            num = i;
        }
        if (res[0] < 0) {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int p = 2; p * p <= n; p++) {
            if (notPrime[p]) continue;
            for (int i = p * p; i <= n; i += p) notPrime[i] = true;
        }
        return notPrime;
    }
}
