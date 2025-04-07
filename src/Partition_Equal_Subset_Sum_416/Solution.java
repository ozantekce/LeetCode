package Partition_Equal_Subset_Sum_416;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        //System.out.println(canPartition(new int[]{1, 2, 3, 5}));
        //System.out.println(canPartition(new int[]{9, 10, 15, 3, 9, 2, 9, 10, 13, 1}));
        //System.out.println(canPartition(new int[]{6, 14, 19, 10, 17, 10, 8, 15, 16, 1, 12, 4, 9, 2, 15}));
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));

    }


    public static boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int value : nums) totalSum += value;
        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int value : nums) {
            if (value > targetSum) return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = targetSum; j >= num; j--) {
                int k = j - num;
                dp[j] |= dp[k];
            }
        }

        return dp[targetSum];
    }


}
