package Shuffle_an_Array_384;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        solution.shuffle();
        solution.reset();
        solution.shuffle();
    }


    private int[] nums;
    private int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        original = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = original[i];
        }
        return nums;
    }

    public int[] shuffle() {

        for (int i = nums.length-1; i > 0; i--) {
            int j = (int)(Math.random()*(i+1));
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }



}
