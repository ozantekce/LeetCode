package Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray_3105;

public class Solution {


    public static void main(String[] args) {

    }


    public static int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int strictlyIncreasing = 1;
        int strictlyDecreasing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                strictlyIncreasing++;
                strictlyDecreasing = 1;
                res = Math.max(strictlyIncreasing, res);
            } else if ( nums[i] < nums[i - 1]) {
                strictlyIncreasing = 1;
                strictlyDecreasing++;
                res = Math.max(strictlyDecreasing, res);
            } else {
                strictlyIncreasing = 1;
                strictlyDecreasing = 1;
            }
        }

        return res;
    }

}
