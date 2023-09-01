package _3Sum_15;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        int [] nums ={0,0,0,0};

        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int lastVal = nums[0];
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {

            if(i!=0&&lastVal == nums[i])
                continue;
            lastVal = nums[i];
            findTarget(nums,i+2,-nums[i],set);

        }

        return new ArrayList<>(set);
    }


    public static void findTarget(int[]nums,int firstIndex,int target,Set<List<Integer>> set){

        int i = firstIndex;
        int j = nums.length-1;
        while (i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                List<Integer> temp = new ArrayList<>(3);
                temp.add(nums[firstIndex-1]);
                temp.add(nums[i]);
                temp.add(nums[j]);
                set.add(temp);
                break;
            }
            if(sum>target){
                j--;
            }else{
                i++;
            }
        }

    }

}
