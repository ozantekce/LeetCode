package Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits_2342;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));

    }

    public static int maximumSum(int[] nums) {
        int[] bests = new int[82];
        int[] sums = new int[82];
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sumOfDigits = sumOfDigits(num);
            int best = bests[sumOfDigits];
            if (best != 0) {
                if (num > best) {
                    sums[sumOfDigits] = best + num;
                    bests[sumOfDigits] = num;
                    res = Math.max(res, sums[sumOfDigits]);
                } else {
                    int other = sums[sumOfDigits] - best;
                    if (num > other) {
                        sums[sumOfDigits] = best + num;
                        res = Math.max(res, sums[sumOfDigits]);
                    }
                }
            } else {
                bests[sumOfDigits] = num;
            }
        }
        return res;
    }

    private static int sumOfDigits(int num) {
        int res = 0;
        while (num > 9) {
            int temp = num / 10;
            res += num - (temp * 10);
            num = temp;
        }
        return res + num;
    }

}
