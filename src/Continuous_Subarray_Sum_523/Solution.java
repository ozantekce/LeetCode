package Continuous_Subarray_Sum_523;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},6));
        System.out.println(checkSubarraySum(new int[]{5,0,0,0},3));
        //System.out.println(checkSubarraySum(new int[]{23,2,6,4,7},6));
        //System.out.println(checkSubarraySum(new int[]{23,2,6,4,7},13));
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,6},7));
        System.out.println(checkSubarraySum(new int[]{1,2,3},5));
        //System.out.println(checkSubarraySum(new int[]{5,0,0,0},3));
        //System.out.println(checkSubarraySum(new int[]{0,1,0,3,0,4,0,4,0},5));

    }




    public static boolean checkSubarraySum(int[] nums, int k) {

        if(nums.length == 1){
            return false;
        }

        int n = nums.length;
        int [] prefSums = new int[n];
        prefSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefSums[i] = prefSums[i-1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prefSums[i] %= k;
            if(i != 0 && prefSums[i] == 0)
                return true;
            else if(map.containsKey(prefSums[i])){
                int firstPos = map.get(prefSums[i]);
                if(i - firstPos > 1)
                    return true;
            }else{
                map.put(prefSums[i], i);
            }
        }

        return false;
    }





}
