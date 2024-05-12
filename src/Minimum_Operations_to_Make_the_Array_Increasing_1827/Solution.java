package Minimum_Operations_to_Make_the_Array_Increasing_1827;

import java.util.Arrays;

public class Solution {



    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{1,1,1}));
        System.out.println(minOperations(new int[]{1,5,2,4,1}));
        System.out.println(minOperations(new int[]{8}));

    }




    public static int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] + 1 > nums[i]){
                res += (nums[i-1]+1 - nums[i]);
                nums[i] = nums[i-1]+1;
            }
        }
        return res;
    }


}
