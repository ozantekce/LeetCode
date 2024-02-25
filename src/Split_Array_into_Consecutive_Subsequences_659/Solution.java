package Split_Array_into_Consecutive_Subsequences_659;

import java.util.*;

public class Solution {


    public static void main(String[] args) {



        int [] nums0 = new int[]{1,2,3,3,4,5};
        System.out.println(isPossible(nums0));



        int [] nums1 = new int[]{1,2,3,3,4,4,5,5};
        System.out.println(isPossible(nums1));



        int [] nums2 = new int[]{1,2,3,5,5,6,7};
        System.out.println(isPossible(nums2));


/*
        int [] nums3 = new int[]{1,2,3,4,5,5,6,7};
        System.out.println(isPossible(nums3));



        int [] nums4 = new int[]{8,9,10,11,12,13,14,15,16,17};
        System.out.println(isPossible(nums4));
*/
    }


    public static boolean isPossible(int[] nums) {

        HashMap<Integer, Integer> availableCounter = new HashMap<>();
        HashMap<Integer, Integer> needCounter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            availableCounter.put(nums[i],availableCounter.getOrDefault(nums[i],0) + 1);
        }


        for (int i = 0; i < nums.length; i++) {

            int currentValue = nums[i];
            int currentCount = availableCounter.get(nums[i]);
            int needCount = needCounter.getOrDefault(currentValue, 0);


            if(currentCount <= 0) continue;

            int next1 = currentValue + 1;
            int next2 = currentValue + 2;

            if(needCount > 0){
                availableCounter.put(currentValue, currentCount - 1);
                needCounter.put(currentValue, needCount - 1);
                needCounter.put(next1, needCounter.getOrDefault(next1,0) + 1);
            }
            else if(availableCounter.getOrDefault(next1,0) > 0 &&
                    availableCounter.getOrDefault(next2,0) > 0){

                availableCounter.put(currentValue, currentCount - 1);
                availableCounter.put(next1, availableCounter.getOrDefault(next1,0)-1);
                availableCounter.put(next2, availableCounter.getOrDefault(next2,0)-1);

                needCounter.put(next2 + 1, needCounter.getOrDefault(next2 + 1, 0 ) + 1);

            }else{
                return false;
            }

        }


        return true;
    }





}
