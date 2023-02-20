package Minimum_Moves_to_Equal_Array_Elements_II_462;

import java.util.Arrays;

public class Solution {


    public static int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int avg = nums[nums.length/2];
        int c = 0;
        for (int i = 0; i < nums.length; i++)c += Math.abs(avg-nums[i]);

        return c;
    }

}
