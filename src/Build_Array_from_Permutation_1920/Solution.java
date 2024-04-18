package Build_Array_from_Permutation_1920;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(buildArray(new int[]{0, 2, 1, 5, 3, 4})));
        System.out.println(Arrays.toString(buildArray(new int[]{5, 0, 1, 2, 3, 4})));

    }

    public static int[] buildArray(int[] nums) {
        recursive(0, nums);
        return nums;
    }


    private static void recursive(int i, int nums[]){

        if(i == nums.length)
            return;

        int self = nums[nums[i]];
        recursive(i+1, nums);
        nums[i] = self;

    }

}
