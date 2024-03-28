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
        //System.out.println(fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 8));

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
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
                    }else if(currenValue < currentTarget){
                        f++;
                    }else{
                        int num2 = nums[f];
                        int num3 = nums[l];
                        // we know that num0 <= num1 <= num2 <= num3,
                        // so we can create a hash code to skip duplicated quadruplets
                        int hash = hashCode(num0, num1, num2, num3);
                        if(set.add(hash)){
                            List<Integer> list = new ArrayList<>(4);
                            list.add(num0);
                            list.add(num1);
                            list.add(num2);
                            list.add(num3);
                            result.add(list);
                        }
                        l--;
                    }
                }

            }

        }

        return result;
    }

    private static int hashCode(int a, int b, int c, int d) {
        int hash = 17;
        hash = ((hash << 5) - hash) + a;
        hash = ((hash << 5) - hash) + b;
        hash = ((hash << 5) - hash) + c;
        hash = ((hash << 5) - hash) + d;
        return hash;
    }



}
