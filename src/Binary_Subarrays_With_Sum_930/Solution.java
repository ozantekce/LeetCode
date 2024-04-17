package Binary_Subarrays_With_Sum_930;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int[] prefixSumCounts = new int[nums.length+1];
        prefixSumCounts[0] = 1;
        int sum = 0;
        int res = 0;

        for (int num : nums) {
            sum += num;
            if(sum - goal >= 0)
                res += prefixSumCounts[sum - goal];
            prefixSumCounts[sum]++;
        }

        return res;
    }



}
