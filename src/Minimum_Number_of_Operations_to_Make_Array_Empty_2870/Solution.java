package Minimum_Number_of_Operations_to_Make_Array_Empty_2870;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println(minOperations(new int[]{2,1,2,2,3,3}));

    }



    public static int minOperations(int[] nums) {

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i],0)+1);
        }
        int res = 0;
        for (var pair : counter.entrySet()) {
            int count = pair.getValue();
            int moves = isPossible(count);
            if(moves == -1)
                return -1;
            res += moves;
        }

        return res;
    }


    private static int isPossible(int count){

        if(count < 2)
            return -1;
        else if(count == 3)
            return 1;
        else if(count == 2)
            return 1;

        int res = isPossible(count - 3);
        if(res == -1){
            res = isPossible(count - 2);
        }
        if(res != -1){
            return res + 1;
        }else{
            return -1;
        }

    }



}
