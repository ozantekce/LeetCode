package Minimize_Maximum_Pair_Sum_in_Array_1877;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(minPairSum(new int[]{3,5,2,3}));
        System.out.println(minPairSum(new int[]{3,5,4,2,4,6}));

    }


    public static int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int p1 = 0, p2 = nums.length-1;

        int max = 0;
        while (p2>p1){
            max = Math.max(nums[p1]+nums[p2],max);
            p1++;
            p2--;
        }


        return max;
    }


}
