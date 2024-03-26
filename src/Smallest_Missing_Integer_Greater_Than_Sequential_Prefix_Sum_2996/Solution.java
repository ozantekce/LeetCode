package Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum_2996;

import java.util.HashSet;

public class Solution {



    public static void main(String[] args) {

        System.out.println(missingInteger(new int[]{1,2,3,2,5}));
        System.out.println(missingInteger(new int[]{3,4,5,1,12,14,13}));

    }


    public static int missingInteger(int[] nums) {

        int prefixSum = findPrefixSum(nums);

        if(prefixSum > 51)
            return prefixSum;

        boolean[] set = new boolean[52];
        for (int i = 0; i < nums.length; i++) {
            set[nums[i]] = true;
        }

        for (int i = prefixSum; i <= 51; i++) {
            if(!set[i]){
                return i;
            }
        }

        return prefixSum;
    }


    private static int findPrefixSum(int[] nums){

        int last = nums[0];
        int sum = last;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if(last + 1 == current){
                sum+=current;
            }else{
                break;
            }
            last = current;
        }
        return sum;
    }

}
