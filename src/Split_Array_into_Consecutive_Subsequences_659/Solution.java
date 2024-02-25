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


    public static boolean isPossible2(int[] nums) {

        HashMap<Integer, Integer> needCounter = new HashMap<>();
        HashMap<Integer, Integer> nextLastValue = new HashMap<>();

        Queue<Integer> nextMinNeed = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];

            if(!nextMinNeed.isEmpty() && value > nextMinNeed.peek()) return false;

            if(needCounter.getOrDefault(value, 0) > 0){
                needCounter.put(value, needCounter.get(value) - 1);
                if(needCounter.get(value) == 0){
                    if(!nextMinNeed.isEmpty() && value == nextMinNeed.peek()){
                        needCounter.remove(value);
                        nextMinNeed.poll();
                    }
                }
            }else if(nextLastValue.getOrDefault(value,0) > 0){
                nextLastValue.put(value,nextLastValue.get(value)-1);
                nextLastValue.put(value+1,nextLastValue.getOrDefault(value+1,0)+1);
            }else{
                if(!needCounter.containsKey(value+1)){
                    nextMinNeed.add(value+1);
                }
                if(!needCounter.containsKey(value+2)){
                    nextMinNeed.add(value+2);
                }
                needCounter.put(value+1,needCounter.getOrDefault(value+1,0)+1);
                needCounter.put(value+2,needCounter.getOrDefault(value+2,0)+1);
                nextLastValue.put(value+3,nextLastValue.getOrDefault(value+3,0)+1);
            }

        }

        return nextMinNeed.isEmpty();
    }


}
