package Longest_Continuous_Increasing_Subsequence_674;

public class Solution {


    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums) {

        int res = 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            int last = nums[i - 1];
            int curr = nums[i];
            if (curr > last) {
                counter++;
            } else {
                res = Math.max(res, counter);
                counter = 1;
            }
        }

        return Math.max(res, counter);
    }

}
