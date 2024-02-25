package Split_Array_into_Consecutive_Subsequences_659;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        int [] nums0 = new int[]{1,2,3,3,4,5};
        System.out.println(isPossible2(nums0));



        int [] nums1 = new int[]{1,2,3,3,4,4,5,5};
        System.out.println(isPossible2(nums1));



        int [] nums2 = new int[]{1,2,3,5,5,6,7};
        System.out.println(isPossible2(nums2));



        int [] nums3 = new int[]{1,2,3,4,5,5,6,7};
        System.out.println(isPossible2(nums3));



        int [] nums4 = new int[]{8,9,10,11,12,13,14,15,16,17};
        System.out.println(isPossible2(nums4));

        int [] nums5 = new int[]{1,8,9,10,11,12,13,14,15,16};
        System.out.println(isPossible2(nums5));

    }


    public static boolean isPossible(int[] nums) {

        HashMap<Integer, Integer> availableCounter = new HashMap<>();
        HashMap<Integer, Integer> needCounter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            availableCounter.put(nums[i],availableCounter.getOrDefault(nums[i],0) + 1);
        }


        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            int available = availableCounter.get(nums[i]);
            int need = needCounter.getOrDefault(value, 0);

            if(available <= 0) continue;

            int next1Value = value + 1;
            int next2Value = value + 2;
            int next3Value = value + 3;

            if(need > 0){
                availableCounter.put(value, available - 1);
                needCounter.put(value, need - 1);
                needCounter.put(next1Value, needCounter.getOrDefault(next1Value,0) + 1);
            }
            else if(availableCounter.getOrDefault(next1Value,0) > 0 &&
                    availableCounter.getOrDefault(next2Value,0) > 0){

                availableCounter.put(value, available - 1);
                availableCounter.put(next1Value, availableCounter.getOrDefault(next1Value,0)-1);
                availableCounter.put(next2Value, availableCounter.getOrDefault(next2Value,0)-1);

                needCounter.put(next2Value + 1, needCounter.getOrDefault(next2Value + 1, 0 ) + 1);

            }else{
                return false;
            }

        }


        return true;
    }



    public static boolean isPossible2(int[] nums) {

        HashMap<Integer, Integer> needCounter = new HashMap<>();
        HashMap<Integer, Integer> nextLastValue = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];

            if(needCounter.getOrDefault(value-1,0) > 0) return false;

            if(needCounter.getOrDefault(value, 0) > 0){
                needCounter.put(value, needCounter.get(value) - 1);
                if(needCounter.get(value) == 0){
                    needCounter.remove(value);
                }
            }else if(nextLastValue.getOrDefault(value,0) > 0){
                nextLastValue.put(value,nextLastValue.get(value)-1);
                nextLastValue.put(value+1,nextLastValue.getOrDefault(value+1,0)+1);
            }else{
                needCounter.put(value+1,needCounter.getOrDefault(value+1,0)+1);
                needCounter.put(value+2,needCounter.getOrDefault(value+2,0)+1);
                nextLastValue.put(value+3,nextLastValue.getOrDefault(value+3,0)+1);
            }

        }


        return needCounter.isEmpty();
    }


}
