package _3Sum_Closest_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int nums[] ={-1,2,1,-4};
        //-5, -5, -4, 0, 0, 3, 3, 4, 5

        System.out.println(threeSumClosest(nums,1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int lastVal = nums[0];
        int closestSum = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {

            if(i!=0&&lastVal == nums[i])
                continue;
            lastVal = nums[i];
            int sum = nums[i]+findClosest(nums,i+1,(target-nums[i]));
            //System.out.println(sum);
            if(Math.abs(sum-target)<distance){
                closestSum = sum;
                distance = Math.abs(sum-target);
            }
        }

        return closestSum;
    }


    public static int findClosest(int[]nums,int firstIndex,int target){

        int i = firstIndex;
        int j = nums.length-1;
        int distance = Integer.MAX_VALUE;

        int closestSum = 0;
        while (i<j){

            int sum = nums[i]+nums[j];
            if(Math.abs(sum-target)<distance){
                closestSum = sum;
                distance = Math.abs(sum-target);
            }
            if(sum>target){
                j--;
            }else{
                i++;
            }

        }

        return closestSum;
    }

}
