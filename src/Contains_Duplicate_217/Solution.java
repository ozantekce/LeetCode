package Contains_Duplicate_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {


        int[]nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));

    }

    //O(n)
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }

        return false;
    }

/*
    //O(nlogn)
    public static boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i]==nums[i+1]){
                return true;
            }

        }

        return false;
    }
*/



}
