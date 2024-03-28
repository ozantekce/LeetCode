package _4Sum_18;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        //System.out.println(fourSum(new int[]{0,0,0,5,-3,-4,1}, -6));
        //System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
        //System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        //System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        //System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
        System.out.println(fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 8));

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            int num0 = nums[i];

            // skip duplicate
            if(i != 0 && num0 == nums[i-1])
                continue;

            long minSum = (long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            // early exit if minSum is greater than target, any sum cannot be less than or equal to target.
            if(minSum > target)
                break;

            for (int j = nums.length-1; j > i; j--) {
                int num1 = nums[j];
                // skip duplicate
                if(j != nums.length-1 && nums[j+1] == num1)
                    continue;

                if(j-2 >= 0){
                    long maxSum = (long)num0 + num1 + nums[j-1] + nums[j-2];
                    // early exit if maxSum is less than target, any sum cannot be greater than or equal to target.
                    if(maxSum < target)
                        break;
                }

                long currentTarget = (long) target - num0 - num1;
                int f = i+1;
                int l = j-1;

                while (f < l){

                    long currenValue = nums[f] + nums[l];
                    if(currenValue > currentTarget){
                        l--;
                        while (f < l && nums[l] == nums[l + 1]) {
                            l--; // Skip duplicates
                        }
                    }else if(currenValue < currentTarget){
                        f++;
                        while (f < l && nums[f] == nums[f - 1]) {
                            f++; // Skip duplicates
                        }
                    }else{
                        int num2 = nums[f];
                        int num3 = nums[l];
                        List<Integer> list = new ArrayList<>(4);
                        list.add(num0);
                        list.add(num1);
                        list.add(num2);
                        list.add(num3);
                        result.add(list);
                        l--;
                        while (f < l && nums[l] == nums[l + 1]) {
                            l--; // Skip duplicates
                        }
                        f++;
                        while (f < l && nums[f] == nums[f - 1]) {
                            f++; // Skip duplicates
                        }
                    }
                }

            }
        }

        return result;
    }


}
